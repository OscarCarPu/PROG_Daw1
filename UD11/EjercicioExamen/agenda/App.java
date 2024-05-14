package agenda;

import java.util.ArrayList;
import java.util.List;

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
    BD.conectar();
    contactos = BD.cargarDatos();
    BD.cerrar();
  }

  public static List<Contacto> getContactos() {
    return contactos;
  }

  public static List<Grupo> getGrupos() {
    return grupos;
  }

  public static void createGrupo(String nombre,List<Contacto> contactos) throws Exception{
    Grupo grupo = new Grupo(nombre,  contactos);
    grupos.add(grupo);
  }

  public static List<Contacto> getContactosWith(char letter) {
    List<Contacto> contactosWith = new ArrayList<>();
    for (Contacto contacto : contactos) {
      if (contacto.getNombre().charAt(0) == letter) {
        contactosWith.add(contacto);
      }
    }
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
    }
  }

  public static void volcarObjetosArchivo() throws Exception {

  }

  public static void recuperarObjetosArchivo() throws Exception {

  }

}
