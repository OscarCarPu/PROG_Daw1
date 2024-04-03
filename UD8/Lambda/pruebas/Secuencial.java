package pruebas;

import java.nio.file.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.*;

public class Secuencial {
  public static void main(String[] args) throws IOException {
    Path file = Paths.get("readFile.txt");
    try (Stream<String> lines = Files.lines(file).onClose(() -> System.out.println("Fin de lectura."))) {
      lines.forEach(System.out::println);
    }
    System.out.println("Version mais eficiente....");
    try (BufferedReader br = Files.newBufferedReader(file);
        Stream<String> lines = br.lines().onClose(() -> System.out.println("Fin de lectura."));) {
      lines.forEach(System.out::println);
    }

    System.out.println("Version con procesamento paralelo....");
    try (Stream<String> lines = Files.lines(file).parallel().onClose(() -> System.out.println("Fin de lectura."))) {
      lines.forEach(s -> {
        System.out.println(s + " " + Thread.currentThread().getName());
      });
    }
  }
}