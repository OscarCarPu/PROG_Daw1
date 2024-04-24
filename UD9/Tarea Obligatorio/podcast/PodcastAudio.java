package podcast;

import java.util.List;

public class PodcastAudio extends Podcast {
  private String calidad;

  public PodcastAudio(int id, String titulo, int tipo, int duracion, String periocidad, Autor autor,
      List<Genero> generos, String calidad) {
    super(id, titulo, tipo, duracion, periocidad, autor, generos);
    this.calidad = calidad;
  }

  public PodcastAudio(String titulo, int tipo, int duracion, String periocidad, Autor autor, List<Genero> generos,
      String calidad) {
    super(titulo, tipo, duracion, periocidad, autor, generos);
    this.calidad = calidad;
  }

  public PodcastAudio() {

  }

  public String getCalidad() {
    return calidad;
  }

  public void setCalidad(String calidad) {
    this.calidad = calidad;
  }

  @Override
  public String toString() {
    return super.toString() + " - Calidad: " + calidad;
  }
}
