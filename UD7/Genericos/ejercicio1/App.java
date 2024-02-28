package ejercicio1;

public class App {
  public static void main(String[] args){
    Pair<Integer,Float> pif = new Pair<Integer,Float>();
    pif.setFirst(3);
    pif.setSecond(5.6f);
    System.out.println("pif: "+pif.getFirst()+" "+pif.getSecond());
    Pair<String,Integer[]> psI = new Pair<String,Integer[]>();
    psI.setFirst("Hola");
    psI.setSecond(new Integer[]{3,4,5});
    System.out.println("psI: "+psI.getFirst()+" "+psI.getSecond());
    Pair<Persona,Persona> ppp = new Pair<Persona,Persona>();
    ppp.setFirst(new Persona("Alfredo"));
    ppp.setSecond(new Persona("Oscar"));
    System.out.println("ppp: "+ppp.getFirst()+" "+ppp.getSecond());
  }
}