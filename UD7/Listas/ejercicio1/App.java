package ejercicio1;

import java.util.*;

public class App{
  public static void main(String[] args){
    List<Persona> agenda = new ArrayList<>();
    agenda.add(new Persona("Pepito","123456654"));
    agenda.add(new Persona("Manolito","8238723743"));
    agenda.add(new Persona("Josita","981723947"));
    System.out.println("Hay "+agenda.size()+" contactos");
    for(Persona p : agenda){
      System.out.println(p.toString());
    }
    agenda.remove(1);
    Iterator<Persona> it = agenda.iterator();
    while(it.hasNext()){
      Persona p = it.next();
      System.out.println(p.toString());
    }
    agenda.clear();
    agenda.forEach(s -> System.out.println(s.toString()));
  }
}