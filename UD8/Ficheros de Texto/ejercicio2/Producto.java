package ejercicio2;

import java.util.ArrayList;
import java.util.List;

class Producto {

  private String codProd;
  private String tipo;
  private String nombre;
  private double precio;
  private String pais;
  private List<String> proveedores;

  public Producto(
    String codProd,
    String tipo,
    String nombre,
    double precio,
    String pais
  ) {
    this.codProd = codProd;
    this.tipo = tipo;
    this.nombre = nombre;
    this.precio = precio;
    this.pais = pais;
    this.proveedores = new ArrayList<>();
  }

  public String getCodProd() {
    return codProd;
  }

  public String getTipo() {
    return tipo;
  }

  public String getNombre() {
    return nombre;
  }

  public double getPrecio() {
    return precio;
  }

  public String getPais() {
    return pais;
  }

  public List<String> getProveedores() {
    return proveedores;
  }

  public void addProveedor(String codProv) {
    proveedores.add(codProv);
  }
}
