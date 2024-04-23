package podcast;

import java.util.List;

public class Podcast {
  private int id;
  private String titulo;
  private int tipo;
  private int duracion;
  private String periocidad;
  private Autor autor;
  private List<Genero> generos;

  public Podcast (int id, String titulo, int tipo, int duracion, String periocidad, Autor autor, List<Genero> generos) {
    this.id = id;
    this.titulo = titulo;
    this.tipo = tipo;
    this.duracion = duracion;
    this.periocidad = periocidad;
    this.autor = autor;
    this.generos = generos;
  }

  public Podcast(String titulo, int tipo, int duracion, String periocidad, Autor autor, List<Genero> generos) {
    this.titulo = titulo;
    this.tipo = tipo;
    this.duracion = duracion;
    this.periocidad = periocidad;
    this.autor = autor;
    this.generos = generos;
  }

  public Podcast () {

  }

  public int getId () {
    return id;
  }

  public void setId (int id) {
    this.id = id;
  }

  public String getTitulo () {
    return titulo;
  }

  public void setTitulo (String titulo) {
    this.titulo = titulo;
  }

  public int getTipo () {
    return tipo;
  }

  public void setTipo (int tipo) {
    this.tipo = tipo;
  }

  public int getDuracion () {
    return duracion;
  }

  public void setDuracion (int duracion) {
    this.duracion = duracion;
  }

  public String getPeriocidad () {
    return periocidad;
  }

  public void setPeriocidad (String periocidad) {
    this.periocidad = periocidad;
  }

  public Autor getAutor () {
    return autor;
  }

  public void setAutor (Autor autor) {
    this.autor = autor;
  }

  public List<Genero> getGeneros () {
    return generos;
  }

  public void setGeneros (List<Genero> generos) {
    this.generos = generos;
  }
}
