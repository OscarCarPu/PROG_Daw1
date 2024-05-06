package competicion;

public class Equipo {
  private String nombre;
  private int puntos;
  private Participante capitan;
  private Participante[] miembros;
  static final int MAX_MIEMBROS = 5;

  public Equipo(String nombre, Participante capitan){
    this.nombre = nombre;
    this.capitan = capitan;
    this.miembros = new Participante[MAX_MIEMBROS];
    this.miembros[0] = capitan;
  }

  public Equipo(String nombre, Participante capitan, Participante[] miembros){
    this.nombre = nombre;
    this.capitan = capitan;
    this.miembros = new Participante[MAX_MIEMBROS];
    this.miembros[0] = capitan;
    for (int i = 1; i < miembros.length; i++){
      this.miembros[i] = miembros[i];
    }
  }
  
  public void addMiembro(Participante miembro){
    for (int i = 1; i < miembros.length; i++){
      if (miembros[i] == null){
        miembros[i] = miembro;
        return;
      }
    }
  }

  public boolean hasParticipante(Participante participante){
    for (int i = 0; i < miembros.length; i++){
      if (miembros[i] != null && miembros[i].equals(participante)){
        return true;
      }
    }
    return false;
  }

  public void otorgarPuntos(int puntos){
    this.puntos += puntos;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) return false;
    if (obj == this) return true;
    if (obj.getClass() != this.getClass()) return false;
    Equipo e = (Equipo) obj;
    return e.nombre.equals(this.nombre);
  }
}
