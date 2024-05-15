package agenda;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Menu {
  
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    try{
      App.getDatosBD();
    } catch (Exception e){
      System.out.println(e.getMessage());
      in.close();
      return;
    }
    mostrarContactos();
    mostrarGrupos();
    int opcion = -1;
    do{
      printMenu();
      opcion = in.nextInt();
      in.nextLine();
      switch(opcion){
        case 1:
          mostrarContactos();
          break;
        case 2:
          mostrarGrupos();
          break;
        case 3:
          crearGrupo(in);
          break;
        case 4:
          mostrarGrupos();
          volcarAArchivo(in);
          break;
        case 5:
          mostrarGrupoFichero(in);
          break;
        case 6:
          mostrarContactos();
          compararContactos(in);
          break;
        case 7:
          mostrarContactosOrdenados(in);
          break;
        default:
          break;
      }
    }while(opcion!=0);
    System.out.println("Quiere eliminar los archivos creados? (s/n)");
    String respuesta = in.nextLine();
    if(respuesta.equals("s")){
      try{
        App.eliminarArchivos();
      } catch (Exception e){
        System.out.println(e.getMessage());
      }
    }
    System.out.println("Cerrando aplicacion");
    in.close();
  }

  public static void printMenu() {
    System.out.println("Seleccione una opcion:");
    System.out.println("------------------------------------");
    System.out.println("1. Mostrar contactos");
    System.out.println("2. Mostrar grupos");
    System.out.println("3. Crear grupo");
    System.out.println("4. Volcar grupo a fichero");
    System.out.println("5. Mostrar grupo de fichero");
    System.out.println("6. Comparar contacto");
    System.out.println("7. Mostrar contactos ordenados por telefono");
    System.out.println("0. Salir");

  }

  public static void mostrarContactos() {
    List<Contacto> contactos = App.getContactos();
    System.out.println("Contactos:");
    System.out.println("------------------------------------");
    contactos.forEach( a -> {
      System.out.println(a);
    });
    System.out.println("------------------------------------");
  }

  public static void mostrarGrupos() {
    List<Grupo> grupos = App.getGrupos();
    System.out.println("Grupos");
    System.out.println("------------------------------------");
    grupos.forEach(a -> System.out.println(a));
    System.out.println("------------------------------------");
  }

  public static void crearGrupo(Scanner in) {
    System.out.println("Introduce el nombre del nuevo grupo");
    String nombre = in.nextLine();
    Optional<Grupo> grupo = App.getGrupo(nombre);
    if (grupo.isPresent()) {
      System.out.println("El grupo ya existe");
      return;
    }
    System.out.println("Introduce la letra con la que empiezan los conctactos de este grupo");
    char letra = in.nextLine().charAt(0);
    List<Contacto> contactos = App.getContactosWith(letra);
    try {
      App.createGrupo(nombre, contactos);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public static void volcarAArchivo(Scanner in) {
    System.out.println("Introduce el nombre del grupo que quieres volcar a fichero");
    String nombre = in.nextLine();
    Optional<Grupo> grupo = App.getGrupo(nombre);
    if (grupo.isEmpty()) {
      System.out.println("El grupo no existe");
      return;
    }
    try {
      App.volcarObjetosArchivo(grupo.get());
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public static void mostrarGrupoFichero(Scanner in) {
    List<String> gruposArchivo = null;
    try {
      gruposArchivo = App.getNombreFicheros();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    System.out.println("Grupos en fichero: ");
    System.out.println("------------------------------------");
    gruposArchivo.forEach(a -> System.out.println(a));
    System.out.println("Introduce el nombre del grupo que quieres mostrar");
    String nombre = in.nextLine();

    if (!gruposArchivo.contains(nombre)) {
      System.out.println("El grupo no existe");
      return;
    }

    Grupo grupo = null;
    try {
      grupo = App.recuperarObjetosArchivo(nombre);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    System.out.println(grupo);
  }

  public static void compararContactos(Scanner in) {
    System.out.println("Introduce el nombre del primer contacto");
    String nombre1 = in.nextLine();
    System.out.println("Introduce el nombre del segundo contacto");
    String nombre2 = in.nextLine();
    Optional<Contacto> contacto1 = App.getContacto(nombre1);
    Optional<Contacto> contacto2 = App.getContacto(nombre2);
    if (contacto1.isEmpty() || contacto2.isEmpty()) {
      System.out.println("Uno de los contactos no existe");
      return;
    }
    if (contacto1.get().equals(contacto2.get())) {
      System.out.println("Los contactos son iguales");
    } else {
      System.out.println("Los contactos son diferentes");
    }
  }

  public static void mostrarContactosOrdenados(Scanner in) {
    List<Contacto> contactos = App.getContactosOrdenados("telefono");
    System.out.println("Contactos ordenados por telefono");
    System.out.println("------------------------------------");
    contactos.forEach(a -> System.out.println(a));
    System.out.println("------------------------------------");
  }
}
