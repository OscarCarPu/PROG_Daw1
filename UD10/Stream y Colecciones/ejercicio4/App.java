package ejercicio4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {
  public static void main(String[] args) {

    List<Factura> facturas = Arrays.asList(
        new Factura(1, "Factura 1", 100.0),
        new Factura(2, "Factura 2", 200.0),
        new Factura(3, "Factura 3", 300.0),
        new Factura(4, "Factura 4", 400.0),
        new Factura(5, "Factura 5", 234.3),
        new Factura(6, "Factura 6", 123.4),
        new Factura(7, "Factura 7", 234.5),
        new Factura(8, "Factura 8", 345.6),
        new Factura(9, "Factura 9", 456.7),
        new Factura(10, "Factura 10", 127.8),
        new Factura(11, "Factura 11", 234.9),
        new Factura(12, "Factura 12", 345.0),
        new Factura(13, "Factura 13", 156.1),
        new Factura(14, "Factura 14", 267.2),
        new Factura(15, "Factura 15", 378.3));

    List<Factura> facturasMayores200 = facturas.stream()
        .filter(f -> f.getImporte() > 200)
        .collect(Collectors.toList());

    facturasMayores200.forEach(f -> System.out.println(f.getConcepto()));

    List<Factura> facturasEntre200Y300 = facturas.stream()
        .filter(f -> f.getImporte() >= 200 && f.getImporte() <= 300)
        .collect(Collectors.toList());

    facturasEntre200Y300.forEach(f -> System.out.println(f.getConcepto()));
  }
}
