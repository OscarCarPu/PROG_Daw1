package podcast;

import java.util.List;

public class PodcastVideo extends Podcast {
  private String formato_video;

  public PodcastVideo(int id, String titulo, int tipo, int duracion, String periocidad, Autor autor,
      List<Genero> generos, String formato_video) {
    super(id, titulo, tipo, duracion, periocidad, autor, generos);
    this.formato_video = formato_video;
  }

  public PodcastVideo(String titulo, int tipo, int duracion, String periocidad, Autor autor, List<Genero> generos,
      String formato_video) {
    super(titulo, tipo, duracion, periocidad, autor, generos);
    this.formato_video = formato_video;
  }

  public PodcastVideo() {

  }

  public String getFormato_video() {
    return formato_video;
  }

  public void setFormato_video(String formato_video) {
    this.formato_video = formato_video;
  }

  @Override
  public String toString() {
    return super.toString() + " - Formato: " + formato_video;
  }
}
