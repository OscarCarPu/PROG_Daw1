package centro_academico;

public interface InterfazCliente {
  public boolean crearAlumno(String expediente, String nombre);

  public boolean crearAsignatura(String codigo, String nombre, String creditos);

  public boolean matricular(String expediente, String codigo);

  public void imprimirAlumno(String expediente);

  public void imprimirAlumnos();

  public void imprimirAsignatura(String codigo);

  public boolean agregarCalificacion(String expediente,String codigo,double calificacion);

  public void compararAlumno(String expediente1, String expediente2);
}
