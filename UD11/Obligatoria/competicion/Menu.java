package competicion;

public class Menu {
  public static void main(String[] args) {
    App app = new App();
    try {
      app.crearDatosInternalmente();
    } catch (Exception e) {
      System.err.print(e.getMessage());
    }


  }

  public static void mostrarMenu(){
    System.out.println("1. Alta participante");
    System.out.println("2. Alta equipo");
    System.out.println("3. Alta participante en equipo");
    System.out.println("4. Alta equipo en carrera");
    System.out.println("5. Otorgar premio");
    System.out.println("6. Mostrar clasificacion");
    System.out.println("7. Salir");
  }

}
