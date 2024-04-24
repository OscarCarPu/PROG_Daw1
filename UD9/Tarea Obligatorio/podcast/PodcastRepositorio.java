package podcast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class PodcastRepositorio {
  private HashMap<Integer, Autor> autoresCache;
  private HashMap<Integer, Genero> generosCache;
  private HashMap<Integer, List<Genero>> generosPodcastCache;
  private JdbcRowSet jrs;

  public PodcastRepositorio() {
    try {
      jrs = RowSetProvider.newFactory().createJdbcRowSet();
      jrs.setUrl("jdbc:mariadb://dbalumnos.sanclemente.local:3314/podcast_a23OscarCP");
      jrs.setUsername("alumno");
      jrs.setPassword("abc123..");
      jrs.setCommand("SELECT * FROM podcast");
      jrs.execute();
    } catch (Exception e) {
      System.out.println("Error al conectar a la base de datos: " + e.getMessage());
      System.exit(1);
    }
    generosCache = new HashMap<>();
    autoresCache = new HashMap<>();
    generosPodcastCache = new HashMap<>();
  }

  public void close() {
    try {
      jrs.close();
    } catch (Exception e) {
      System.out.println("Error al cerrar la conexion: " + e.getMessage());
    }
  }

  public Autor getAutor(int id) {
    try {
      jrs.setCommand("SELECT * FROM autor WHERE id = ?");
      jrs.setInt(1, id);
      jrs.execute();
      if (jrs.next()) {
        return new Autor(jrs.getInt(1), jrs.getString(2), jrs.getString(3), jrs.getString(4));
      }
    } catch (Exception e) {
      System.out.println("Error al obtener autor: " + e.getMessage());
    }
    return null;
  }

  public Genero getGenero(int id) {
    try {
      jrs.setCommand("SELECT * FROM genero WHERE id = ?");
      jrs.setInt(1, id);
      jrs.execute();
      if (jrs.next()) {
        return new Genero(jrs.getInt(1), jrs.getString(2));
      }
    } catch (Exception e) {
      System.out.println("Error al obtener genero: " + e.getMessage());
    }
    return null;
  }

  public boolean insertPodcast(Podcast p) {
    try {
      if (p.getTipo() == 0) {
        jrs.setCommand(
            "INSERT INTO podcast (titulo, tipo, duracion, periocidad, id_autor, calidad) VALUES (?, ?, ?, ?, ?, ?)");
        jrs.setString(6, ((PodcastAudio) p).getCalidad());
        jrs.setString(1, p.getTitulo());
        jrs.setInt(2, p.getTipo());
        jrs.setInt(3, p.getDuracion());
        jrs.setString(4, p.getPeriocidad());
        jrs.setInt(5, p.getAutor().getId());

      } else {
        jrs.setCommand(
            "INSERT INTO podcast (titulo, tipo, duracion, periocidad, id_autor, formato_video) VALUES (?, ?, ?, ?, ?, ?)");
        jrs.setString(6, ((PodcastVideo) p).getFormato_video());
        jrs.setString(1, p.getTitulo());
        jrs.setInt(2, p.getTipo());
        jrs.setInt(3, p.getDuracion());
        jrs.setString(4, p.getPeriocidad());
        jrs.setInt(5, p.getAutor().getId());
      }
      jrs.execute();

      jrs.setCommand("SELECT MAX(id) FROM podcast");
      jrs.execute();
      if (jrs.next()) {
        p.setId(jrs.getInt(1));
      }

      for (Genero g : p.getGeneros()) {
        jrs.setCommand("INSERT INTO genero_podcast (id_genero, id_podcast) VALUES (?, ?)");
        jrs.setInt(1, g.getId());
        jrs.setInt(2, p.getId());
        jrs.execute();
      }
      return true;
    } catch (Exception e) {
      System.out.println("Error al insertar podcast: " + e.getMessage());
      return false;
    }
  }

  public boolean newGenPodcast(Genero g) {
    try {
      jrs.setCommand("INSERT INTO genero (nombre) VALUES (?)");
      jrs.setString(1, g.getNombre());
      jrs.execute();
      return true;
    } catch (Exception e) {
      System.out.println("Error al insertar genero: " + e.getMessage());
      return false;
    }
  }

  public boolean updatePodcast(Podcast p) {
    try {
      jrs.setCommand(
          "UPDATE podcast SET titulo = ?, tipo = ?, duracion = ?, periocidad = ?, id_autor = ? WHERE id = ?");
      jrs.setString(1, p.getTitulo());
      jrs.setInt(2, p.getTipo());
      jrs.setInt(3, p.getDuracion());
      jrs.setString(4, p.getPeriocidad());
      jrs.setInt(5, p.getAutor().getId());
      jrs.setInt(6, p.getId());
      jrs.execute();
      if (p.getTipo() == 0) {
        jrs.setCommand("UPDATE podcast SET calidad = ? WHERE id = ?");
        jrs.setString(1, ((PodcastAudio) p).getCalidad());
        jrs.setInt(2, p.getId());
        jrs.execute();
      } else {
        jrs.setCommand("UPDATE podcast SET formato_video = ? WHERE id = ?");
        jrs.setString(1, ((PodcastVideo) p).getFormato_video());
        jrs.setInt(2, p.getId());
        jrs.execute();
      }
      jrs.setCommand("DELETE FROM genero_podcast WHERE id_podcast = ?");
      jrs.setInt(1, p.getId());
      jrs.execute();
      for (Genero g : p.getGeneros()) {
        jrs.setCommand("INSERT INTO genero_podcast (id_genero, id_podcast) VALUES (?, ?)");
        jrs.setInt(1, g.getId());
        jrs.setInt(2, p.getId());
        jrs.execute();
      }
      return true;
    } catch (Exception e) {
      System.out.println("Error al actualizar podcast: " + e.getMessage());
      return false;
    }
  }

  public boolean deletePodcast(Podcast p) {
    try {
      jrs.setCommand("DELETE FROM genero_podcast WHERE id_podcast = ?");
      jrs.setInt(1, p.getId());
      jrs.execute();

      jrs.setCommand("DELETE FROM podcast WHERE id = ?");
      jrs.setInt(1, p.getId());
      jrs.execute();
      return true;
    } catch (Exception e) {
      System.out.println("Error al eliminar podcast: " + e.getMessage());
      return false;
    }
  }

  public List<Podcast> viewAllPodcast() {
    List<Podcast> podcasts = new ArrayList<>();
    updateCacheGeneros();
    updateCacheAutores();
    try {
      updateGenerosPodcastCache();
      jrs.setCommand("SELECT * FROM podcast");
      jrs.execute();
      while (jrs.next()) {
        if (jrs.getInt(3) == 0) {
          podcasts.add(new PodcastAudio(jrs.getInt(1), jrs.getString(2), jrs.getInt(3), jrs.getInt(5), jrs.getString(6),
              autoresCache.get(jrs.getInt(8)), generosPodcastCache.get(jrs.getInt(1)), jrs.getString(4)));
        } else {
          podcasts.add(new PodcastVideo(jrs.getInt(1), jrs.getString(2), jrs.getInt(3), jrs.getInt(5), jrs.getString(6),
              autoresCache.get(jrs.getInt(8)), generosPodcastCache.get(jrs.getInt(1)), jrs.getString(7)));
        }
      }
      return podcasts;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public Podcast findByIdPodcast(int id) {
    updateCacheGeneros();
    updateCacheAutores();
    try {
      jrs.setCommand("SELECT * FROM genero_podcast WHERE id_podcast = ?");
      jrs.setInt(1, id);
      jrs.execute();
      List<Genero> generos = new ArrayList<>();
      while (jrs.next()) {
        generos.add(generosCache.get(jrs.getInt(2)));
      }
      jrs.setCommand("SELECT * FROM podcast WHERE id = ?");
      jrs.setInt(1, id);
      jrs.execute();
      if (jrs.next()) {
        if (jrs.getInt(3) == 0) {
          return new PodcastAudio(jrs.getInt(1), jrs.getString(2), jrs.getInt(3), jrs.getInt(5), jrs.getString(6),
              autoresCache.get(jrs.getInt(8)), generos, jrs.getString(4));
        } else {
          return new PodcastVideo(jrs.getInt(1), jrs.getString(2), jrs.getInt(3), jrs.getInt(5), jrs.getString(6),
              autoresCache.get(jrs.getInt(8)), generos, jrs.getString(7));

        }
      }
    } catch (Exception e) {
      System.out
          .println("Error al obtener podcast: " + e.getMessage() + ", line: " + e.getStackTrace()[0].getLineNumber());
    }
    return null;
  }

  private void updateCacheGeneros() {
    try {
      jrs.setCommand("SELECT * FROM genero");
      jrs.execute();
      generosCache.clear();
      while (jrs.next()) {
        generosCache.put(jrs.getInt(1), new Genero(jrs.getInt(1), jrs.getString(2)));
      }
    } catch (Exception e) {
      System.out.println("Error al obtener generos: " + e.getMessage());
    }
  }

  private void updateCacheAutores() {
    try {
      jrs.setCommand("SELECT * from autor");
      jrs.execute();
      autoresCache.clear();
      while (jrs.next()) {
        autoresCache.put(jrs.getInt(1), new Autor(jrs.getInt(1), jrs.getString(2), jrs.getString(3), jrs.getString(4)));
      }
    } catch (Exception e) {
      System.out.println("Error al obtener autores: " + e.getMessage());
    }
  }

  private void updateGenerosPodcastCache() {
    updateCacheGeneros();
    try {
      jrs.setCommand("SELECT * FROM genero_podcast");
      jrs.execute();
      generosPodcastCache.clear();
      while (jrs.next()) {
        if (generosPodcastCache.containsKey(jrs.getInt(1))) {
          generosPodcastCache.get(jrs.getInt(1)).add(generosCache.get(jrs.getInt(2)));
        } else {
          List<Genero> generos = new ArrayList<>();
          generos.add(generosCache.get(jrs.getInt(2)));
          generosPodcastCache.put(jrs.getInt(1), generos);
        }
      }
    } catch (Exception e) {
      System.out.println("Error al obtener generos de podcast: " + e.getMessage());
    }
  }

  public void setNavTo(int id) {
    updateGenerosPodcastCache();
    try {
      jrs.setCommand("SELECT * FROM podcast");
      jrs.execute();
      while (jrs.next()) {
        if (jrs.getInt(1) == id) {
          break;
        }
      }
    } catch (Exception e) {
      System.out.println("Error al navegar: " + e.getMessage());
    }
  }

  public void nextPodcast() {
    try {
      if (!jrs.next()) {
        System.out.println("Ya estas en el ultimo podcast");
      }
    } catch (Exception e) {
      System.out.println("Error al navegar: " + e.getMessage());
    }
  }

  public void prevPodcast() {
    try {
      if (!jrs.previous()) {
        System.out.println("Ya estas en el primer podcast");
      }
    } catch (Exception e) {
      System.out.println("Error al navegar: " + e.getMessage());
    }
  }

  public Podcast getPodcast() {
    try {

      if (jrs.getInt(3) == 0) {
        return new PodcastAudio(jrs.getInt(1), jrs.getString(2), jrs.getInt(3), jrs.getInt(5), jrs.getString(6),
            autoresCache.get(jrs.getInt(8)), generosPodcastCache.get(jrs.getInt(1)), jrs.getString(4));
      } else {
        return new PodcastVideo(jrs.getInt(1), jrs.getString(2), jrs.getInt(3), jrs.getInt(5), jrs.getString(6),
            autoresCache.get(jrs.getInt(8)), generosPodcastCache.get(jrs.getInt(1)), jrs.getString(7));
      }
    } catch (Exception e) {
      System.out.println("Error al obtener podcast: " + e.getMessage());
    }
    return null;
  }
}
