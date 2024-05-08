package competicion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Carrera {
  private String nombre;
  private Date fecha;
  private double km;
  private int[] premios;
  private List<Equipo> equipos;
  static final int MAX_PREMIOS = 3;

  public Carrera(String nombre, Date fecha, double km, int[] premios) {
    this.nombre = nombre;
    this.fecha = fecha;
    this.km = km;
    this.premios = premios;
    equipos = new ArrayList<>();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null)
      return false;
    if (obj == this)
      return true;
    if (obj.getClass() != this.getClass())
      return false;
    Carrera c = (Carrera) obj;
    return c.nombre.equals(this.nombre);
  }

  public void addEquipo(Equipo equipo) {
    equipos.add(equipo);
  }

  public boolean hasEquipo(Equipo equipo) {
    return equipos.contains(equipo);
  }

  public int getPremio(int posicion) {
    return premios[posicion];
  }

  public String getNombre() {
    return nombre;
  }

  @Override
  public String toString() {
    return "Carrera: " + nombre + ", Fecha: " + fecha + ", Km: " + km + "\nPremios: " + premios[0] + "€, " + premios[1]
        + "€, " + premios[2] + "€";
  }

  public List<Equipo> getEquipos() {
    return equipos;
  }
}