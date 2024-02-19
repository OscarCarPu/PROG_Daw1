package ejercicio2;

public class Reserva {
  private String origen;
  private String destino;
  private int plaza;
  private boolean businnes;
  private Pasajero pasajero;

  public Reserva() {
  }

  public Reserva(String origen, String destino, int plaza, boolean businnes, Pasajero pasajero) {
      this.origen = origen;
      this.destino = destino;
      this.plaza = plaza;
      this.businnes = businnes;
      this.pasajero = pasajero;
  }

  public String getOrigen() {
      return origen;
  }

  public String toString() {
    String clase = businnes ? "Business" : "Economy";
    return "Reserva{" +
            "origen='" + origen + '\'' +
            ", destino='" + destino + '\'' +
            ", plaza=" + plaza +
            ", clase='" + clase + '\'' +
            ", pasajero=" + pasajero +
            '}';
}

  public void setOrigen(String origen) {
      this.origen = origen;
  }

  public String getDestino() {
      return destino;
  }

  public void setDestino(String destino) {
      this.destino = destino;
  }

  public int getPlaza() {
      return plaza;
  }

  public void setPlaza(int plaza) {
      this.plaza = plaza;
  }

  public boolean isBusinnes() {
      return businnes;
  }

  public void setBusinnes(boolean businnes) {
      this.businnes = businnes;
  }

  public Pasajero getPasajero() {
      return pasajero;
  }

  public void setPasajero(Pasajero pasajero) {
      this.pasajero = pasajero;
  }
}