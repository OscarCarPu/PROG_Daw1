package ejercicio3;

import java.io.Serializable;

public class Persona implements Serializable{
  private String nombre;
  private transient String password;
  private static final long serialVersionUID = 1L;

  public Persona(String nombre,String password) {
    this.nombre=nombre;
    this.password=password;
  }

  @Override
  public String toString(){
    return nombre+":"+password;
  }
}
