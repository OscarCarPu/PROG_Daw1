package competicion;

import java.util.Date;
import java.util.List;

public class Carrera{
  private String nombre;
  private Date fecha;
  private double km;
  private int[] premios;
  private List<Equipo> equipos;
  static final int MAX_PREMIOS = 3;

  public Carrera(String nombre, Date fecha, double km, int[] premios){
    this.nombre = nombre;
    this.fecha = fecha;
    this.km = km;
    this.premios = premios;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) return false;
    if (obj == this) return true;
    if (obj.getClass() != this.getClass()) return false;
    Carrera c = (Carrera) obj;
    return c.nombre.equals(this.nombre);
  }

  public void addEquipo(Equipo equipo){
    equipos.add(equipo);
  }

  public boolean hasEquipo(Equipo equipo){
    return equipos.contains(equipo);
  }

  public int getPremio(int posicion){
    return premios[posicion];
  }
}