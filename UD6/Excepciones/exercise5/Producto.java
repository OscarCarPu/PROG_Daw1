package exercise5;

public class Producto {
  private int id;
  private int precio;
  private int cantidad;

  public Producto(int id, int precio) {
    this.id = id;
    this.precio = precio;
    this.cantidad = 50;
  }

  public void vender(int cantidad) throws FaltaStockException {
    if (this.cantidad < cantidad) {
      throw new FaltaStockException("No hay suficiente stock");
    }
    this.cantidad -= cantidad;
  }
}
