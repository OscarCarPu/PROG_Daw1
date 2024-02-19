package ejercicio2;

public class Pasajero {
  private String dni;
  private String nombre;
  private String apellidos;
  private int edad;
  private String nacionalidad;

  // Constructor vacío
  public Pasajero() {
  }

  // Constructor con parámetros
  public Pasajero(String dni, String nombre, String apellidos, int edad, String nacionalidad) {
      this.dni = dni;
      this.nombre = nombre;
      this.apellidos = apellidos;
      this.edad = edad;
      this.nacionalidad = nacionalidad;
  }

  // Getters y setters
  public String getDni() {
      return dni;
  }

  public void setDni(String dni) {
      this.dni = dni;
  }

  public String getNombre() {
      return nombre;
  }

  public void setNombre(String nombre) {
      this.nombre = nombre;
  }

  public String getApellidos() {
      return apellidos;
  }

  public void setApellidos(String apellidos) {
      this.apellidos = apellidos;
  }

  public int getEdad() {
      return edad;
  }

  public void setEdad(int edad) {
      this.edad = edad;
  }

  public String getNacionalidad() {
      return nacionalidad;
  }

  public void setNacionalidad(String nacionalidad) {
      this.nacionalidad = nacionalidad;
  }
}