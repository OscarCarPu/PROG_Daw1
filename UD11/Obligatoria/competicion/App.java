package competicion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class App {
  private List<Participante> participantes;
  private List<Carrera> carreras;
  private List<Equipo> equipos;

  public App() {
    participantes = new ArrayList<>();
    carreras = new ArrayList<>();
    equipos = new ArrayList<>();
  }

  public void crearDatosInternalmente() throws Exception{
    Participante p1 = new Participante("Juan", "Garcia", 'M', 25);
    Participante p2 = new Participante("Maria", "Lopez", 'F', 30);
    Participante p3 = new Participante("Pedro", "Martinez", 'M', 18);
    Participante p4 = new Participante("Ana", "Gonzalez", 'F', 15);
    Participante p5 = new Participante("Luis", "Perez", 'M', 10);
    Participante p6 = new Participante("Sara", "Sanchez", 'F', 8);
    Participante p7 = new Participante("Carlos", "Fernandez", 'M', 35);
    Participante p8 = new Participante("Elena", "Ramirez", 'F', 40);
    Participante p9 = new Participante("Javier", "Gomez", 'M', 50);
    Participante p10 = new Participante("Rosa", "Jimenez", 'F', 55);

    Equipo e1 = new Equipo("Equipo 1", p1);
    Equipo e2 = new Equipo("Equipo 2", p2);
    Equipo e3 = new Equipo("Equipo 3", p3);

    Carrera c1 = new Carrera("Carrera 1", new Date(), 10, new int[]{100, 50, 25});
    Carrera c2 = new Carrera("Carrera 2", new Date(), 15, new int[]{150, 75, 50});
    
    participantes = List.of(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);
    equipos = List.of(e1, e2, e3);
    carreras = List.of(c1, c2);

    this.altaEquipoCarrera(e3, c2);
    this.altaEquipoCarrera(e2, c1);

    this.altaParticipanteEquipo(p4, e1);
    this.altaParticipanteEquipo(p5, e1);
    this.altaParticipanteEquipo(p6, e1);
    this.altaParticipanteEquipo(p7, e2);
    this.altaParticipanteEquipo(p8, e2);
    this.altaParticipanteEquipo(p9, e3);
    this.altaParticipanteEquipo(p10, e3);

    this.otorgarPremio(e1, c1, 1);
    this.otorgarPremio(e2, c1, 2);
    this.otorgarPremio(e3, c2, 1);
    
  }

  public void altaEquipoCarrera(Equipo equipo, Carrera carrera) throws Exception{
    if (carrera.hasEquipo(equipo)) throw new Exception("El equipo ya esta inscrito en la carrera");
    if (equipos.contains(equipo) && carreras.contains(carrera)){
      carrera.addEquipo(equipo);
    }
  }

  public void altaParticipante(Participante participante) throws Exception{
    if (participantes.contains(participante)) throw new Exception("El participante ya esta inscrito");  
    participantes.add(participante);
  }

  public void altaParticipanteEquipo(Participante participante, Equipo equipo) throws Exception{
    if(equipo.hasParticipante(participante)) throw new Exception("El participante ya esta en el equipo");
    if (equipos.contains(equipo) && participantes.contains(participante)){
      equipo.addMiembro(participante);
    }
  }
  
  public void bajaEquipoCarrera(Equipo equipo, Carrera carrera) throws Exception{
    if (!carrera.hasEquipo(equipo)) throw new Exception("El equipo no esta inscrito en la carrera");
    if (equipos.contains(equipo) && carreras.contains(carrera)){
      equipos.remove(equipo);
    }
  }

  public void otorgarPremio(Equipo equipo, Carrera carrera, int posicion) throws Exception{
    if (!carrera.hasEquipo(equipo)) throw new Exception("El equipo no esta inscrito en la carrera");
    if (posicion < 1 || posicion >= Carrera.MAX_PREMIOS) throw new Exception("Posicion no valida");
    equipo.otorgarPuntos(carrera.getPremio(posicion));
  }


}
