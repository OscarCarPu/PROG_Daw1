package ejercicio2;

public class App {
  public static void main(String[] args) {
      Pasajero pasajero1 = new Pasajero("123456789", "Juan", "Pérez", 30, "Español");
      Pasajero pasajero2 = new Pasajero("987654321", "María", "López", 25, "Mexicana");

      Reserva reserva1 = new Reserva("Madrid", "Barcelona", 1, true, pasajero1);
      Reserva reserva2 = new Reserva("Barcelona", "Madrid", 2, false, pasajero2);

      Agencia agencia = new Agencia();

      agencia.insert(reserva1);
      agencia.insert(reserva2);

      System.out.println("Encontrar reserva 1: " + agencia.find(reserva1));
      System.out.println("Encontrar reserva inexistente: " + agencia.find(new Reserva())); 

      agencia.goFirst();
      System.out.println("Reserva actual: " + agencia.getCurrent());

      agencia.advance();
      System.out.println("Reserva actual tras avanzar: " + agencia.getCurrent());

      agencia.removeCurrent();
      System.out.println("Reserva actual tras eliminar la segunda reserva: " + agencia.getCurrent());

      System.out.println("Reserva anterior tras eliminar la segunda reserva: " + agencia.getPrevious());
  }
}
