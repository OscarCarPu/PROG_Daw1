package ejercicio1;

import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class App {
  public boolean findFilesWithSize(Path startPath, long size) {
    try (Stream<Path> stream = Files.find(startPath, Integer.MAX_VALUE,
        (path, attrs) -> !Files.isDirectory(path) && attrs.size() == size)) {
      return stream.findAny().isPresent();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return false;
  }

  public boolean findFileInDirectory(Path startPath, String fileName) {
    try (Stream<Path> stream = Files.find(startPath, Integer.MAX_VALUE,
        (path, attrs) -> attrs.isRegularFile() && path.getFileName().toString().equals(fileName))) {
      return stream.findAny().isPresent();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return false;
  }
}