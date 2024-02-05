package exercise3;
public class App {
  public static void main(String[] args) {
  
  try {
      Circulo c = new Circulo(2.0, "blanco");
      System.out.println("Area circulo " + c.area());
  } catch (Exception e) {
      System.out.println("NO SE PUDO CREAR OBJETO: " + e.getMessage());
  }
  try {
      Triangulo t = new Triangulo(2.0, 3.0, "rojo");
      System.out.println("Area triangulo " + t.area());
  } catch (Exception e) {
      System.out.println("NO SE PUDO CREAR OBJETO" + e.getMessage());
  }
  }
  }
  
  abstract class Figura {
      protected String color;
      public Figura(String color) {
          this.color = color;
      }
      abstract public double area();
  }
  
  class Triangulo extends Figura {
      private double base;
      private double altura;
      public Triangulo(double base, double altura, String color) {
          super(color);
          this.base = base;
          this.altura = altura;
      }
      @Override
      public double area() {
          return base * altura / 2;
      }
  
  }
  
  class Circulo extends Figura {
      private double radio;
      public Circulo(double radio, String color)  {
        super(color);
        if(color.equals("blanco")){
          throw new RuntimeException("El color no puede ser blanco");
        }
        this.radio = radio;
      }
      @Override
      public double area() {
          return Math.PI * radio * radio;
      }
  }