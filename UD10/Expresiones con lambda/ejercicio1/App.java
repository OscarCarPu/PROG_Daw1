package ejercicio1;

interface Lambda {
  public int findSmallestDivisor(int n);
}

public class App {
  public static void main(String[] args){
    Lambda smallesDivisor = (n) -> {
      if (n < 2) return 0;
      for (int i = 2; i <= Math.sqrt(n); i++) {
        if (n % i == 0) return i;
      }
      return n;
    };

    System.out.println(smallesDivisor.findSmallestDivisor(273));
  }
}