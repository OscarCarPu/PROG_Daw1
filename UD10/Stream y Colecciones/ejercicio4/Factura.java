package ejercicio4;

public class Factura {
  private int numero;
  private String concepto;
  private double importe;

  public Factura(int numero, String concepto, double importe) {
    this.numero = numero;
    this.concepto = concepto;
    this.importe = importe;
  }

  public int getNumero() {
    return numero;
  }

  public String getConcepto() {
    return concepto;
  }

  public double getImporte() {
    return importe;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public void setConcepto(String concepto) {
    this.concepto = concepto;
  }

  public void setImporte(double importe) {
    this.importe = importe;
  }

  @Override
  public String toString() {
    return "Factura: " + numero + ", " + concepto + ", " + importe+"€";

  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Factura other = (Factura) obj;
    if (numero != other.numero) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    final int result = Integer.hashCode(numero);
    return 31 * result + concepto.hashCode();
  }
}