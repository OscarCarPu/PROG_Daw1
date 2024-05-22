package festival;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class DB {

	private static JdbcRowSet jdbc;

	private static void connect() throws SQLException {
		jdbc = RowSetProvider.newFactory().createJdbcRowSet();
		jdbc.setUrl("jdbc:mariadb://dbalumnos.sanclemente.local:3314/OCP_festival");
		jdbc.setUsername("alumno");
		jdbc.setPassword("abc123..");
	}

	private static void close() throws SQLException {
		jdbc.close();
	}

	public static Festival getFestival() throws Exception {
		connect();
		Festival f = null;
		List<Slot> slots = new ArrayList<>();
		Map<Integer, Grupo> grupos = new HashMap<>();
		jdbc.setCommand("select * from grupos");
		jdbc.execute();

		while (jdbc.next()) {
			try {
				grupos.put(jdbc.getInt("idGrupo"),
						new Grupo(jdbc.getString("nombre"), jdbc.getInt("cache"), jdbc.getString("tipo")));
			} catch (Exception e) {
				throw new Exception("Error leyendo un grupo");
			}
		}

		jdbc.setCommand("select * from slots");
		jdbc.execute();
		while (jdbc.next()) {
			try {
				slots.add(new Slot(jdbc.getString("dia").charAt(0), jdbc.getInt("franja"),
						grupos.get(jdbc.getInt("idGrupo"))));
			} catch (Exception e) {
				throw new Exception("Error leyendo un slot");
			}
		}

		jdbc.setCommand("select * from festival limit 1");
		jdbc.execute();
		if (jdbc.next()) {
			try {
				f = new Festival(jdbc.getString("nombre"), jdbc.getInt("tipo"), jdbc.getInt("aforo"),
						jdbc.getInt("presupuesto"), slots);
			} catch (Exception e) {
				throw new Exception("Error leyendo el festival");
			}
		}
		close();
		return f;
	}

	public static List<Grupo> getGrupos() throws Exception {
		connect();
		List<Grupo> grupos = new ArrayList<>();
		jdbc.setCommand("select * from grupos");
		jdbc.execute();
		while (jdbc.next()) {
			try {
				grupos.add(new Grupo(jdbc.getString("nombre"), jdbc.getInt("cache"), jdbc.getString("tipo")));
			} catch (Exception e) {
				throw new Exception("Error leyendo un grupo");
			}
		}

		close();
		return grupos;
	}

	public static void deleteGrupo(String nombre) throws Exception {
		connect();
		jdbc.setCommand("select idGrupo from grupos where nombre = ?");
		jdbc.setString(1, nombre);
		jdbc.execute();
		jdbc.first();
		int id = jdbc.getInt("idGrupo");
		jdbc.setCommand("select * from slots where idGrupo = ?");
		jdbc.setInt(1, id);
		jdbc.execute();
		while (jdbc.next()) {
			jdbc.deleteRow();
		}
		jdbc.setCommand("select * from grupos where nombre = ?");
		jdbc.setString(1, nombre);
		jdbc.execute();
		jdbc.first();
		jdbc.deleteRow();
		close();
	}

	public static void actualizarCache(String nombre, int cache) throws Exception {
		connect();
		jdbc.setCommand("select * from grupos where nombre = ?");
		jdbc.setString(1, nombre);
		jdbc.execute();
		jdbc.first();
		jdbc.updateInt("cache", cache);
		jdbc.updateRow();
		close();
	}
}
