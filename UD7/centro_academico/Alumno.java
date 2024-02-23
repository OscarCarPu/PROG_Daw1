package centro_academico;


import java.util.*;

public class Alumno {

  private String expediente;
  private String nombre;
  private Map<Asignatura, Double> notas;
  private double nota_media;

  public Alumno(String expediente, String nombre) {
    this.expediente = expediente;
    this.nombre = nombre;
    notas = new LinkedHashMap<>();
    nota_media = 10;
  }

  public String getExpediente() {
    return expediente;
  }

  public boolean estaMatriculado(Asignatura a) {
    return notas.containsKey(a);
  }

  public void matricular(Asignatura a) {
    notas.put(a, null);
  }

  @Override
  public String toString() {
    StringBuilder re = new StringBuilder();
    re
      .append("Nombre: ")
      .append(nombre)
      .append(" Expediente: ")
      .append(expediente);

    notas.forEach((a, n) ->
      re.append("\n").append(a.getNombre()).append(" ").append((n!=null)?n:"-")
    );

    re.append("\nNota media: ").append(nota_media);
    return re.toString();
  }

  public void actualizarNotaMedia() {
    double nota_total = 0;
    double cnt = 0;
    Set<Asignatura> asig = notas.keySet();
    for (Asignatura a : asig) {
      if (notas.get(a) != null) {
        nota_total += notas.get(a);
        cnt += 1;
      }
    }
    if(cnt!=0)nota_media = nota_total / cnt;
    else nota_media=10;
  }

  public void agregarCalificacion(Asignatura a, double nota) {
    notas.replace(a,nota);
    actualizarNotaMedia();
  }

  public double getNotaMedia() {
    actualizarNotaMedia();
    return nota_media;
  }
}
