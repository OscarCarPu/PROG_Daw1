package parking_repaso;

public class Furgoneta extends Vehiculo{
  public Furgoneta(String matricula,String color){
    super(matricula,color);
    this.setPlazas(2);
  }
}