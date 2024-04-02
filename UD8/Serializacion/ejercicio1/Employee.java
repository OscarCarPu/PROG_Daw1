package ejercicio1;

import java.io.Serializable;

public class Employee implements Serializable {
  String id;
  String firstName;
  String lastName;

  public Employee(String id, String firstName, String lastName) {
    super();
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  @Override
  public String toString() {
    return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
  }
}
