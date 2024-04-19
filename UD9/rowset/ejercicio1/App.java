package ejercicio1;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class App {
  private  static JdbcRowSet rowSet = null;
  private static Scanner in = new Scanner(System.in);

  public static void main(String[] args) throws SQLException {
    create();
    int option=0;
    do{
      System.out.println("Que quieres hacer?");
      System.out.println("1. Mostrar registros");
      System.out.println("2. Mostrar numero de personas");
      System.out.println("3. Jugar con la posicion");
      System.out.println("4. Actualizar persona");
      System.out.println("5. Eliminar ultima persona");
      System.out.println("6. Insertar nueva persona");
      System.out.println("-1. Salir");
      option = in.nextInt();
      switch(option){
        case 1:
          mostrarRegistros();
          break;
        case 2:
          mostrarNumeroPersonas();
          break;
        case 3:
          jugarConPosicion();
          break;
        case 4:
          updatePersona();
          break;
        case 5:
          deleteLastPersona();
          break;
        case 6:
          insertNuevaPersona();
          break;
        case -1:
          break;
        default:
          System.out.println("Opcion no valida");
          break;
      }
    }while(option!=-1);
  }

  public static void mostrarRegistros() throws SQLException{
    rowSet.setCommand("SELECT * FROM person");
    rowSet.execute();
    List<Persona> personas = new ArrayList<Persona>();
    while (rowSet.next()) {
      personas.add(new Persona(rowSet.getInt("id"), rowSet.getString("name"), rowSet.getString("lastname"),
          rowSet.getInt("age")));
    }
    System.out.println("Personas:");
    for (Persona persona : personas) {
      System.out
          .println("ID: " + persona.getId() + " Nombre: " + persona.getName() + " Apellido: " + persona.getLastname()
              + " Edad: " + persona.getAge());
    }

  }

  public static void mostrarNumeroPersonas() throws SQLException{
    rowSet.setCommand("SELECT COUNT(*) FROM person");
    rowSet.execute();
    int personas = 0;
    while (rowSet.next()) {
      personas = rowSet.getInt(1);
    }

    System.out.println("Numero de personas: " + personas);
  }

  public static void jugarConPosicion() throws SQLException{
    System.out.println("Introduce la posicion de la persona a modificar: ");
    int posicion = in.nextInt();
    rowSet.setCommand("SELECT * FROM person");
    rowSet.execute();
    rowSet.absolute(posicion);
    System.out.println("ID: " + rowSet.getInt("id") + " Nombre: " + rowSet.getString("name") + " Apellido: "
        + rowSet.getString("lastname") + " Edad: " + rowSet.getInt("age"));
    int option = 0;
    while(option!=-1){
      System.out.println("Que quieres hacer?");
      System.out.println("1. Siguinte");
      System.out.println("2. Anterior");
      System.out.println("-1. Salir");
      option = in.nextInt();
      switch(option){
        case 1:
          if(rowSet.next()){
            System.out.println("ID: " + rowSet.getInt("id") + " Nombre: " + rowSet.getString("name") + " Apellido: "
            + rowSet.getString("lastname") + " Edad: " + rowSet.getInt("age"));
          }else{
            System.out.println("No hay mas registros");
          }
          break;
        case 2:
          if(rowSet.previous()){
            System.out.println("ID: " + rowSet.getInt("id") + " Nombre: " + rowSet.getString("name") + " Apellido: "
            + rowSet.getString("lastname") + " Edad: " + rowSet.getInt("age"));
          }else{
            System.out.println("No hay mas registros");
          }
          break;
        case -1:
          break;
        default:
          System.out.println("Opcion no valida");
          break;
      }
    }
  }

  public static void updatePersona() throws SQLException{
    System.out.println("Introduce la posicion de la persona a modificar: ");
    int posicion = in.nextInt();
    rowSet.setCommand("SELECT * FROM person");
    rowSet.execute();
    rowSet.absolute(posicion);
    System.out.println("ID: " + rowSet.getInt("id") + " Nombre: " + rowSet.getString("name") + " Apellido: "
        + rowSet.getString("lastname") + " Edad: " + rowSet.getInt("age"));
    System.out.println("Introduce el nuevo nombre: ");
    String name = in.next();
    System.out.println("Introduce el nuevo apellido: ");
    String lastname = in.next();
    System.out.println("Introduce la nueva edad: ");
    int age = in.nextInt();
    rowSet.updateString("name", name);
    rowSet.updateString("lastname", lastname);
    rowSet.updateInt("age", age);
    rowSet.updateRow();
    System.out.println("Persona actualizada");
  }

  public static void deleteLastPersona() throws SQLException{
    rowSet.setCommand("SELECT * FROM person");
    rowSet.execute();
    rowSet.last();
    rowSet.deleteRow();
    System.out.println("Ultima persona eliminada");
  }

  public static void insertNuevaPersona() throws SQLException{
    System.out.println("Introduce el nombre: ");
    String name = in.next();
    System.out.println("Introduce el apellido: ");
    String lastname = in.next();
    System.out.println("Introduce la edad: ");
    int age = in.nextInt();
    rowSet.moveToInsertRow();
    rowSet.updateString("name", name);
    rowSet.updateString("lastname", lastname);
    rowSet.updateInt("age", age);
    rowSet.insertRow();
    rowSet.moveToCurrentRow();
    System.out.println("Persona insertada");
  }

  public static void create() {
    try {
      rowSet = RowSetProvider.newFactory().createJdbcRowSet();
      rowSet.setUrl("jdbc:mariadb://dbalumnos.sanclemente.local:3314/empresa_a23OscarCP");

      rowSet.setUsername("alumno");
      rowSet.setPassword("abc123..");

    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
