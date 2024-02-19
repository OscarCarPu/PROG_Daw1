package ejercicio3;

public class Estudiante implements Comparable<Object>{
  private String nombre;
  private int edad;

  public Estudiante(String nombre,int edad){
    this.nombre=nombre;
    this.edad=edad;
  }

  @Override
  public String toString(){
    return nombre+" tiene "+edad+" años.";
  }

  @Override
  public int compareTo(Object o){
    Estudiante e = (Estudiante)o;
    if(e.nombre.equals(this.nombre)){
      return this.edad-e.edad;
    }
    return this.nombre.compareTo(e.nombre);
  }
}