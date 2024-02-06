package ejercicio2;

public class App{
  public static void main(String[] args){
    try{
      Ip ip = new Ip("00.1.2.1");
    }
    catch(IpException e){
      System.out.println(e);
    }
  }
}