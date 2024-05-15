package agenda;

import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class BD {
  private static JdbcRowSet jrs;

  private static void conectar() throws Exception {
    jrs = RowSetProvider.newFactory().createJdbcRowSet();
    jrs.setUrl("jdbc:mariadb://dbalumnos.sanclemente.local:3314/agenda_a23OscarCP");
    jrs.setUsername("alumno");
    jrs.setPassword("abc123..");
  }

  private static void cerrar() throws Exception {
    jrs.close();
  }

  public static List<Contacto> cargarDatos() throws Exception {
    conectar();
    jrs.setCommand("SELECT * from contactos c LEFT JOIN direcciones d ON d.idcontacto=c.idcontactos");
    List<Contacto> contactos = new ArrayList<>();
    jrs.execute();
    while (jrs.next()) {
      String nombre = jrs.getString("nombre");
      if (contactos.stream().anyMatch(a -> a.getNombre().equals(nombre))) {
        Direccion d = null;
        if (jrs.getString("calle") != null) {
          d = new Direccion(jrs.getString("calle"), jrs.getInt("cp"), jrs.getInt("num"), jrs.getString("ciudad"),
              jrs.getInt("personal"));
          List<Direccion> direcciones = new ArrayList<>();
          direcciones.add(d);
          contactos.stream().filter(a -> a.getNombre().equals(nombre)).findFirst().get().addDireccion(d);
        }
        continue;
      }
      Direccion d = null;
      if (jrs.getString("calle") != null)
        d = new Direccion(jrs.getString("calle"), jrs.getInt("cp"), jrs.getInt("num"), jrs.getString("ciudad"),
            jrs.getInt("personal"));
      List<Direccion> direcciones = new ArrayList<>();
      if(d!=null)direcciones.add(d);
      Contacto c = new Contacto(jrs.getString("nombre"), jrs.getInt("num_telefono"), jrs.getDate("fecha_nac"),
          direcciones,
          jrs.getString("mail"));
      contactos.add(c);
    }
    cerrar();
    return contactos;
  }

}
