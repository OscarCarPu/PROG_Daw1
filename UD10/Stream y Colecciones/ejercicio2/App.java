package ejercicio2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class App {
  public static void main(String[] args) {
    List<Persona> personas = Arrays.asList(
        new Persona("Juan", 30),
        new Persona("Ana", 25),
        new Persona("Carlos", 35),
        new Persona("Maria", 28));

    Persona personaMenorEdad = personas.stream()
        .min(Comparator.comparingInt(Persona::getEdad))
        .orElse(null);

    System.out.println(personaMenorEdad.getNombre());
  } 
}
