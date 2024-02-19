package ejercicio4;
import java.util.*;
public class App{
  public static void main(String[] args){
    TreeSet<Integer> ts = new TreeSet<Integer>();
    Random r = new Random();
    while(ts.size()<50){
      int x = r.nextInt(100);
      ts.add(x);
    }
    System.out.println("Random: "+ts);
  }
}