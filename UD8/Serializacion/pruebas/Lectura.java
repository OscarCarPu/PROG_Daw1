package pruebas;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

//Clase para deserializar e ler obxectos clase Account do ficheiro
public class Lectura {
  private static ObjectInputStream input;

  public static void main(String[] args) {
    openFile();
    readRecords();
    closeFile();
  }

  // abrir ficheiro
  public static void openFile() {
    try {
      input = new ObjectInputStream(
          Files.newInputStream(Paths.get("clients.ser")));
    } catch (IOException ioException) {
      System.err.println("Erro abrindo ficheiro.");
      System.exit(1);
    }
  }

  // método de ler obxectos
  public static void readRecords() {
    System.out.printf("%-10s%-12s%-12s%10s%n", "Conta",
        "Primer nome", "Apelidos", "Balance");
    try {
      while (true) // bucle ata EOFException
      {
        // lectura e cast
        Account record = (Account) input.readObject();
        // mostramos os datos
        System.out.printf("%-10d%-12s%-12s%10.2f%n",
            record.getAccount(), record.getFirstName(),
            record.getLastName(), record.getBalance());
      }
    } catch (EOFException endOfFileException) {
      System.out.printf("%nNon hai mais datos.%n");
    }
    // Excepcion que xorde cando nos chega un obxecto que non esperamos
    catch (ClassNotFoundException classNotFoundException) {
      System.err.println("Tipo de obxecto inválido.");
    } catch (IOException ioException) {
      System.err.println("Erro lendo o ficheiro.");
    }
  }

  // método de peche
  public static void closeFile() {
    try {
      if (input != null)
        input.close();
    } catch (IOException ioException) {
      System.err.println("Error closing file. Terminating.");
      System.exit(1);
    }
  }
}