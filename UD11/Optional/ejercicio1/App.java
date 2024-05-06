package ejercicio1;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class App {
  private static ArrayList<Usuario> usuarios;

  public static void main(String[] args) {
    usuarios = new ArrayList<Usuario>();
    int opcion = 0;
    Scanner in = new Scanner(System.in);
    while(opcion!=-1){
      System.out.println("1. Agregar usuario");
      System.out.println("2. Buscar usuario");
      System.out.println("3. Actualizar correo");
      System.out.println("4. Eliminar usuario");
      System.out.println("5. Salir");
      System.out.println("Ingrese una opcion: ");
      opcion = in.nextInt();
      in.nextLine();
      switch(opcion){
        case 1:
          agregarUsuario(in);
          break;
        case 2:
          if(buscarUsuario(in)){
            System.out.println("Usuario encontrado");
          }else{
            System.out.println("Usuario no encontrado");
          }
          break;
        case 3:
          actualizarCorreo(in);
          break;
        case 4:
          eliminarUsuario(in);
          break;
        case 5:
          opcion = -1;
          break;
        default:
          System.out.println("Opcion no valida");
          break;
      }
    }
    in.close();

  }

  public static void agregarUsuario(Scanner in){
    System.out.println("Ingrese el nombre del usuario: ");
    String nombre = in.nextLine();
    System.out.println("Ingrese el apellido del usuario: ");
    String apellido = in.nextLine();
    System.out.println("Ingrese el email del usuario: ");
    String email = in.nextLine();
    Usuario usuario = new Usuario(nombre, apellido, email);
    usuarios.add(usuario);
  }
  
  public static Optional<Usuario> buscarUsuario(Scanner in){
    System.out.println("Ingrese el nombre del usuario: ");
    String nombre = in.nextLine();
    System.out.println("Ingrese el apellido del usuario: ");
    String apellido = in.nextLine();
    for (Usuario usuario : usuarios) {
      if(usuario.getNombre().equals(nombre) && usuario.getApellido().equals(apellido)){
        return Optional.of(usuario);
      }
    }
    return Optional.empty();
  }

  public static void actualizarCorreo(Scanner in){
    Optional<Usuario> usuarioOptional = buscarUsuario(in);
    if(usuarioOptional.isPresent()){
      System.out.println("Ingrese el nuevo correo del usuario: ");
      String email = in.nextLine();
      usuarioOptional.get().setEmail(email);
    } else {
      System.out.println("Usuario no encontrado");
    }
  }

  public static void eliminarUsuario(Scanner in){
    Optional<Usuario> usuarioOptional = buscarUsuario(in);
    if(usuarioOptional.isPresent()){
      usuarios.remove(usuarioOptional.get());
    } else {
      System.out.println("Usuario no encontrado");
    }
  }
}
