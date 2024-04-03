package pruebas;

import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class Condicional {
  public static void main(String[] args) throws IOException {
    // Exemplos do uso do filter
    try (Stream<String> lines = Files.lines(Path.of("readFile.txt"))) {
      long i = lines.filter(line -> line.startsWith("Hola"))
          .count();
      System.out.println("Numero de lineas que empezar por 'Hola' e " + i);
    }
    try (Stream<String> lines = Files.lines(Path.of("readFile.txt"))) {
      long i = lines.filter(line -> line.isEmpty())
          .count();
      System.out.println("Número de lineas vacias: " + i);
    }
    try (Stream<String> lines = Files.lines(Path.of("readFile.txt"))) {
      lines.filter(line -> line.endsWith("pepe"))
          .forEach(System.out::println);
    }
  }
}
