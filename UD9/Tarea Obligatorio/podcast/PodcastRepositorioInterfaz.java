package podcast;

import java.util.List;

public interface PodcastRepositorioInterfaz {
  boolean insertPodcast (Podcast p);
  boolean newGenPodcast (Genero g);
  boolean updatePodcast (Podcast p);
  boolean deletePodcast (Podcast p);
  List<Podcast> viewAllPodcast();
  Podcast findByIdPodcast (int id);
}
