package pruebas;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;

public class App {

  public static void main(String[] args)
    throws FileNotFoundException, IOException {
    File doc = new File(".\\pruebas\\Demo.txt");
    //Uso do try with resources, non fai falta usar o close
    try (
      BufferedReader bufferedReader = new BufferedReader(new FileReader(doc))
    ) {
      String line = bufferedReader.readLine();
      while (line != null) {
        System.out.println(line);
        line = bufferedReader.readLine();
      }
    }
  }
}
