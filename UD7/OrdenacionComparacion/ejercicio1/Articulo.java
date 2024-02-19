package ejercicio1;

public class Articulo implements Comparable<Object>{
  String codArticulo;
  String descripcion;
  int cantidad;
  Articulo(String codArticulo,String descripcion,int cantidad){
    this.codArticulo = codArticulo;
    this.descripcion = descripcion;
    this.cantidad = cantidad;
  }

  public int getCantidad(){
    return cantidad;
  }
  @Override
  public int compareTo(Object o){
    Articulo a = (Articulo) o;
    return -1*a.codArticulo.compareTo(this.codArticulo);
  }
  @Override
  public String toString() {
    return "Articulo: "+codArticulo+", descripcion: "+descripcion+", cantidad: "+cantidad;
  }

}