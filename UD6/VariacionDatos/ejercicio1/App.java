package ejercicio1;

public class App{
  public static void main(String[] args){
    try{
      DNI a = new DNI("342A7276A");
    }catch(DNIException e){
      System.out.println(e);
    }
  }
}