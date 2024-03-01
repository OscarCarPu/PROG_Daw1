package ejercicio2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class App {

  public static void main(String[] args) throws IOException {
    File file = new File(args[0]);
    for (String a : file.list()) {
      System.out.println(a);
    }

    System.out.println("\nAhora con nio");

    Path path = Paths.get(args[0]);
    Path[] sub = (Path[]) Files.list(path).toArray();
    for (Path a : sub) {
      System.out.println(a);
    }
  }
}
