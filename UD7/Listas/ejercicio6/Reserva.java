package ejercicio6;

public class Reserva{
  private Avion avion;
  private String origen;
  private String destino;
  private int plaza;
  private boolean businness;
  private Pasajero pasajero;

  public Reserva(Avion avion,String origen,String destino,int plaza,boolean businness,Pasajero pasajero){
    this.avion=avion;
    this.origen=origen;
    this.destino=destino;
    this.plaza=plaza;
    this.businness=businness;
    this.pasajero=pasajero;
  }
}