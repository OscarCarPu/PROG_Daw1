package podcast;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
  
  private static PodcastRepositorio repo;
  private static Scanner in;
  public static void main(String[] args){
    System.out.println("Iniciando programa");
    repo = new PodcastRepositorio();
    int option = 0;
    in = new Scanner(System.in);
    do{
      printMenu();
      option = in.nextInt();
      switch(option){
        case 1:
          insertarPodcast();
          break;
        case 2:
          break;
        case 3:
          break;
        case 4:
          break;
        case 5:
          break;
        case 6:
          break;
        case 0:
          break;
        default:
          System.out.println("Opcion no valida");
          break;
      }
    }while(option!=0);
    System.out.println("Saliendo del programa");
    in.close();
  }

  public static void printMenu(){
    System.out.println("Selecciona una opción");
    System.out.println("0 - Salir");
    System.out.println("1 - Agregar nuevo podcast");
    System.out.println("2 - Dar de alta nuevo género");
    System.out.println("3 - Asignar género a podcast");
    System.out.println("4 - Eliminar podcast");
    System.out.println("5 - Visualizar podcast");
    System.out.println("6 - Recorrer podcast");
  }

  public static void insertarPodcast(){
    System.out.println("Introduce el id del podcast");
    int idPodcast = in.nextInt();
    System.out.println("Introduce el titulo del podcast");
    String titulo = in.nextLine();
    System.out.println("Introduce el tipo del podcast");
    int tipo = in.nextInt();
    System.out.println("Introduce la calidad del podcast");
    String calidad = in.nextLine();
    System.out.println("Introduce la duracion del podcast");
    int duracion = in.nextInt();
    System.out.println("Introduce la periocidad del podcast");
    String periocidad = in.nextLine();
    System.out.println("Introduce el formato del video del podcast");
    String formato_video = in.nextLine();
   System.out.println("Introduce el autor del podcast");
    int idAutor = in.nextInt();
    Autor autor = repo.findByIdAutor(idAutor);
    int idGeneros = 0;
    List<Genero> generos = new ArrayList<Genero>();
    while(idGeneros>=0){
      System.out.println("Introduce el id del genero del podcast, -1 para salir");
      idGeneros = in.nextInt();
      if(idGeneros>=0){
        generos.add(repo.findByIdGenero(idGeneros));
      }
    }
    Podcast podcast = new Podcast(idPodcast, titulo, tipo, calidad, duracion, periocidad, formato_video, autor, generos);
    if(repo.insertPodcast(podcast)){
      System.out.println("Podcast creado correctamente");
    }
    else{
      System.out.println("Error al crear podcast");
    }
  }

  public static void nuevoGenero(){
    System.out.println("Introduce el id del genero");
    int idGenero = in.nextInt();
    System.out.println("Introduce el nombre del genero");
    String nombre = in.nextLine();
    Genero genero = new Genero(idGenero, nombre);
    if(repo.newGenPodcast(genero)){
      System.out.println("Genero creado correctamente");
    }
    else{
      System.out.println("Error al crear genero");
    }
  }

  public static void asignarGenero(){
    System.out.println("Introduce el id del podcast");
    int idPodcast = in.nextInt();
    System.out.println("Introduce el id del genero");
    int idGenero = in.nextInt();
    if(repo.asignarGenero(idPodcast, idGenero)){
      System.out.println("Genero asignado correctamente");
    }
    else{
      System.out.println("Error al asignar genero");
    }
  }

  public static void eliminarPodcast(){
    System.out.println("Introduce el id del podcast");
    int idPodcast = in.nextInt();
    if(repo.deletePodcast(repo.findByIdPodcast(idPodcast))){
      System.out.println("Podcast eliminado correctamente");
    }
    else{
      System.out.println("Error al eliminar podcast");
    }
  }

  public static void visualizarPodcasts(){
    List<Podcast> podcasts = repo.viewAllPodcast();
    for(Podcast p: podcasts){
      System.out.println("ID: " + p.getIdPodcast() + " Titulo: " + p.getTitulo() + " Tipo: " + p.getTipo() + " Calidad: " + p.getCalidad() + " Duracion: " + p.getDuracion() + " Periocidad: " + p.getPeriocidad() + " Formato video: " + p.getFormato_video() + " Autor: " + p.getAutor().getNombre() + " Generos: ");
      for(Genero g: p.getGeneros()){
        System.out.println("ID: " + g.getIdGeneros() + " Nombre: " + g.getNombre());
      }
    }
  }

  public static void recorrerPodcasts(){
    System.out.println("Introduce el id del podcast");
    int idPodcast = in.nextInt();
    Podcast p = repo.findByIdPodcast(idPodcast);
    System.out.println("ID: " + p.getIdPodcast() + " Titulo: " + p.getTitulo() + " Tipo: " + p.getTipo() + " Calidad: " + p.getCalidad() + " Duracion: " + p.getDuracion() + " Periocidad: " + p.getPeriocidad() + " Formato video: " + p.getFormato_video() + " Autor: " + p.getAutor().getNombre() + " Generos: ");
    for(Genero g: p.getGeneros()){
      System.out.println("ID: " + g.getIdGeneros() + " Nombre: " + g.getNombre());
    }
  }
}
