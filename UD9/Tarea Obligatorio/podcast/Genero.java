package podcast;

public class Genero {
  private int idGeneros;
  private String nombre;

  public Genero (int idGeneros,String nombre) {
    this.nombre = nombre;
    this.idGeneros = idGeneros;
  }
  public Genero () {
  }

  public String getNombre () {
    return nombre;
  }

  public void setNombre (String nombre) {
    this.nombre = nombre;
  }

  public int getIdGeneros () {
    return idGeneros;
  }

  public void setIdGeneros (int idGeneros) {
    this.idGeneros = idGeneros;
  }

  
}
