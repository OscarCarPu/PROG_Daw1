package centro_academico;

public class Asignatura {

  private String codigo;
  private String nombre;
  private String creditos;

  public Asignatura(String codigo, String nombre, String creditos) {
    this.codigo = codigo;
    this.nombre = nombre;
    this.creditos = creditos;
  }

  public String getCodigo() {
    return codigo;
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

  @Override
  public String toString() {
    return (
      "Codigo: " + codigo + " Nombre: " + nombre + " Creditos: " + creditos
    );
  }
}
