package ejercicio1;

public class Empleado {
  private int id;
  private String name;
  private String posicion;
  private double salario;
  
  public Empleado(int id, String name, String posicion, double salario) {
    this.id = id;
    this.name = name;
    this.posicion = posicion;
    this.salario = salario;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getPosicion() {
    return posicion;
  }

  public double getSalario() {
    return salario;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPosicion(String posicion) {
    this.posicion = posicion;
  }

  public void setSalario(double salario) {
    this.salario = salario;
  }
 
  @Override
  public String toString() {
    return "Empleado [id=" + id + ", name=" + name + ", posicion=" + posicion + ", salario=" + salario + "]";
  }
}
