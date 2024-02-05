package exercise5;

public class App {
  public static void main(String[] args) {
    Producto p = new Producto(1, 100);
    try {
      p.vender(40);
    } catch (FaltaStockException e) {
      System.out.println("NO SE PUDO VENDER: " + e.getMessage());
    } finally {
      System.out.println("FIN DEL PROGRAMA");
    }
  }
}
