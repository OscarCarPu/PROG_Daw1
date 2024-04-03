package ejercicio3;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Paths;

public class App {
  static List<Persona> personas;
  public static void main(String[] args) {
    personas = new ArrayList<>();
    personas.add(new Persona("Oscar", "12345"));
    personas.add(new Persona("Pablo", "8434"));
    escribir();
    leer();
  }

  static void escribir(){
    try{
      ObjectOutputStream output = new ObjectOutputStream(Files.newOutputStream(Paths.get("ejercicio3.ser")));
      personas.forEach((p)->{
        try {
          output.writeObject(p);
        } catch (IOException e) {
          System.err.println("Erro: "+e.getMessage());
        }
      });
      output.close();
    } catch (Exception e){
      System.err.println("Erro: "+e.getMessage());
    }
  }

  static void leer(){
    try{
      ObjectInputStream input = new ObjectInputStream(Files.newInputStream(Paths.get("ejercicio3.ser")));
      try{
        while(true){
          Persona p = (Persona) input.readObject();
          System.out.println(p);
        }
      } catch(EOFException e){
        System.out.println("Fin de archivo");
      }
      input.close();
    } catch(Exception e){
      System.err.println("Erro: "+e.getMessage());
    }
  }
}
