package parking_repaso;

public class Coche extends Vehiculo{
  public Coche(String matricula,String color){
    super(matricula,color);
    this.setPlazas(1);
  }
}