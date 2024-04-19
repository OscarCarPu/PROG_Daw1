package ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class App {
  static Connection con = null;

  public static void main(String[] args) {
    String sURL = "jdbc:mariadb://dbalumnos.sanclemente.local:3314/empresa_a23OscarCP";
    conectar(sURL);

    Scanner in = new Scanner(System.in);

    conocerSalarioPosicion(in);

    getGastoSalario();

    getMasQueSalario(in);

    getPosicionEqual(in);

    cerrarConexion();
  }

  private static void getPosicionEqual(Scanner in) {
    System.out.println("Introduce una posicion: ");
    String posicion = in.next();
    try {
      System.out.println("Hay " + empleadoMasPosicion(posicion) + " empleados con la posicion " + posicion);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private static void getMasQueSalario(Scanner in) {
    System.out.println("Introduce un salario: ");
    int salario = in.nextInt();
    try {
      System.out.println("Hay " + empledosMasSalario(salario) + " empleados con un salario mayor a " + salario);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private static void cerrarConexion() {
    try {
      if (con != null)
        con.close();
    } catch (Exception e) {
      System.out.println("Error cerrando conexiones: "
          + e.toString());
    }
  }

  private static void getGastoSalario() {
    int gastoSalario = 0;
    try {
      gastoSalario = getSalarioTotal();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    System.out.println("El gasto total en salarios es de: " + gastoSalario);
  }

  private static void conocerSalarioPosicion(Scanner in) {
    System.out.println("Introduce el número de empleado: ");
    int numEmpleado = in.nextInt();
    Empleado em = null;
    try {
      em = getEmpleado(numEmpleado);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    System.out.println("El empleado con id " + numEmpleado + " tiene posicion: " + em.getPosicion() + " y salario: "
        + em.getSalario());
  }

  private static void conectar(String sURL) {
    try {

      con = (Connection) DriverManager.getConnection(sURL, "alumno", "abc123..");
      System.out.println("¡Conexión exitosa!");

    } catch (Exception e) {
      System.out.println("Error en la conexión:" + e.toString());
    }
  }

  public static Empleado getEmpleado(int id) throws SQLException {
    String sql = "SELECT * FROM empleados WHERE emp_id = ?";
    Empleado e = null;
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setInt(1, id);
    ResultSet rs = ps.executeQuery();
    if (rs.next()) {
      e = new Empleado(rs.getInt("emp_id"), rs.getString("name"), rs.getString("posicion"), rs.getDouble("salary"));
    }
    return e;
  }

  public static int getSalarioTotal() throws SQLException {
    String sql = "SELECT SUM(salary) FROM empleados";
    PreparedStatement ps = con.prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    if (rs.next()) {
      return rs.getInt(1);
    }
    return 0;
  }

  public static int empledosMasSalario(int salario) throws SQLException {
    String sql = "SELECT COUNT(*) FROM empleados WHERE salary > ?";
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setInt(1, salario);
    ResultSet rs = ps.executeQuery();
    if (rs.next()) {
      return rs.getInt(1);
    }
    return 0;
  }

  public static int empleadoMasPosicion(String posicion) throws SQLException {
    String sql = "SELECT COUNT(*) FROM empleados WHERE posicion = ?";
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setString(1, posicion);
    ResultSet rs = ps.executeQuery();
    if (rs.next()) {
      return rs.getInt(1);
    }
    return 0;
  }
}
