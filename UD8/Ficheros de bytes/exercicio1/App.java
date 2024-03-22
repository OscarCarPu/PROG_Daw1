package exercicio1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class App {
    public static void main(String[] args) {
        try{
            FileInputStream file = new FileInputStream("proba.txt");
            DataInputStream data = new DataInputStream(file);
            FileOutputStream fileOut = new FileOutputStream("probaCopia.txt");
            DataOutputStream dataOut = new DataOutputStream(fileOut);
            while(data.available() > 0){
                dataOut.write(data.read());
            }
            data.close();
            dataOut.close();
        } catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
