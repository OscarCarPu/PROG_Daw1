package podcast;

public class Autor {
  private int id;
  private String dni;
  private String apellidos;
  private String nombre;

  public Autor(int id, String dni, String apellidos, String nombre) {
    this.id = id;
    this.dni = dni;
    this.apellidos = apellidos;
    this.nombre = nombre;
  }

  public Autor(String dni, String apellidos, String nombre) {
    this.dni = dni;
    this.apellidos = apellidos;
    this.nombre = nombre;
  }

  public Autor() {

  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDni() {
    return dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }

  public String getApellidos() {
    return apellidos;
  }

  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  @Override
  public String toString() {
    return nombre + " " + apellidos;
  }
}
