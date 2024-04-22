package podcast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class PodcastRepositorio implements PodcastRepositorioInterfaz {
 
  private JdbcRowSet rowSet = null;

  public PodcastRepositorio() {
    try {
      rowSet = RowSetProvider.newFactory().createJdbcRowSet();
      rowSet.setUrl("jdbc:mariadb://dbalumnos.sanclemente.local:3314/podcast_a23OscarCP");

      rowSet.setUsername("alumno");
      rowSet.setPassword("abc123..");

    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  public boolean insertPodcast(Podcast p){
    try {
      rowSet.setCommand("SELECT * FROM podcast");
      rowSet.execute();
      rowSet.moveToInsertRow();
      rowSet.updateString("titulo", p.getTitulo());
      rowSet.updateInt("tipo", p.getTipo());
      rowSet.updateString("calidad", p.getCalidad());
      rowSet.updateInt("duracion", p.getDuracion());
      rowSet.updateString("periocidad", p.getPeriocidad());
      rowSet.updateString("formato_video", p.getFormato_video());
      rowSet.updateInt("idAutor", p.getAutor().getIdAutor());
      rowSet.insertRow();
      rowSet.moveToCurrentRow();

      rowSet.setCommand("SELECT * FROM gen_pod");
      rowSet.execute();
      for (Genero g : p.getGeneros()) {
        rowSet.moveToInsertRow();
        rowSet.updateInt("idPodcat", p.getIdPodcast());
        rowSet.updateInt("idGenero", g.getIdGeneros());
        rowSet.insertRow();
        rowSet.moveToCurrentRow();
      }
      return true;
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
      return false;
    }
  }

  public boolean newGenPodcast(Genero g){
    try {
      rowSet.setCommand("SELECT * FROM genero");
      rowSet.execute();
      rowSet.moveToInsertRow();
      rowSet.updateString("nombre", g.getNombre());
      rowSet.insertRow();
      rowSet.moveToCurrentRow();
      return true;
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
      return false;
    }
  }

  public boolean updatePodcast(Podcast p){
    try {
      rowSet.setCommand("SELECT * FROM podcast");
      rowSet.execute();
      rowSet.beforeFirst();
      while (rowSet.next()) {
        if (rowSet.getInt("idPodcast") == p.getIdPodcast()) {
          rowSet.updateString("titulo", p.getTitulo());
          rowSet.updateInt("tipo", p.getTipo());
          rowSet.updateString("calidad", p.getCalidad());
          rowSet.updateInt("duracion", p.getDuracion());
          rowSet.updateString("periocidad", p.getPeriocidad());
          rowSet.updateString("formato_video", p.getFormato_video());
          rowSet.updateInt("idAutor", p.getAutor().getIdAutor());
          rowSet.updateRow();
          break;
        }
      }
      rowSet.setCommand("SELECT * FROM gen_pod");
      rowSet.execute();
      rowSet.beforeFirst();
      while (rowSet.next()) {
        if (rowSet.getInt("idPodcat") == p.getIdPodcast()) {
          rowSet.deleteRow();
        }
      }
      for (Genero g : p.getGeneros()) {
        rowSet.moveToInsertRow();
        rowSet.updateInt("idPodcat", p.getIdPodcast());
        rowSet.updateInt("idGenero", g.getIdGeneros());
        rowSet.insertRow();
        rowSet.moveToCurrentRow();
      }
      return true;
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
      return false;
    }
  }

  public boolean deletePodcast(Podcast p){
    try {
      rowSet.setCommand("SELECT * FROM podcast");
      rowSet.execute();
      rowSet.beforeFirst();
      while (rowSet.next()) {
        if (rowSet.getInt("idPodcast") == p.getIdPodcast()) {
          rowSet.deleteRow();
          break;
        }
      }
      rowSet.setCommand("SELECT * FROM gen_pod");
      rowSet.execute();
      rowSet.beforeFirst();
      while (rowSet.next()) {
        if (rowSet.getInt("idPodcat") == p.getIdPodcast()) {
          rowSet.deleteRow();
        }
      }
      return true;
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
      return false;
    }
  }

  public List<Genero> viewAllGenero(){
    try {
      rowSet.setCommand("SELECT * FROM genero");
      rowSet.execute();
      List<Genero> generos = new ArrayList<Genero>();
      while (rowSet.next()) {
        generos.add(new Genero(rowSet.getInt("idGeneros"), rowSet.getString("nombre")));
      }
      return generos;
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
      return null;
    }
  }

  public Genero findByIdGenero(int id){
    try {
      rowSet.setCommand("SELECT * FROM genero");
      rowSet.execute();
      rowSet.beforeFirst();
      while (rowSet.next()) {
        if (rowSet.getInt("idGeneros") == id) {
          return new Genero(rowSet.getInt("idGeneros"), rowSet.getString("nombre"));
        }
      }
      return null;
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
      return null;
    }
  }

  public List<Autor> viewAllAutor(){
    try {
      rowSet.setCommand("SELECT * FROM autor");
      rowSet.execute();
      List<Autor> autores = new ArrayList<Autor>();
      while (rowSet.next()) {
        autores.add(new Autor(rowSet.getInt("idAutor"), rowSet.getString("nombre"), rowSet.getString("apellidos"), rowSet.getString("email")));
      }
      return autores;
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
      return null;
    }
  }

  public Autor findByIdAutor(int id){
    try {
      rowSet.setCommand("SELECT * FROM autor");
      rowSet.execute();
      rowSet.beforeFirst();
      while (rowSet.next()) {
        if (rowSet.getInt("idAutor") == id) {
          return new Autor(rowSet.getInt("idAutor"), rowSet.getString("nombre"), rowSet.getString("apellidos"), rowSet.getString("email"));
        }
      }
      return null;
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
      return null;
    }
  }

  public List<Podcast> viewAllPodcast(){
    try {
      rowSet.setCommand("SELECT * FROM podcast");
      rowSet.execute();
      List<Podcast> podcasts = new ArrayList<Podcast>();
      while (rowSet.next()) {
        List<Genero> generos = new ArrayList<Genero>();
        rowSet.setCommand("SELECT * FROM gen_pod");
        rowSet.execute();
        rowSet.beforeFirst();
        while (rowSet.next()) {
          if (rowSet.getInt("idPodcat") == rowSet.getInt("idPodcast")) {
            generos.add(findByIdGenero(rowSet.getInt("idGenero")));
          }
        }
        podcasts.add(new Podcast(rowSet.getInt("idPodcast"), rowSet.getString("titulo"), rowSet.getInt("tipo"), rowSet.getString("calidad"), rowSet.getInt("duracion"), rowSet.getString("periocidad"), rowSet.getString("formato_video"), findByIdAutor(rowSet.getInt("idAutor")), generos));
      }
      return podcasts;
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
      return null;
    }
  }

  public Podcast findByIdPodcast(int id){
    try {
      rowSet.setCommand("SELECT * FROM podcast");
      rowSet.execute();
      rowSet.beforeFirst();
      while (rowSet.next()) {
        if (rowSet.getInt("idPodcast") == id) {
          List<Genero> generos = new ArrayList<Genero>();
          rowSet.setCommand("SELECT * FROM gen_pod");
          rowSet.execute();
          rowSet.beforeFirst();
          while (rowSet.next()) {
            if (rowSet.getInt("idPodcat") == rowSet.getInt("idPodcast")) {
              generos.add(findByIdGenero(rowSet.getInt("idGenero")));
            }
          }
          return new Podcast(rowSet.getInt("idPodcast"), rowSet.getString("titulo"), rowSet.getInt("tipo"), rowSet.getString("calidad"), rowSet.getInt("duracion"), rowSet.getString("periocidad"), rowSet.getString("formato_video"), findByIdAutor(rowSet.getInt("idAutor")), generos);
        }
      }
      return null;
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
      return null;
    }
  }

  public boolean asignarGenero(int idPodcast, int idGenero){
    try {
      rowSet.setCommand("SELECT * FROM gen_pod");
      rowSet.execute();
      rowSet.moveToInsertRow();
      rowSet.updateInt("idPodcat", idPodcast);
      rowSet.updateInt("idGenero", idGenero);
      rowSet.insertRow();
      rowSet.moveToCurrentRow();
      return true;
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
      return false;
    }
  }

  public Podcast navPodcast(int id){
    try {
      List<Genero> generos = viewAllGenero();
      Podcast pp = findByIdPodcast(id);
      if (pp != null) {
        System.out.println("Podcast: " + pp.getTitulo());
        System.out.println("Tipo: " + pp.getTipo());
        System.out.println("Calidad: " + pp.getCalidad());
        System.out.println("Duracion: " + pp.getDuracion());
        System.out.println("Periocidad: " + pp.getPeriocidad());
        System.out.println("Formato video: " + pp.getFormato_video());
        System.out.println("Autor: " + pp.getAutor().getNombre() + " " + pp.getAutor().getApellidos());
        System.out.println("Generos: ");
        for (Genero g : pp.getGeneros()) {
          System.out.println(g.getNombre());
        }
        return pp;
      }
    }
  }
}