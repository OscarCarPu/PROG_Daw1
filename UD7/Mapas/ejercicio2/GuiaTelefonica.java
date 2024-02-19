package ejercicio2;

import java.util.*;

public class GuiaTelefonica{
  private TreeMap<String,Integer> telefonos = new TreeMap<>();

  public void addNumber(String nombre,int tel){
    telefonos.put(nombre,tel);
  }

  public void updateNumber(String nombre,int tel){
    telefonos.replace(nombre,tel);
  }

  public void retrieveNumber(String nombre){
    System.out.println(nombre+ " tiene telefono "+telefonos.get(nombre));
  }

  public void retrieveAll(){
    telefonos.forEach((n,t) -> System.out.println(n+" tiene telefono "+t));
  }
}