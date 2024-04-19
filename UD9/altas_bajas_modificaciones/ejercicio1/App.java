package ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class App implements IPerson{
  
  public Connection openConnection() throws SQLException {
    String sURL = "jdbc:mariadb://dbalumnos.sanclemente.local:3314/empresa_a23OscarCP";
    Connection con = null;
    con = DriverManager.getConnection(sURL, "a23OscarCP", "a23OscarCP");
    return con;
  }

  public int insertPerson(Connection connection, Person person) throws SQLException {
    String sql = "INSERT INTO person (id,name,lastname,age) VALUES (?,?,?,?)";
    PreparedStatement ps = connection.prepareStatement(sql);
    ps.setInt(1, person.getId());
    ps.setString(2, person.getName());
    ps.setString(3, person.getLastName());
    ps.setInt(4, person.getAge());
    return ps.executeUpdate();
  }

  public void updatePersonAgeById(Connection connection, int id, int newAge) throws SQLException {
    String sql = "UPDATE person SET age = ? WHERE id = ?";
    PreparedStatement ps = connection.prepareStatement(sql);
    ps.setInt(1, newAge);
    ps.setInt(2, id);
    ps.executeUpdate();
  }

  public List selectAllPeople(Connection connection) throws SQLException {
    String sql = "SELECT * FROM person";
    PreparedStatement ps = connection.prepareStatement(sql);
    List<Person> people = new ArrayList<>();
    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      people.add(new Person(rs.getInt("id"), rs.getString("name"), rs.getString("lastname"), rs.getInt("age")));
    }
    return people;
  }

  public int deletePerson(Connection connection, int id) throws SQLException {
    String sql = "DELETE FROM person WHERE id = ?";
    PreparedStatement ps = connection.prepareStatement(sql);
    ps.setInt(1, id);
    return ps.executeUpdate();
  }

  public Person maxAgePerson(Connection connection) throws SQLException {
    String sql = "SELECT * FROM person WHERE age = (SELECT MAX(age) FROM person)";
    PreparedStatement ps = connection.prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    rs.next();
    return new Person(rs.getInt("id"), rs.getString("name"), rs.getString("lastname"), rs.getInt("age"));

  }

}
