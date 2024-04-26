package ejercicio3;

import java.util.function.Supplier;

public class App {
  public static void main(String[] args) {
    Supplier<Student> s = () -> new Student(1, "Juan", "M", 12);

    Student st = s.get();

    System.out.println(st);
  }
}
