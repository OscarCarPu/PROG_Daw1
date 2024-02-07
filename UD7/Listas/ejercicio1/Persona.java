package ejercicio1;

public class Persona{
  private String nombre;
  private String tel;

  public Persona(String nombre,String tel){
    this.nombre=nombre;
    this.tel=tel;
  }

  public String toString(){
    return nombre+" tiene teléfono: "+tel;
  }
}