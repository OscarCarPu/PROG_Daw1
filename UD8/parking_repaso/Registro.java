package parking_repaso;

public class Registro{
  private String hora;
  private Vehiculo vehiculo;

  public Registro(String hora,Vehiculo vehiculo){
    this.hora=hora;
    this.vehiculo=vehiculo;
  }

  public String getHora(){
    return this.hora;
  }

  public Vehiculo getVehiculo(){
    return vehiculo;
  }
}