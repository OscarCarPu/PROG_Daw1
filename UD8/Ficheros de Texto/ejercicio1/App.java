package ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

public class App{

  public static void main(String[] args) {
    File originalFile = new File(".\\ejercicio1\\original.txt");
    File tempFile = null;
    BufferedReader reader = null;
    PrintWriter writer = null;

    try {
      tempFile =
        File.createTempFile("tempfile", ".tmp", new File(".\\ejercicio1\\"));

      reader = new BufferedReader(new FileReader(originalFile));
      writer = new PrintWriter(new FileWriter(tempFile));

      String line;
      while ((line = reader.readLine()) != null) {
        line = line.trim();

        if (!line.isEmpty()) {
          char firstChar = line.charAt(0);
          if (Character.isLowerCase(firstChar)) {
            firstChar = Character.toUpperCase(firstChar);
            line = firstChar + line.substring(1);
          }

          writer.println(line);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (reader != null) reader.close();
        if (writer != null) {
          writer.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    if (tempFile != null) {
      try {
        Files.copy(tempFile.toPath(), originalFile.toPath());

        tempFile.delete();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
