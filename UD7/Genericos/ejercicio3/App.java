package ejercicio3;

public class App{
  public static void main(String[] args){
    Integer[] a = new Integer[]{43,42,156,45};
    Double[] b = new Double[]{4.2,74.235,23.54,123.53};
    Persona[] c = new Persona[]{new Persona("Alfredo"),new Persona("Oscar"),new Persona("Manuel"),new Persona("Jose")};
Util.imprimirArray(a);
Util.imprimirArray(b);
Util.imprimirArray(c);
  }
}