package pruebas;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataInputStreamInt {
    public static void main(String[] args) {
        lerInt();
    }

    // Uso de recursos e excepcións clásica sen try with resources
    public static void lerInt() {
        FileInputStream fis = null;
        DataInputStream entrada = null;
        int n;
        try {
            fis = new FileInputStream("datos.dat");
            entrada = new DataInputStream(fis);
            while (true) {
                n = entrada.readInt(); // se lee un enteiro do ficheiro
                System.out.println(n); // se mostra na pantalla
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (EOFException e) {
            System.out.println("Fin de fichero");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (entrada != null) {
                    entrada.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}