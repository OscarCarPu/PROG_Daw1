package ejercicio2;

class Proveedor {

  private String codProv;
  private String nombre;
  private String direccion;

  public Proveedor(String codProv, String nombre, String direccion) {
    this.codProv = codProv;
    this.nombre = nombre;
    this.direccion = direccion;
  }

  public String getCodProv() {
    return codProv;
  }

  public String getNombre() {
    return nombre;
  }

  public String getDireccion() {
    return direccion;
  }
}
