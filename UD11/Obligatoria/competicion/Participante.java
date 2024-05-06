package competicion;

public class Participante {
  private String nombre;
  private String apellidos;
  private char sexo;
  private int edad;
  private String categoria;

  public Participante(String nombre, String apellidos, char sexo, int edad) {
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.sexo = sexo;
    this.edad = edad;
    this.categoria = calcularCategoria();
  }

  public String calcularCategoria(){
    if (edad<8) return "Benjamin";
    if (edad<11) return "Alevin";
    if (edad<13) return "Infantil";
    if (edad<15) return "Cadete";
    if (edad<19) return "Juvenil";
    if (edad<31) return "Senior";
    return null;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) return false;
    if (obj == this) return true;
    if (obj.getClass() != this.getClass()) return false;
    Participante p = (Participante) obj;
    return p.nombre.equals(this.nombre);
  }
  
}
