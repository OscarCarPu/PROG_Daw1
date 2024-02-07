package ejercicio2;

import java.util.*;

public class App{
  public static List<Integer> swapPairs(List<Integer> l){
    int n = l.size();
    for(int i=1;i<n;i+=2){
      int val1=l.get(i);
      int val2=l.get(i-1);
      l.set(i,val2);
      l.set(i-1,val1);
    }
    return l;
  }

  public static void main(String[] args){
    List<Integer> l = new ArrayList<>();
    for(int i=0;i<13;i++){
      l.add(i);
    }
    l = swapPairs(l);
    l.forEach(i -> System.out.print(i+" "));
  }
}