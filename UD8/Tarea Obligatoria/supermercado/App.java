package supermercado;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.HashSet;

public class App {
  private static HashMap<Integer,Cesta> cajero;
  private static HashMap<String,Producto> productos;

  public static void main(String[] args){
    cajero = new HashMap<>();
    productos = new HashMap<>();
    Scanner in = new Scanner(System.in);
    
    ////// CARGAR PRODUCTOS DEMO

    Producto p;
    try {
      //Producto 1
      p = new Producto("A-1223", "Macarrones", 1.23);
      productos.put(p.getIdentificador(), p);
      //Producto 2
      p = new Producto("B-2343", "Jamón", 3.23);
      productos.put(p.getIdentificador(),p);
      //Producto 3
      p = new Producto("C-1222", "Queso azul", 4.45);
      productos.put(p.getIdentificador(),p);
      //Producto 4
      p = new Producto("B-1212", "Cebolla dulce", 2.22);
      productos.put(p.getIdentificador(),p);
    } catch (Exception e) {
      System.err.print(e.getMessage());
    }

    Cesta c;
    // Cesta 1
    c = new Cesta(1);
    c.getCompra().add(new ProductoCesta(2, productos.get("A-1223")));
    cajero.put(c.getId(), c);
    // Cesta 2
    c = new Cesta(2,true);
    c.getCompra().add(new ProductoCesta(1, productos.get("B-2343")));
    c.getCompra().add(new ProductoCesta(3, productos.get("C-1222")));
    cajero.put(c.getId(), c);
    // Cesta 3
    c = new Cesta(3);
    c.getCompra().add(new ProductoCesta(4, productos.get("B-1212")));
    c.getCompra().add(new ProductoCesta(1, productos.get("A-1223")));
    cajero.put(c.getId(), c);
    
    imprimirProductos();

    imprimirCestas();

    int opcion;
    do{
      System.out.println();
      printMenu();
      opcion = in.nextInt();
      System.out.println();
      switch(opcion){
        case 1:
          pagarPrimeraCesta();
          break;
        case 2:
          pagarCestasDescuento();
          break;
        default:break;
      }
    }while(opcion!=0);

  }

  public static void imprimirCestas(){
    System.out.println("Cestas:");
    cajero.forEach((k,v)-> {
      System.out.println(v.toString()+"\n");
    });
  }

  public static void imprimirProductos(){
    System.out.println("Productos:");
    productos.forEach((k,v)-> {
      System.out.println(v.toString()+"\n");
    });
  }

  public static void printMenu(){
    System.out.println("Elige una opción:");
    System.out.println("0 - Salir");
    System.out.println("1 - Pagar primera cesta");
    System.out.println("2 - Pagar cestas con descuento");
  }

  public static void pagarPrimeraCesta(){
    if (!cajero.isEmpty()) {
      Integer firstKey = cajero.keySet().iterator().next();
      System.out.println(cajero.get(firstKey));
      cajero.remove(firstKey);
      System.out.println("Primera cesta pagada");
    } else {
      System.out.println("No hay cestas a pagar");
    }
  }

  public static void pagarCestasDescuento(){
    boolean can=false;
    if (!cajero.isEmpty()){
      Iterator<Integer> it = cajero.keySet().iterator();
      HashSet<Integer> toRemove = new HashSet<Integer>();
      while(it.hasNext()){
        Integer k =it.next();
        if(cajero.get(k).getDescuento()){
          can=true;
          System.out.println(cajero.get(k));
          cajero.remove(k);
        }
      }
    }
    if(!can){
      System.out.println("No hay cestas con descuento");
    }
  }
}
