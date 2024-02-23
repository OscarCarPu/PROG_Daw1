package centro_academico;

import java.util.*;

public class Asignatura {

  private String codigo;
  private String nombre;
  private int creditos;
  private Set<Alumno> alumnos;

  public Asignatura(String codigo, String nombre, int creditos) {
    this.codigo = codigo;
    this.nombre = nombre;
    this.creditos = creditos;
    alumnos = new HashSet<>();
  }

  public String getCodigo() {
    return codigo;
  }

  public void matricular(Alumno a){
    alumnos.add(a);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof Asignatura)) return false;
    Asignatura a = (Asignatura) o;
    return a.codigo.equals(codigo);
  }

  public String getNombre() {
    return nombre;
  }

  public String print() throws AsignaturasException{
	  if(alumnos.size()==0)throw new AsignaturasException();
    return (
      "Codigo: " + codigo + " Nombre: " + nombre + " Creditos: " + creditos
    );
  }
}
