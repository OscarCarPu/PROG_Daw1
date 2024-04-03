package ejercicio_extra;

import java.io.Serializable;

public class Animal implements Serializable{
  private String nombre;
  private int edad;
  private static final long serialVersionUID = 123L;

  public Animal(String nombre,int edad){
    this.nombre=nombre;
    this.edad=edad;
  }

  public String getNombre(){
    return nombre;
  }

  public void setNombre(String nombre){
    this.nombre=nombre;
  }

  public int getEdad(){
    return edad;
  }

  public void setEdad(int edad){
    this.edad=edad;
  }
}
