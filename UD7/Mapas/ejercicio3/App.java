package ejercicio3;

import java.util.*;

public class App {

  public static void main(String[] args) {
    TreeMap<String, Double> alumnos = new TreeMap<>();
    alumnos.put("Juan", 3.2);
    alumnos.put("Alberto", 5.2);
    alumnos.put("Jorge", 6.3);
    alumnos.put("Alejandra", 9.9);

    alumnos.forEach((n, no) -> System.out.println(n + " tiene de media: " + no)
    );

    TreeMap<String, Double> alumnosR = new TreeMap<>(
      Collections.reverseOrder()
    );
    alumnosR.putAll(alumnos);
    alumnosR.forEach((n, no) -> System.out.println(n + " tiene de media: " + no)
    );
  }
}
