package pruebas;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.nio.file.Paths;

public class Escritura {
  private static ObjectOutputStream output;

  public static void main(String[] args) {
    openFile();
    addRecords();
    closeFile();
  }

  public static void openFile() {
    try {
      output = new ObjectOutputStream(
          Files.newOutputStream(Paths.get("clients.ser")));
    } catch (IOException e) {
      System.err.println("Erro: " + e.getMessage());
      System.exit(1);
    }
  }

  public static void addRecords() {
    boolean fin = false;
    Scanner in = new Scanner(System.in);
    System.out.println("Introduzca o número de conta, primer nome, apelido e balance.");
    while (!fin) {
      try {
        Account record = new Account(in.nextInt(), in.next(), in.next(), in.nextDouble());
        output.writeObject(record);
        System.out.println("Desexa continuar? S|N");
        String sair = in.next();
        if (sair.equalsIgnoreCase("N"))
          fin = true;
      } catch (NoSuchElementException e) {
        System.err.println("Erro: " + e.getMessage());
        in.next();
      } catch (IOException e) {
        System.err.println("Erro: " + e.getMessage());
        break;
      }
    }
    in.close();
  }

  public static void closeFile() {
    try {
      if (output != null) {
        output.close();
      }
    } catch (IOException e) {
      System.err.println("Erro: " + e.getMessage());
    }
  }
}