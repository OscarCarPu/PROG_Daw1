package parking_repaso;

public class ParkingException extends Exception {

  public ParkingException() {
    super("El parking esta lleno");
  }
}
