package ejercicio5;

import java.util.*;

public class App{
  public static List<Integer> filterRange(List<Integer> l,int min,int max){
    List<Integer> l2 = new ArrayList<>();;
    for(int i : l){
      if(i<min || i>max){
        l2.add(i);
      }
    }
    return l2;
  }

  public static void main(String[] args){
    List<Integer> l = new ArrayList<>();
    for(int i : new int[]{4,7,9,2,7,7,5,3,5,1,7,8,6,7}){
      l.add(i);
    }
    l=filterRange(l,5,7);
    l.forEach(i -> System.out.print(i+" "));
  }
}