package ejercicio3;
import java.util.*;
public class App{
  public static void main(String[] args){
    TreeSet<Integer> a = new TreeSet<Integer>();
    a.addAll(Arrays.asList(5,7,9,19));
    TreeSet<Integer> b = new TreeSet<Integer>();
    b.addAll(Arrays.asList(10,20,5,7));
    TreeSet<Integer> union=new TreeSet<Integer>();
    union.addAll(a);
    union.addAll(b);
    TreeSet<Integer> difference=new TreeSet<Integer>();
    difference.addAll(a);
    for(int x : b){
      if(difference.contains(x)){
        difference.remove(x);
      }
    }

    TreeSet<Integer> inter = new TreeSet<Integer>();
    for(int x : b){
      if(a.contains(x)){
        inter.add(x);
      }
    }    
    System.out.println("A:"+a);
    System.out.println("B:"+b);
    System.out.println("A union B: "+union);
    System.out.println("A diferencia B: "+difference);
    System.out.println("A intersección B: "+inter);
  }
}