package ejercicio2;

import java.util.*;

public class App{
  public static void main(String[] args){
    List<Telefono> t = new ArrayList<>();

    t.add(new Telefono("981555555"));
    t.add(new Telefono("+34981565656"));
    t.add(new Telefono("666666666"));
    t.add(new Telefono("+34666666666"));

    Collections.sort(t);
    t.forEach(tel -> {System.out.println(tel);});
  }
}