package tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
  public static void main(String[] args) {
    lista.stream()
    .sorted(Comparator.comparing( p -> p.getApellidos()))
    .forEach(System.out::println);
  }
}
