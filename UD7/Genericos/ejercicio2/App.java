package ejercicio2;

public class App {
  public static void main(String[] args){
    Pair<Integer,Float> pif = new Pair<Integer,Float>(3,5.6f);
    System.out.println(pif);
    Pair<String,Integer[]> psI = new Pair<String,Integer[]>("Hola",new Integer[]{3,4,5});
    System.out.println(psI);
    Pair<Persona,Persona> ppp = new Pair<Persona,Persona>(new Persona("Alfredo"),new Persona("Oscar"));
    System.out.println(ppp);
  }
}