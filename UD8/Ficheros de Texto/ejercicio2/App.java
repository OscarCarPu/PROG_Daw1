package ejercicio2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class App {

  private Map<String, Proveedor> proveedoresMap;
  private Map<String, Producto> productosMap;

  public App() {
    this.proveedoresMap = new HashMap<>();
    this.productosMap = new HashMap<>();
  }

  public void crearProducto(
    String codProd,
    String tipo,
    String nombre,
    double precio,
    String pais
  ) {
    Producto producto = new Producto(codProd, tipo, nombre, precio, pais);
    productosMap.put(codProd, producto);
  }

  public void imprimirProveedores() {
    for (Proveedor proveedor : proveedoresMap.values()) {
      System.out.println(
        proveedor.getCodProv() +
        ": " +
        proveedor.getNombre() +
        ", " +
        proveedor.getDireccion()
      );
    }
  }

  public void imprimirProductos() {
    for (Producto producto : productosMap.values()) {
      System.out.print(
        producto.getCodProd() +
        ": " +
        producto.getNombre() +
        ", " +
        producto.getPrecio() +
        ", Proveedores: "
      );
      for (String codProv : producto.getProveedores()) {
        System.out.print(codProv + " ");
      }
      System.out.println();
    }
  }

  public boolean asignarProveedor(String codProd, String codProv) {
    Producto producto = productosMap.get(codProd);
    if (producto != null) {
      producto.addProveedor(codProv);
      return true;
    }
    return false;
  }

  public Proveedor getProveedorByCod(String codProv) {
    return proveedoresMap.get(codProv);
  }

  public void facturacion(String codProv) {
    double totalFacturado = 0.0;
    for (Producto producto : productosMap.values()) {
      if (producto.getProveedores().contains(codProv)) {
        totalFacturado += producto.getPrecio();
      }
    }
    System.out.println(
      "Facturación total para el proveedor " + codProv + ": " + totalFacturado
    );
  }

  public void cargarDatos(String proveedoresFile, String productosFile) {
    try {
      BufferedReader proveedoresReader = new BufferedReader(
        new FileReader(proveedoresFile)
      );
      String line;
      while ((line = proveedoresReader.readLine()) != null) {
        String[] parts = line.split(":");
        Proveedor proveedor = new Proveedor(parts[0], parts[1], parts[2]);
        proveedoresMap.put(parts[0], proveedor);
      }
      proveedoresReader.close();

      BufferedReader productosReader = new BufferedReader(
        new FileReader(productosFile)
      );
      while ((line = productosReader.readLine()) != null) {
        String[] parts = line.split(":");
        Producto producto = new Producto(
          parts[0],
          parts[1],
          parts[2],
          Double.parseDouble(parts[3]),
          parts.length > 4 ? parts[4] : null
        );
        String[] codProvs = parts[parts.length - 1].split(",");
        for (String codProv : codProvs) {
          producto.addProveedor(codProv);
        }
        productosMap.put(parts[0], producto);
      }
      productosReader.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void guardarDatos(String proveedoresFile, String productosFile) {
    try {
      PrintWriter proveedoresWriter = new PrintWriter(
        new FileWriter(proveedoresFile)
      );
      for (Proveedor proveedor : proveedoresMap.values()) {
        proveedoresWriter.println(
          proveedor.getCodProv() +
          ":" +
          proveedor.getNombre() +
          ":" +
          proveedor.getDireccion()
        );
      }
      proveedoresWriter.close();

      PrintWriter productosWriter = new PrintWriter(
        new FileWriter(productosFile)
      );
      for (Producto producto : productosMap.values()) {
        StringBuilder sb = new StringBuilder();
        sb
          .append(producto.getCodProd())
          .append(":")
          .append(producto.getTipo())
          .append(":")
          .append(producto.getNombre())
          .append(":")
          .append(producto.getPrecio());
        if (producto.getPais() != null) {
          sb.append(":").append(producto.getPais());
        }
        sb.append(":");
        for (String codProv : producto.getProveedores()) {
          sb.append(codProv).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        productosWriter.println(sb.toString());
      }
      productosWriter.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    App main = new App();
    main.cargarDatos("proveedores.txt", "productos.txt");
    main.imprimirProveedores();
    main.imprimirProductos();
    main.guardarDatos("proveedores.txt", "productos.txt");
  }
}
