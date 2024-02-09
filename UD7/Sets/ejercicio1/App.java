package ejercicio1;

import java.util.*;

public class App{
  public static int maxLength(HashSet<String> h){
    int ma=0;
    for(String str : h){
      ma=Math.max(ma,str.length());
    }
    return ma;
  }

  public static boolean hasOdd(HashSet<Integer> h){
    boolean a = false;
    for(int i : h){
      a = a || (i%2==1);
    }
    return a;
  }

  public static void removeEvenLength(HashSet<String> set) {
    HashSet<String> toRemove = new HashSet<>(); 
    for (String str : set) {
        if (str.length() % 2 == 0) {
            toRemove.add(str);
        }
    }
    set.removeAll(toRemove); 
  }
    public static void main(String[] args) {
      // Ejemplos de uso
      HashSet<String> stringSet = new HashSet<>();
      stringSet.add("Hola");
      stringSet.add("Mundo");
      stringSet.add("Java");
      stringSet.add("Programación");
      stringSet.add("Ejercicio");
      System.out.println("Longitud de la cadena más larga: " + maxLength(stringSet));

      HashSet<Integer> integerSet = new HashSet<>();
      integerSet.add(2);
      integerSet.add(4);
      integerSet.add(6);
      integerSet.add(7);
      integerSet.add(8);
      System.out.println("¿Contiene algún número impar? " + hasOdd(integerSet));

      HashSet<String> stringSet2 = new HashSet<>();
      stringSet2.add("Hola");
      stringSet2.add("Adiós");
      stringSet2.add("Mundo");
      stringSet2.add("Java");
      stringSet2.add("Programación");
      removeEvenLength(stringSet2);
      System.out.println("Set después de eliminar cadenas de longitud par: " + stringSet2);
  }
}
