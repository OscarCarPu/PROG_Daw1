package ejercicio1;

public class Person {
  private Integer id;
  private String name;
  private String lastName;
  private Integer age;

  public Person(Integer id, String name, String lastName, Integer age) {
    this.id = id;
    this.name = name;
    this.lastName = lastName;
    this.age = age;
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getLastName() {
    return lastName;
  }

  public Integer getAge() {
    return age;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setAge(Integer age) {
    this.age = age;
  }
}