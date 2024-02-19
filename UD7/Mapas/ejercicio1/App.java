package ejercicio1;

import java.util.*;

public class App{
  public static void main(String[] args){
    TreeMap<String,Coordenadas> cities = new TreeMap<>();
    cities.put("Lugo",new Coordenadas("43.01 N","7.33 O"));
    cities.put("Barcelona",new Coordenadas("41.23 N","2.11 E"));
    cities.put("Madrid", new Coordenadas("40.24 N","3.41 O"));
    cities.put("Lima", new Coordenadas("10.03 S","77.03 O"));

    cities.forEach((country,coor)->System.out.println(country+" : "+coor));
    
    cities.remove("Lima");
    cities.replace("Lugo",new Coordenadas("43 N","7.44 O"));
    cities.forEach((country,coor)->System.out.println(country+" : "+coor));

    

  }
}