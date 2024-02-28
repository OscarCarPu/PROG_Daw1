package ejercicio3;

public class Util{
  static <T> void imprimirArray (T[] t){
    for(int i=0;i<t.length;i++){
      System.out.println(t[i].toString());
    }
  }
}