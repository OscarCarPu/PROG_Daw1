package hotelPerros;

import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Hotel hotel = new Hotel();

    int choice = 0;
    do {
      System.out.println("\nHotel de Perros - Menú:");
      System.out.println("1. Registrar un perro");
      System.out.println("2. Alimentar a los perros");
      System.out.println("3. Llevar a los perros al patio");
      System.out.println("4. Mostrar perros registrados");
      System.out.println("5. Salir");
      System.out.print("Ingrese su opción: ");

      choice = in.nextInt();
      in.nextLine();

      switch (choice) {
        case 1:
          System.out.print("Nombre del perro: ");
          String nombre = in.nextLine();
          System.out.print("Peso del perro: ");
          double peso = in.nextDouble();
          in.nextLine();
          System.out.print("Color del perro: ");
          String color = in.nextLine();
          hotel.registrar_perro(nombre, peso, color, in);
          break;
        case 2:
          hotel.alimentar();
          System.out.println("Los perros han sido alimentados.");
          break;
        case 3:
          hotel.patio();
          System.out.println("Los perros han sido llevados al patio.");
          break;
        case 4:
          hotel.mostrarPerros();
          break;
        case 5:
          System.out.println("Saliendo del programa.");
          break;
        default:
          System.out.println(
            "Opción inválida. Por favor, elija una opción del 1 al 5."
          );
      }
    } while (choice != 5);

    in.close();
  }
}
