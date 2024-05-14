package agenda;

import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class BD {
  private static JdbcRowSet jrs;

  public static void conectar() throws Exception {
    jrs = RowSetProvider.newFactory().createJdbcRowSet();
    jrs.setUrl("jdbc:mariadb://dbalumnos.sanclemente.local:3314/agenda_a23OscarCP");
    jrs.setUsername("alumno");
    jrs.setPassword("abc123..");
  }

  public static void cerrar() throws Exception {
    jrs.close();
  }

  public static List<Contacto> cargarDatos() throws Exception {
    jrs.setCommand("SELECT * from contactos c LEFT JOIN direcciones d ON d.idcontacto=c.idcontactos");
    List<Contacto> contactos = new ArrayList<>();
    jrs.execute();
    while (jrs.next()) {  
      Direccion d = null;
      if(jrs.getString("calle")!=null)
        d=new Direccion(jrs.getString("calle"), jrs.getInt("cp"), jrs.getInt("num"), jrs.getString("ciudad"),jrs.getInt("personal"));
      Contacto c = new Contacto(jrs.getString("nombre"), jrs.getInt("num_telefono"), jrs.getDate("fecha_nac"), d,
          jrs.getString("mail"));
      contactos.add(c);
    }
    return contactos;
  }

}
