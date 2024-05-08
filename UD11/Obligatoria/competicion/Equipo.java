package competicion;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
  private String nombre;
  private int puntos;
  private Participante capitan;
  private List<Participante> miembros;
  static final int MAX_MIEMBROS = 5;

  public Equipo(String nombre, Participante capitan) {
    this.nombre = nombre;
    this.capitan = capitan;
    this.miembros = new ArrayList<>();
    this.miembros.add(capitan);
    this.puntos = 0;
  }

  public Equipo(String nombre, Participante capitan, List<Participante> miembros) {
    this.nombre = nombre;
    this.capitan = capitan;
    this.miembros = miembros;
    this.puntos = 0;
  }

  public void addMiembro(Participante miembro) throws Exception {
    if (miembros.size() < MAX_MIEMBROS) {
      miembros.add(miembro);
    } else {
      throw new Exception("El equipo ya tiene el maximo de miembros");
    }
  }

  public boolean hasParticipante(Participante participante) {
    return miembros.contains(participante);
  }

  public List<Participante> getMiembros() {
    return miembros;
  }

  public void otorgarPuntos(int puntos) {
    this.puntos += puntos;
  }

  public String getNombre() {
    return nombre;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null)
      return false;
    if (obj == this)
      return true;
    if (obj.getClass() != this.getClass())
      return false;
    Equipo e = (Equipo) obj;
    return e.nombre.equals(this.nombre);
  }

  @Override
  public String toString() {
    return "Equipo: " + nombre + ", Puntos: " + puntos + ", Capitan: " + capitan.getNombre() + " "
        + capitan.getApellidos();
  }

  public int getPuntos() {
    return puntos;
  }

  public int getNumParticipantes() {
    return miembros.size();
  }
}
