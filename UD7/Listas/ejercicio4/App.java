package ejercicio4;

import java.util.*;

public class App{
  public static List<String> markLength4(List<String> l){
    List<String> l2 = new ArrayList<>();
    for(String a : l){
      if(a.length()==4){
        l2.add("****");
      }
      l2.add(a);
    }
    return l2;
  }

  public static void main(String[] args){
    List<String> l = new ArrayList<>();
    for(String s : new String[]{"this","is","lots","of","fun","for","every","Java","programmer"}){
      l.add(s);
    }
    l = markLength4(l);
    l.forEach(s -> System.out.print(s+" "));
  }
}