package pruebas;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class App{
  public static void main(String[] args) throws IOException{
    File doc = new File(".\\pruebas\\Demo.txt");
    FileReader freader = new FileReader(doc);

    char[] i = new char[100];
    freader.read(i);
    for(char j : i){
      System.out.print(j);
    }
    freader.close();
  }
}