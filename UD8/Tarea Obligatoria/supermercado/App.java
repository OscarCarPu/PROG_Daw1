package supermercado;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class App {
  private static HashMap<Integer, Cesta> cajero;
  private static HashMap<String, Producto> productos;
  private static double cantidadTotal;

  public static void main(String[] args) {
    cajero = new HashMap<>();
    productos = new HashMap<>();
    cantidadTotal = 0.0;
    leerCantidadTotalAcumulativo();
    System.out.println("Cantidad total acumulada de: " + String.format("%.2f",cantidadTotal)+ "$\n");
    Scanner in = new Scanner(System.in);

    ////// CARGAR PRODUCTOS DEMO

    Producto p;
    try {
      // Producto 1
      p = new Producto("A-1223", "Macarrones", 1.23);
      productos.put(p.getIdentificador(), p);
      // Producto 2
      p = new Producto("B-2343", "Jamón", 3.23);
      productos.put(p.getIdentificador(), p);
      // Producto 3
      p = new Producto("C-1222", "Queso azul", 4.45);
      productos.put(p.getIdentificador(), p);
      // Producto 4
      p = new Producto("B-1212", "Cebolla dulce", 2.22);
      productos.put(p.getIdentificador(), p);
    } catch (Exception e) {
      System.err.print(e.getMessage());
    }

    Cesta c;
    // Cesta 1
    c = new Cesta(1);
    c.getCompra().add(new ProductoCesta(2, productos.get("A-1223")));
    cajero.put(c.getId(), c);
    // Cesta 2
    c = new Cesta(2, true);
    c.getCompra().add(new ProductoCesta(2, productos.get("B-2343")));
    c.getCompra().add(new ProductoCesta(1, productos.get("C-1222")));
    cajero.put(c.getId(), c);
    // Cesta 3
    c = new Cesta(3);
    c.getCompra().add(new ProductoCesta(3, productos.get("B-1212")));
    c.getCompra().add(new ProductoCesta(1, productos.get("A-1223")));
    cajero.put(c.getId(), c);

    imprimirProductos();

    imprimirCestas();

    int opcion;
    do {
      System.out.println();
      printMenu();
      opcion = in.nextInt();
      System.out.println();
      switch (opcion) {
        case 1:
          pagarPrimeraCesta();
          break;
        case 2:
          pagarCestasDescuento();
          break;
        case 3:
          System.out.println("Introduce el id de la cesta:");
          int id = in.nextInt();
          mostrarCestaOrdenada(id);
          break;
        case 4:
          imprimirCestas();
          break;
        case 5:
          System.out.println("Introduce el id del producto:");
          String idProducto = in.next();
          System.out.println("Introduce el id de la cesta:");
          int idCesta = in.nextInt();
          anadirProducto(idProducto, idCesta);
          break;
        case 6:
          importarProductos();
          imprimirProductos();
          break;
        case 7:
          escribirCajero();
          break;
        case 8:
          imprimirCajero();
          break;
        case 9:
          chequearProductos();
          break;
        default:
          break;
      }
    } while (opcion != 0);
    System.out.println("Cerrando caja y guardando total acumulado...");
    guardarCantidadTotal();
    eliminarCajero();
    in.close();
  }

  public static void imprimirCestas() {
    System.out.println("Cestas:");
    cajero.forEach((k, v) -> {
      System.out.println(v.toString() + "\n");
    });
  }

  public static void imprimirProductos() {
    System.out.println("Productos:");
    productos.forEach((k, v) -> {
      System.out.println(v.toString() + "\n");
    });
  }

  public static void printMenu() {
    System.out.println("Elige una opción:");
    System.out.println("0 - Salir");
    System.out.println("1 - Pagar primera cesta");
    System.out.println("2 - Pagar cestas con descuento");
    System.out.println("3 - Mostrar cesta ordenada por precio");
    System.out.println("4 - Mostrar cestas");
    System.out.println("5 - Añadir producto a cesta");
    System.out.println("6 - Importar productos");
    System.out.println("7 - Escribir cajero (serializado)");
    System.out.println("8 - Imprimir cajero (serializado)");
    System.out.println("9 - Chequear productos");
  }

  public static void pagarPrimeraCesta() {
    if (!cajero.isEmpty()) {
      Integer firstKey = cajero.keySet().iterator().next();
      System.out.println(cajero.get(firstKey));
      cantidadTotal += cajero.get(firstKey).getTotal();
      cajero.remove(firstKey);
      System.out.println("Primera cesta pagada");
    } else {
      System.out.println("No hay cestas a pagar");
    }
  }

  public static void pagarCestasDescuento() {
    boolean can = false;
    if (!cajero.isEmpty()) {
      Iterator<Integer> it = cajero.keySet().iterator();
      while (it.hasNext()) {
        Integer k = it.next();
        if (cajero.get(k).getDescuento()) {
          can = true;
          System.out.println(cajero.get(k));
          cantidadTotal += cajero.get(k).getTotal();
          it.remove();
        }
      }
    }
    if (!can) {
      System.out.println("No hay cestas con descuento");
    }
  }

  public static void mostrarCestaOrdenada(int id) {
    if (!cajero.containsKey(id)) {
      System.out.println("No existe el usuario");
      return;
    }
    cajero.get(id).getCompra().sort((a,
        b) -> a.getProducto().getPrecio() * a.getCantidad() > b.getProducto().getPrecio() * b.getCantidad() ? 1 : -1);
    System.out.println(cajero.get(id));
  }

  public static void anadirProducto(String idProducto, int idCesta) {
    if (!productos.containsKey(idProducto)) {
      System.out.println("No existe el producto");
      return;
    }
    if (!cajero.containsKey(idCesta)) {
      System.out.println("No existe la cesta");
      return;
    }
    cajero.get(idCesta).addProducto(productos.get(idProducto));
    System.out.println("Producto añadido");
  }

  public static void importarProductos() {
    String filePath = "productos.txt";
    try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
      stream.forEach(line -> {
        if(line.trim().isEmpty()){
          return;
        }
        String[] parts = line.split(":");
        if(parts.length != 3){
          return;
        }
        String id = parts[0];
        if(!id.matches("[A-D]-[0-9]{4}")){
          return;
        }
        String name = parts[1];
        double price = Double.parseDouble(parts[2]);
        try {
          Producto product = new Producto(id, name, price);
          productos.put(id, product);
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
      });
    } catch (IOException e) {
      System.out.println("Error al leer el fichero: " + e.getMessage());
    }
  }

  public static void guardarCantidadTotal() {
    try (DataOutputStream dos = new DataOutputStream(Files.newOutputStream(Paths.get("total.dat")))) {
      dos.writeDouble(cantidadTotal);
    } catch (IOException e) {
      System.out.println("Error al guardar la cantidad total: " + e.getMessage());
    }
  }

  public static void leerCantidadTotalAcumulativo() {
    try (DataInputStream dis = new DataInputStream(Files.newInputStream(Paths.get("total.dat")))) {
      cantidadTotal = dis.readDouble();
    } catch (IOException e) {
      System.out.println("Error al leer la cantidad total acumulativa: " + e.getMessage());
    }
  }

  public static void escribirCajero() {
    try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get("cajero.dat")))) {
      oos.writeObject(cajero);
      oos.close();
    } catch (IOException e) {
      System.out.println("Error al guardar el cajero: " + e.getMessage());
    }
  }

  public static void imprimirCajero() {
    try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get("cajero.dat")))) {
      @SuppressWarnings("unchecked")
      HashMap<Integer, Cesta> auxCajero = (HashMap<Integer, Cesta>) ois.readObject();
      auxCajero.forEach((k, v) -> {
        System.out.println(v.toString() + "\n");
      });
      ois.close();
    } catch (IOException | ClassNotFoundException e) {
      System.out.println("Error al leer el cajero: " + e.getMessage());
    }
  }

  public static void eliminarCajero() {
    try {
      Files.delete(Paths.get("cajero.dat"));
    } catch (IOException e) {
      System.out.println("Error al eliminar el cajero: " + e.getMessage());
    }
  }

  public static void chequearProductos() {
    String filePath = "productos.txt";
    try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
      AtomicInteger count = new AtomicInteger();
      stream.forEach(line -> {
        if (line.trim().isEmpty()) {
          System.out.println("Línea en blanco encontrada");
        } else {
          String[] parts = line.split(":");
          if (parts.length < 3) {
            System.out.println("Formato de línea incorrecto: " + line);
          } else {
            String id = parts[0];
            if (!id.matches("[A-D]-[0-9]{4}")) {
              System.out.println("Identificador de producto incorrecto: " + id);
            }
            else count.incrementAndGet();
          }
        }
      });
      System.out.println("Número total de productos: " + count);
    } catch (IOException e) {
      System.out.println("Error al leer el fichero: " + e.getMessage());
    }
  }
}
