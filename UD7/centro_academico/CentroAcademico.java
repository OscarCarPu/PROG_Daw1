package centro_academico;


import java.util.*;

public class CentroAcademico implements InterfazCliente {

  private List<Alumno> alumnos;
  private List<Asignatura> asignaturas;

  public CentroAcademico() {
    alumnos = new LinkedList<>();
    asignaturas = new LinkedList<>();
  }

  public int buscarAlumno(String expediente) {
    for (int i = 0; i < alumnos.size(); i++) {
      if (alumnos.get(i).getExpediente().equals(expediente)) return i;
    }
    return -1;
  }

  public boolean crearAlumno(String expediente, String nombre) {
    if (buscarAlumno(expediente) != -1) {
      return false;
    }
    alumnos.add(new Alumno(expediente, nombre));
    return true;
  }

  public int buscarAsignatura(String codigo) {
    for (int i = 0; i < asignaturas.size(); i++) {
      if (asignaturas.get(i).getCodigo().equals(codigo)) return i;
    }
    return -1;
  }

  public boolean crearAsignatura(String codigo,String nombre,int creditos) {
    if (buscarAsignatura(codigo) != -1) {
      return false;
    }
    asignaturas.add(new Asignatura(codigo, nombre, creditos));
    return true;
  }

  public boolean matricular(String expediente, String codigo) {
    int idxAl = buscarAlumno(expediente);
    int idxAs = buscarAsignatura(codigo);
    if (idxAl == -1 || idxAs == -1) return false;
    if (alumnos.get(idxAl).estaMatriculado(asignaturas.get(idxAs))) return false;
    alumnos.get(idxAl).matricular(asignaturas.get(idxAs));
    asignaturas.get(idxAs).matricular(alumnos.get(idxAl));
    return true;
  }

  public void imprimirAlumno(String expediente) {
    int idx = buscarAlumno(expediente);
    if (idx == -1){
      System.out.println("El alumno no existe.");
      return;
    }
    System.out.println(alumnos.get(idx));
  }

  public void imprimirAlumnos() {
    alumnos.forEach(a -> System.out.println(a));
  }

  public boolean agregarCalificacion(String expediente,String codigo,double calificacion) {
    if(calificacion<0||calificacion>10)return false;
    int idxAl = buscarAlumno(expediente);
    int idxAs = buscarAsignatura(codigo);
    if (idxAl == -1 || idxAs == -1 ) return false;
    if (
      !alumnos.get(idxAl).estaMatriculado(asignaturas.get(idxAs))
    ) return false;
    alumnos.get(idxAl).agregarCalificacion(asignaturas.get(idxAs), calificacion);
    return true;
  }

  public void compararAlumno(String expediente1, String expediente2) {
    int idx1 = buscarAlumno(expediente1);
    int idx2 = buscarAlumno(expediente2);
    if (idx1 == -1 || idx2 == -1) {
      System.out.println("Alguno de los alumnos no existe");
    } else {
      if(alumnos.get(idx1).getNotaMedia() == alumnos.get(idx2).getNotaMedia()) {
        System.out.println("Ambos alumnos tienen la misma nota media");
        return;
      } else if (alumnos.get(idx1).getNotaMedia() < alumnos.get(idx2).getNotaMedia()) {
        int aux = idx1;
        idx1 = idx2;
        idx2 = aux;
      }
      System.out.println(
        "El alumno con expediente: " +
        alumnos.get(idx1).getExpediente() +
        " tiene mayor nota que el de expediente: " +
        alumnos.get(idx2).getExpediente()
      );
    }
  }

  public void imprimirAsignatura(String codigo) {
    int idx = buscarAsignatura(codigo);
    if (idx == -1){
      System.out.println("La asignatura no existe");
      return;
    }
    try {
		System.out.println(asignaturas.get(idx).print());
	} catch (AsignaturasException e) {
		e.printStackTrace();
	}
  }
}
