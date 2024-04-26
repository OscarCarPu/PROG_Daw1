package ejercicio2;

interface reverse{
  public String reverseString(String s);
}

public class App {
  public static void main(String[] args){
    reverse reverseString = (s) -> {
      String reversed = "";
      for (int i = s.length() - 1; i >= 0; i--) {
        reversed += s.charAt(i);
      }
      return reversed;
    };

    System.out.println(reverseString.reverseString("Hola Mundo"));
  }
}