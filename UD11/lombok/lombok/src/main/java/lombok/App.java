package lombok;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Persona p = new Persona("Juan", "Fernandez", 30);
        System.out.println(p.getNombre());
        Persona p2 = new Persona();
        p2.setNombre("Juan");
        p2.setApellidos("Fernandez");
        p2.setEdad(30);
        System.out.println("Funciona el equals:" + p.equals(p2));
        System.out.println(p2);
    }
}
