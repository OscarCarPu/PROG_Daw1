package agenda;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App {
  private static List<Grupo> grupos = new ArrayList<>();
  private static List<Contacto> contactos = new ArrayList<>();

  public static boolean hasContacto(Contacto contacto) {
    return contactos.contains(contacto);
  }

  public static boolean hasGrupo(Grupo grupo) {
    return grupos.contains(grupo);
  }

  public static void getDatosBD() throws Exception {
    contactos = BD.cargarDatos();
  }

  public static List<Contacto> getContactos() {
    return contactos;
  }

  public static List<Grupo> getGrupos() {
    return grupos;
  }

  public static Optional<Contacto> getContacto(String nombre) {
    return contactos.stream().filter(a -> a.getNombre().equals(nombre)).findFirst();
  }

  public static Optional<Grupo> getGrupo(String nombre) {
    return grupos.stream().filter(a -> a.getNombre().equals(nombre)).findFirst();
  }

  public static void createGrupo(String nombre,List<Contacto> contactos) throws Exception{
    Grupo grupo = new Grupo(nombre,  contactos);
    grupos.add(grupo);
  }

  public static List<Contacto> getContactosWith(char letter) {
    List<Contacto> contactosWith = contactos.stream().filter(a -> a.getNombre().charAt(0) == letter).toList();
    return contactosWith;
  }

  public static List<Contacto> getContactosOrdenados(String orden) {
    return contactos.stream().sorted((c1,c2) -> {
      switch(orden){
        case "nombre":
          return c1.getNombre().compareTo(c2.getNombre());
        case "telefono":
          return c1.getNumero_telefono() - c2.getNumero_telefono();
        case "email":
          return c1.getEmail().compareTo(c2.getEmail());
        default:
          return 0;
      }
    }).toList();
  }

  public static void volcarObjetosArchivo(Grupo g) throws Exception {
    ObjectOutputStream output = new ObjectOutputStream(Files.newOutputStream(Paths.get(g.getNombre()+".txt")));
    output.writeObject(g);
    output.close();
  }

  public static Grupo recuperarObjetosArchivo(String nombre) throws Exception {
    ObjectInputStream input = new ObjectInputStream(Files.newInputStream(Paths.get(nombre+".txt")));
    Grupo gF = (Grupo) input.readObject();
    input.close();
    return gF;
  }

  public static List<String> getNombreFicheros() throws Exception {
    return Files.list(Paths.get("."))
           .map(a -> a.getFileName().toString())
            .filter(name -> name.endsWith(".txt"))
           .map(name ->  name.substring(0, name.length() - 4))
           .toList();
  }

  public static void eliminarArchivos() throws Exception {
    Files.list(Paths.get("."))
    .filter(a -> a.getFileName().toString().endsWith(".txt"))
    .forEach(a -> {
      try {
        Files.delete(a);
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    });
  }

}
