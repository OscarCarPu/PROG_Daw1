package ejercicio3;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class App {
  public static void main(String[] args) {
    Supplier<Integer> randomSupplier = () -> (int) (Math.random() * 10 + 1);

    Stream.generate(randomSupplier)
        .limit(5)
        .forEach(System.out::println);
  }
}