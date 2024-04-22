package podcast;

import java.util.List;

public class Podcast {
  private int idPodcast;
  private String titulo;
  private int tipo;
  private String calidad;
  private int duracion;
  private String periocidad;
  private String formato_video;
  private Autor autor;
  private List<Genero> generos;

  public Podcast (int idPodcast, String titulo, int tipo, String calidad, int duracion, String periocidad, String formato_video, Autor autor, List<Genero> generos) {
    this.idPodcast = idPodcast;
    this.titulo = titulo;
    this.tipo = tipo;
    this.calidad = calidad;
    this.duracion = duracion;
    this.periocidad = periocidad;
    this.formato_video = formato_video;
    this.autor = autor;
    this.generos = generos;
  }

  public Podcast () {
  }

  public int getIdPodcast () {
    return idPodcast;
  }

  public void setIdPodcast (int idPodcast) {
    this.idPodcast = idPodcast;
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

  public String getCalidad () {
    return calidad;
  }

  public void setCalidad (String calidad) {
    this.calidad = calidad;
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

  public String getFormato_video () {
    return formato_video;
  }

  public void setFormato_video (String formato_video) {
    this.formato_video = formato_video;
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
