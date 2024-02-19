package ejercicio1;
import java.util.*;
public class App{
  public static void main(String[] args){
    List<Articulo> listaArticulos = new ArrayList<>();
    
    listaArticulos.add(new Articulo("001","Articulo 1",2));
    listaArticulos.add(new Articulo("002","Articulo 2",432));
    listaArticulos.add(new Articulo("000","Articulo 0",43));
    Collections.sort(listaArticulos);
    listaArticulos.forEach(art -> {System.out.println(art);});
    Collections.sort(listaArticulos, new SortByCantity());
    listaArticulos.forEach(art -> {System.out.println(art);});

  }
}