package competicion;

import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class BD {
  private static JdbcRowSet jrs;

  public static boolean tablaCreada() throws Exception{
    jrs.setCommand("SELECT TABLE_NAME FROM information_schema.TABLES WHERE TABLE_SCHEMA = 'competicion_a23OscarCP' AND TABLE_NAME = 'resumen'");
    jrs.execute();
    return jrs.next();
  }

  public static void crearTabla() throws Exception{
    jrs.setCommand("CREATE TABLE resumen ("
      + "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
      + "nombre VARCHAR(50) NOT NULL,"
      + "equipo_mas_puntos VARCHAR(50) NOT NULL,"
      + "num_participantes INT NOT NULL,"
      + "fecha DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP"
      + ")");
    jrs.execute();
  }

  public static void guardarDatos(Carrera c,App app) throws Exception{
    jrs.setCommand("INSERT INTO resumen (nombre, equipo_mas_puntos, num_participantes) VALUES (?,?,?)");
    jrs.setString(1, c.getNombre());
    List<Equipo> equipos = c.getEquipos();
    Equipo equipoMasPuntos = app.getEquipoMasPuntos(equipos);
    int numParticipantes = app.getNumParticipantes(equipos);
    jrs.setString(2, equipoMasPuntos.getNombre());
    jrs.setInt(3, numParticipantes);
    jrs.execute();
  }

  public static void connectar() throws Exception{
    jrs = RowSetProvider.newFactory().createJdbcRowSet();
    jrs.setUrl("jdbc:mariadb://dbalumnos.sanclemente.local:3314/competicion_a23OscarCP");
    jrs.setUsername("alumno");
    jrs.setPassword("abc123..");
  }

  public static void cerrar() throws Exception{
    jrs.close();
  }

  public static String mostrarDatos() throws Exception {
    jrs.setCommand("SELECT * FROM resumen");
    jrs.execute();
    List<String> results = new ArrayList<>();
    while (jrs.next()) {
      results.add("Nombre: " + jrs.getString("nombre"));
      results.add("Equipo con mas puntos: " + jrs.getString("equipo_mas_puntos"));
      results.add("Numero de participantes: " + jrs.getInt("num_participantes"));
      results.add("Fecha: " + jrs.getTimestamp("fecha"));
      results.add("");
    }
    return String.join("\n", results);
  }

  public static void borrarTabla() throws Exception {
    jrs.setCommand("DROP TABLE resumen");
    jrs.execute();
  }
}
