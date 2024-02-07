package ejercicio6;

public class App{
  public static void main(String[] args){
     Agencia agencia = new Agencia();

     agencia.insert(new Reserva("Madrid","Barcelona",1,true, new Pasajero()));
     agencia.insert(new Reserva("Barcelona","A coruña",2,false,new Pasajero()));
     agencia.insert(new Reserva("Paris","Santiago de Compsotela",43,true,new Pasajero()));

     System.out.println("Curent");
  } 
}