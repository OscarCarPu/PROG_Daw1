package exercise4;

class Punto {
  int x = 0;
  int y = 0;

  Punto(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

class Rectangulo {
  Punto origen;
  int ancho;
  int alto;

  Rectangulo(int x, int y, int w, int h) {
    if(x < 0 || y < 0){
      throw new RuntimeException("El punto de origen no puede ser negativo");
    }
    origen = new Punto(x, y);
    ancho = w;
    alto = h;
  }
}

public class App {
  public static void main(String[] args) {
    try{
      Rectangulo miRectangulo = new Rectangulo(1, 3, 4, 5);
    } catch (Exception e) {
      System.out.println("NO SE PUDO CREAR OBJETO: " + e.getMessage());
    }finally{
      System.out.println("FIN DEL PROGRAMA");
    }
  }
}