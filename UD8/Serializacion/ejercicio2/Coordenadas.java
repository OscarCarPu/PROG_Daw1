package ejercicio2;

import java.io.Serializable;

public class Coordenadas implements Serializable{
  @SuppressWarnings("unused")
  private String latitud;
  @SuppressWarnings("unused")
  private String longitud;

  public Coordenadas(String latitud,String longitud){
    this.latitud=latitud;
    this.longitud=longitud;
  }

  @Override
  public String toString(){
    return "latituda: "+latitud+", longitud: "+longitud;
  }

}