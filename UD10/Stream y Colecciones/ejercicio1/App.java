package ejercicio1;

import java.util.Arrays;
import java.util.Comparator;

public class App {
  public static void main(String[] args) {
    String[] palabras = { "hola", "mundo", "java", "programacion", "clase", "objeto", "metodo", "variable", "constante", "clase" };

    String minPalabra = Arrays.stream(palabras).min(Comparator.comparing(String::length)).get();

    System.out.println("Palabra más corta: " + minPalabra);
  }
}
