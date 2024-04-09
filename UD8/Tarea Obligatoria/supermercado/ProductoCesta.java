package supermercado;

import java.io.Serializable;

public class ProductoCesta implements Serializable{
  private int cantidad;
  private Producto producto;

  public ProductoCesta(int cantidad,Producto producto){
    this.cantidad=cantidad;
    this.producto=producto;
  }

  public void setCantidad(int cantidad){
    this.cantidad=cantidad;
  }

  public int getCantidad(){
    return cantidad;
  }

  public void setProducto(Producto producto){
    this.producto=producto;
  }

  public Producto getProducto(){
    return producto;
  }

  public void addCantidad(int cantidad){
    this.cantidad+=cantidad;
  }

  public void addCantidad(){
    this.cantidad++;
  }

  @Override
  public String toString(){
    return cantidad+" "+producto.getDescripcion()+" ------ "+String.format("%.2f",(producto.getPrecio()*cantidad))+"$";
  }
}
