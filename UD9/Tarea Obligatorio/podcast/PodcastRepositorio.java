package podcast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class PodcastRepositorio {
  private HashMap<Integer, Autor> autoresCache;
  private HashMap<Integer, Genero> generosCache;
  private JdbcRowSet jrs;

  public PodcastRepositorio (){
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
  }

  public void close(){
    try {
      jrs.close();
    } catch (Exception e) {
      System.out.println("Error al cerrar la conexion: " + e.getMessage());
    }
  }

  public Autor getAutor(int id){
    try {
      jrs.setCommand("SELECT * FROM autor WHERE id = ?");
      jrs.setInt(1, id);
      jrs.execute();
      if(jrs.next()){
        return new Autor(jrs.getInt(1), jrs.getString(2), jrs.getString(3), jrs.getString(4));
      }
    } catch (Exception e) {
      System.out.println("Error al obtener autor: " + e.getMessage());
    }
    return null;
  }

  public Genero getGenero(int id){
    try {
      jrs.setCommand("SELECT * FROM genero WHERE id = ?");
      jrs.setInt(1, id);
      jrs.execute();
      if(jrs.next()){
        return new Genero(jrs.getInt(1), jrs.getString(2));
      }
    } catch (Exception e) {
      System.out.println("Error al obtener genero: " + e.getMessage());
    }
    return null;
  }

  public boolean insertPodcast(Podcast p){
    try {
      jrs.setCommand("INSERT INTO podcast (titulo, tipo, duracion, periocidad, id_autor) VALUES (?, ?, ?, ?, ?)");
      jrs.setString(1, p.getTitulo());
      jrs.setInt(2, p.getTipo());
      jrs.setInt(3, p.getDuracion());
      jrs.setString(4, p.getPeriocidad());
      jrs.setInt(5, p.getAutor().getId());
      jrs.execute();
      return true;
    } catch (Exception e) {
      System.out.println("Error al insertar podcast: " + e.getMessage());
      return false;
    }
  }

  public boolean newGenPodcast(Genero g){
    try{
      jrs.setCommand("INSERT INTO genero (nombre) VALUES (?)");
      jrs.setString(1, g.getNombre());
      jrs.execute();
      return true;
    }catch(Exception e){
      System.out.println("Error al insertar genero: " + e.getMessage());
      return false;
    }
  }

  public boolean updatePodcast(Podcast p){
return true;
  }

  public boolean deletePodcast(Podcast p){
return true;
  }

  public List<Podcast> viewAllPodcast(){
return null;
  }

  public Podcast findByIdPodcast(int id){
    updateCacheGeneros();
    updateCacheAutores();
    try {
      jrs.setCommand("SELECT * FROM genero_podcast WHERE id_podcast = ?");
      jrs.setInt(1, id);
      jrs.execute();
      List<Genero> generos = new ArrayList<>();
      while(jrs.next()){
        generos.add(generosCache.get(jrs.getInt(2)));
      }
      jrs.setCommand("SELECT * FROM podcast WHERE id = ?");
      jrs.setInt(1, id);
      jrs.execute();
      if(jrs.next()){
        if(jrs.getInt(3)==0){
          return new PodcastAudio(jrs.getInt(1), jrs.getString(2), jrs.getInt(3), jrs.getInt(5), jrs.getString(6), autoresCache.get(jrs.getInt(8)), generos,jrs.getString(4));
        }
      }
    } catch (Exception e) {
      System.out.println("Error al obtener podcast: " + e.getMessage());
    }
  }

  private void updateCacheGeneros(){
    try {
      jrs.setCommand("SELECT * FROM genero");
      jrs.execute();
      generosCache.clear();
      while(jrs.next()){
        generosCache.put(jrs.getInt(1),new Genero(jrs.getInt(1), jrs.getString(2)));
      }
    } catch (Exception e) {
      System.out.println("Error al obtener generos: " + e.getMessage());
    }
  }

  private void updateCacheAutores(){
    try{
      jrs.setCommand("SLECT * from autor");
      jrs.execute();
      autoresCache.clear();
      while(jrs.next()){
        autoresCache.put(jrs.getInt(1),new Autor(jrs.getInt(1), jrs.getString(2), jrs.getString(3), jrs.getString(4)));
      }
    } catch (Exception e) {
      System.out.println("Error al obtener autores: " + e.getMessage());
    }
  }
}
