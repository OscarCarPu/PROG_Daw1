package ejercicio1;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.util.NoSuchElementException;
import java.nio.file.Paths;

public class Escritura {
  private static ObjectOutputStream output;

  public static void main(String[] args){
    openFile();
    addRecords();
    closeFile();
  }

  public static void openFile() {
    try {
      output = new ObjectOutputStream(
        Files.newOutputStream(Paths.get("ejercicio1.ser"))
      );
    } catch(IOException e){
      System.err.println("Erro: "+e.getMessage());
    }
  }

  public static void addRecords() {
    try{
      Employee e = new Employee("1", "Oscar", "Carballo");
      output.writeObject(e);
      e = new Employee("3", "Pablo", "Sanchez");
      output.writeObject(e);
      e = new Employee("59", "Manuela", "Fernandez");
      output.writeObject(e);
    } catch(NoSuchElementException e){
      System.err.println("Erro: "+e.getMessage());
    } catch(IOException e){
      System.err.println("Erro: "+e.getMessage());
    }
  }

  public static void closeFile() {
    try {
      if (output != null) {
        output.close();
      }
    } catch( IOException e){
      System.err.println("Erro: "+e.getMessage());
    }
  }
}
