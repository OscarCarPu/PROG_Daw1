package ejercicio5;

import java.util.*;

public class App{
  public static TreeSet<Integer> delLast(TreeSet<Integer> a){
    System.out.println("Deleting: "+a.last());
    a.remove(a.last());
    return a;
  }

  public static void main(String[] args){
    TreeSet<Integer> a = new TreeSet<Integer>();
    a.addAll(Arrays.asList(1,2,4,5,6));
    a=delLast(a);
    a=delLast(a);
  }
}