package ejercicio2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.TreeMap;

public class App{
  static TreeMap<String,Coordenadas> m;
  public static void main(String[] args){
    m = new TreeMap<>();
    m.put("Lugo", new Coordenadas("43.01 N", "7.33 O"));
    m.put("Barcelona", new Coordenadas("41.23 N", "2.11 E"));
    m.put("Madrid",new Coordenadas("40.24 N", "3.41 O"));
    m.put("Lima", new Coordenadas("12.03 S", "77.03 O"));
    escribir();
    leer();
  }

  public static void escribir(){
    try{
      ObjectOutputStream output = new ObjectOutputStream(Files.newOutputStream(Paths.get("ejercicio2.ser")));
      output.writeObject(m);
      output.close();
    } catch (Exception e){
      System.err.println("Erro: "+e.getMessage());
    }
  }

  public static void leer(){
    try{
      ObjectInputStream input = new ObjectInputStream(Files.newInputStream(Paths.get("ejercicio2.ser")));
      TreeMap<String,Coordenadas> m = (TreeMap<String,Coordenadas>) input.readObject();
      m.forEach((k,v) -> {
        System.out.println("Ciudad: "+k+" con coordenadas "+v);
      });
      input.close();
    } catch (Exception e){
      System.err.println("Erro: "+e.getMessage());
    }
  }

}