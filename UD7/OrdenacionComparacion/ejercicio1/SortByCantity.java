package ejercicio1;
import java.util.*;
public class SortByCantity implements Comparator<Articulo> {
  @Override
  public int compare(Articulo a,Articulo b){
    return a.getCantidad()-b.getCantidad();
  }
}