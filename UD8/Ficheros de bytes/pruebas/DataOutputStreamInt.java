package pruebas;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class DataOutputStreamInt {
    public static void main(String[] args) {
        escribirInt();
    }

    // Uso de recursos e excepcións clásica sen try with resources
    private static void escribirInt() {

        Scanner sc = new Scanner(System.in);
        FileOutputStream fos = null;
        DataOutputStream salida = null;
        int n;
        try {
            fos = new FileOutputStream("datos.dat");
            salida = new DataOutputStream(fos);
            System.out.print("Introduce número enteiro. -1 para rematar: ");
            n = sc.nextInt();
            while (n != -1) {
                salida.writeInt(n); // se escribe o número enteiro no ficheiro
                System.out.print("Introduce número enteiro. -1 para rematar: ");
                n = sc.nextInt();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                if (salida != null) {
                    salida.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        sc.close();
    }
}