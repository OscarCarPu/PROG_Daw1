package ejercicio4;

public class App{
  public static void main(String[] args){
    MiListaEnlazada<Persona> personas = new MiListaEnlazada<>();
    MiListaEnlazada<Integer> ints = new MiListaEnlazada<>();
    personas.insertar(new Persona("Pepe"));
    personas.insertar(new Persona("María"));
    System.out.println(personas.tamano());
    System.out.println(personas.obtener(1));

    ints.insertar(3);
    ints.insertar(19);
    ints.insertar(234);
    ints.insertar(234235);
    System.out.println(ints.tamano());
    System.out.println(ints.obtener(0));
    System.out.println(ints.obtener(3));
  }
}