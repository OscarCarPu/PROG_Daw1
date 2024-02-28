package ejercicio1;

import java.util.*;
import java.io.*;

public class App{
  public static void main(String[] args){
    Scanner in = null;
    try{
      in = new Scanner(new File(".\\ejercicio1\\test.txt"));
      while(in.hasNext()) {
        System.out.println(in.nextLine());
      }
    } catch(FileNotFoundException e){
      e.printStackTrace();
    } finally {
      if(in!=null){
        in.close();
      }
    }
  }
}