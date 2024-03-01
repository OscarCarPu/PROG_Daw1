package ejercicio3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class App {

  public static void walk(String path) {
    File d = new File(path);
    File[] list = d.listFiles();
    if (list == null) return;
    for (File f : list) {
      System.out.println(f.getAbsolutePath());

      if (f.isDirectory()) {
        walk(f.getAbsolutePath());
      }
    }
  }

  public static void main(String[] args) throws IOException {
    walk(args[0]);

    System.out.println("\nAhora con nio");

    Path path = Paths.get(args[0]);
    Stream<Path> dir = Files.walk(path);
    dir.forEach(a -> {
      System.out.println(a);
    });
  }
}
