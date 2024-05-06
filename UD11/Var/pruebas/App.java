package pruebas;

import java.util.ArrayList;
import java.util.List;

public class App {
  public static void main(String[] args) {
    // datos primitivos
    var texto = "abc";
    var caracter = '\n';
    var largo = 42L;
    var flotante = 3.14f;
    var doble = 3.14d;
    var logico = true;

    // necesario cast con este tipo
    var octeto = (byte) 1;
    var corto = (short) 2;
    var entero = 3;

    var p = new Object();

    var list = new ArrayList<String>(); // infiere ArrayList<String>

    // Siempre algo inicializado
    // var count=null;// Compilation error

    // Uso cómodo en bucles for
    var numbers = List.of("a", "b", "c");
    // for corto
    for (var nr : numbers)
      System.out.print(nr + " ");
    // for largo
    for (var i = 0; i < numbers.size(); i++)
      System.out.print(numbers.get(i) + " ");
  }
}