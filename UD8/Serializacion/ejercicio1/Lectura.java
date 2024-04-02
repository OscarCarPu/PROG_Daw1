package ejercicio1;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Lectura {
  private static ObjectInputStream input;

  public static void main(String[] args){
    openFile();
    readRecords();
    closeFile();
  }

  public static void openFile() {
    try {
      input = new ObjectInputStream(
        Files.newInputStream(Paths.get("ejercicio1.ser"))
      );
    } catch(IOException e){
      System.err.println("Erro: "+e.getMessage());
    }
  }

  public static void readRecords() {
    try {
      while(true) {
        Employee e = (Employee) input.readObject();
        System.out.println(e);
      }
    } catch (EOFException e){
      System.out.println("No hay mas datos");
    } catch(ClassNotFoundException e){
      System.err.println("Erro: "+e.getMessage());
    }catch(IOException e){
      System.err.println("Erro: "+e.getMessage());
    }
  }

  public static void closeFile() {
    try {
      if (input != null)input.close();
    } catch(IOException e){
      System.err.println("Erro: "+e.getMessage());
    }
  }
}
