package podcast;

public class Autor {
  private int idAutor;
  private String dni;
  private String nombre;
  private String apellidos;

  public Autor (int idAutor,String dni, String nombre, String apellidos) {
    this.idAutor = idAutor;
    this.dni = dni;
    this.nombre = nombre;
    this.apellidos = apellidos;
  }

  public Autor () {
  }

  public int getIdAutor () {
    return idAutor;
  }

  public void setIdAutor (int idAutor) {
    this.idAutor = idAutor;
  }

  public String getDni () {
    return dni;
  }

  public void setDni (String dni) {
    this.dni = dni;
  }

  public String getNombre () {
    return nombre;
  }

  public void setNombre (String nombre) {
    this.nombre = nombre;
  }

  public String getApellidos () {
    return apellidos;
  }

  public void setApellidos (String apellidos) {
    this.apellidos = apellidos;
  }
}
