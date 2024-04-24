package podcast;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class App {

  private static PodcastRepositorio pr;
  private static Scanner in;

  public static void main(String[] args) {
    pr = new PodcastRepositorio();
    in = new Scanner(System.in);

    int opcion = 0;

    do {
      printMenu();
      opcion = in.nextInt();
      in.nextLine();
      switch (opcion) {
        case 1:
          agregarPodcast();
          break;
        case 2:
          agregarGenero();
          break;
        case 3:
          updateGenerosPodcast();
          break;
        case 4:
          eliminarPodcast();
          break;
        case 5:
          listarPodcasts();
          break;
        case 6:
          navegarPodcasts();
          break;
        case 0:
          System.out.println("Adios!");
          break;
        default:
          System.out.println("Opcion no valida");
      }
    } while (opcion != 0);

    in.close();

    pr.close();
  }

  private static void printMenu() {
    System.out.println("0 - Salir");
    System.out.println("1 - Agregar Podcast");
    System.out.println("2 - Dar de alta genero");
    System.out.println("3 - Actualizar generos de un podcast");
    System.out.println("4 - Eliminar un podcast");
    System.out.println("5 - Listar podcasts");
    System.out.println("6 - Navegar por podcasts");
  }

  private static void agregarPodcast() {
    System.out.println("Titulo: ");
    String titulo = in.nextLine();
    int tipo = -1;
    while (tipo != 0 && tipo != 1) {
      try {
        System.out.println("Tipo (0 - Audio, 1 - Video): ");
        tipo = in.nextInt();
        in.nextLine();
      } catch (Exception e) {
        System.out.println("Tipo no valido");
        in.nextLine();
      }
      if (tipo != 0 && tipo != 1) {
        System.out.println("Tipo no valido");
      }
    }
    String variable;
    if (tipo == 0) {
      System.out.println("Calidad: ");
      variable = in.nextLine();
    } else {
      System.out.println("Formato: ");
      variable = in.nextLine();
    }

    System.out.println("Duracion: ");
    int duracion = -1;
    while (duracion < 0) {
      try {
        duracion = in.nextInt();
        in.nextLine();
      } catch (Exception e) {
        System.out.println("Duracion no valida");
        in.nextLine();
      }
      if (duracion < 0) {
        System.out.println("Duracion no valida");
      }
    }
    System.out.println("Periocidad: ");
    String periocidad = in.nextLine();
    Autor autor = null;
    do {
      System.out.println("Id de autor: ");
      int idAutor = in.nextInt();
      in.nextLine();
      autor = pr.getAutor(idAutor);
      if (autor == null) {
        System.out.println("Autor no encontrado");
      }
    } while (autor == null);
    List<Genero> generos = new ArrayList<>();
    int idGenero = 0;
    do {
      System.out.println("Id de genero (0 para terminar): ");
      idGenero = in.nextInt();
      in.nextLine();
      if (idGenero != 0) {
        Genero genero = pr.getGenero(idGenero);
        if (genero == null) {
          System.out.println("Genero no encontrado");
        } else {
          generos.add(genero);
        }
      }
    } while (idGenero != 0);

    Podcast podcast = null;

    if (tipo == 0) {
      podcast = new PodcastAudio(titulo, tipo, duracion, periocidad, autor, generos, variable);
    } else {
      podcast = new PodcastVideo(titulo, tipo, duracion, periocidad, autor, generos, variable);
    }

    if (pr.insertPodcast(podcast)) {
      System.out.println("Podcast insertado");
    } else {
      System.out.println("Error al insertar podcast");
    }
  }

  private static void agregarGenero() {
    try {
      System.out.println("Nombre de genero: ");
      String nombre = in.nextLine();
      Genero genero = new Genero(nombre);
      if (pr.newGenPodcast(genero)) {
        System.out.println("Genero insertado");
      } else {
        System.out.println("Error al insertar genero");
      }
    } catch (Exception e) {
      System.out.println("Error al insertar genero: " + e.getMessage());
    }
  }

  private static void updateGenerosPodcast() {
    try {
      Podcast p = null;
      do {
        System.out.println("Id de podcast: ");
        int idPodcast = in.nextInt();
        in.nextLine();
        p = pr.findByIdPodcast(idPodcast);
        if (p == null) {
          System.out.println("Podcast no encontrado");
        }

      } while (p == null);

      List<Genero> generos = new ArrayList<>();

      int idGenero = 0;

      do {
        System.out.println("Id de genero (0 para terminar): ");
        idGenero = in.nextInt();
        in.nextLine();
        if (idGenero != 0) {
          Genero genero = pr.getGenero(idGenero);
          if (genero == null) {
            System.out.println("Genero no encontrado");
          } else {
            generos.add(genero);
          }
        }
      } while (idGenero != 0);

      p.setGeneros(generos);

      if (pr.updatePodcast(p)) {
        System.out.println("Podcast actualizado");
      } else {
        System.out.println("Error al actualizar podcast");
      }
    } catch (Exception e) {
      System.out.println("Error al actualizar podcast: " + e.getMessage());
    }
  }

  private static void eliminarPodcast() {
    try {
      Podcast p = null;
      do {
        System.out.println("Id de podcast: ");
        int idPodcast = in.nextInt();
        in.nextLine();
        p = pr.findByIdPodcast(idPodcast);
        if (p == null) {
          System.out.println("Podcast no encontrado");
        }
      } while (p == null);

      if (pr.deletePodcast(p)) {
        System.out.println("Podcast eliminado");
      } else {
        System.out.println("Error al eliminar podcast");
      }
    } catch (Exception e) {
      System.out.println("Error al eliminar podcast: " + e.getMessage());
    }
  }

  private static void listarPodcasts() {
    List<Podcast> podcasts = pr.viewAllPodcast();
    for (Podcast p : podcasts) {
      System.out.println(p);
    }
  }

  private static void navegarPodcasts() {
    System.out.println("Indica el id del podcast inicial: ");
    int id = -1;
    while (id < 0) {
      try {
        id = in.nextInt();
        in.nextLine();
      } catch (Exception e) {
        System.out.println("Id no valido");
        in.nextLine();
      }
      if (id < 0) {
        System.out.println("Id no valido");
      } else if (pr.findByIdPodcast(id) == null) {
        System.out.println("Podcast no encontrado");
        id = -1;
      }
    }
    pr.setNavTo(id);
    int opcion = 0;
    do {
      System.out.println("1. Siguiente");
      System.out.println("2. Anterior");
      System.out.println("3. Ver podcast");
      System.out.println("0. Salir");
      opcion = in.nextInt();
      in.nextLine();
      switch (opcion) {
        case 1:
          pr.nextPodcast();
          break;
        case 2:
          pr.prevPodcast();
          break;
        case 3:
          System.out.println(pr.getPodcast());
          break;
        case 0:
          break;
        default:
          System.out.println("Opcion no valida");
          break;
      }
    } while (opcion != 0);
  }
}
