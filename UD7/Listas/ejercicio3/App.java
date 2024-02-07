package ejercicio3;

import java.util.*;

public class App{
  public static List<Integer> minToFront(List<Integer> l){
    int mi=l.get(0);
    for(int i : l){
      mi=Math.min(mi,i);
    }
    int idx=l.indexOf(mi);
    l.remove(idx);
    l.add(0,mi);
    return l;
  }

  public static void main(String[] args){
    List<Integer> l = new ArrayList<>();
    for(int i : new int[]{3,8,92,4,2,17,9}){
      l.add(i);
    }
    l = minToFront(l);
    l.forEach(i -> System.out.print(i+" "));
  }
}