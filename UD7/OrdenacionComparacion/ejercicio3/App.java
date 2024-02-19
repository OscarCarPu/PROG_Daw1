package ejercicio3;

import java.util.*;

public class App{
  public static void main(String[] args){
    List<Estudiante> l = new ArrayList<>();
    l.add(new Estudiante("Pepe",12));
    l.add(new Estudiante("Josefina",15));
    l.add(new Estudiante("Pepe",14));
    l.add(new Estudiante("Pepe",10));
    l.add(new Estudiante("Ana",9));

    Collections.sort(l);
    l.forEach(e -> {System.out.println(e);});
  }
}