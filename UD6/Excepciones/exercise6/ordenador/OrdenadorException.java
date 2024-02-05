package exercise6.ordenador;

public class OrdenadorException extends Exception {
  private String numeroDeSerie;

  public OrdenadorException(String numeroDeSerie, String message) {
    super(message);
    this.numeroDeSerie = numeroDeSerie;
  }

  @Override
  public String getMessage() {
    return "Error with number series " + numeroDeSerie + ": " + super.getMessage();
  }
}