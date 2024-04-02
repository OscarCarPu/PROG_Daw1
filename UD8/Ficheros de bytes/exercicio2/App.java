package exercicio2;

import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

public class App {
  public static void main(String[] args) {
    double[][] array;
    Scanner in = new Scanner(System.in);
    System.out.println("Introduce o número de filas: ");
    int filas = in.nextInt();
    System.out.println("Introduce o número de columnas: ");
    int columnas = in.nextInt();
    array = new double[filas][columnas];
    for(int i=0;i<filas;i++){
      for(int j=0;j<columnas;j++){
        System.out.println("Introduce o valor da fila "+(i+1)+" e columna "+(j+1)+": ");
        array[i][j] = in.nextDouble();
      }
    }
    String salida = "Columnas: " + columnas + "\nFilas: " + filas + "\n"+ "Array: \n";
    for(int i=0;i<filas;i++){
      for(int j=0;j<columnas;j++){
        salida += array[i][j] + " ";
      }
      salida += "\n";
    }
    try{
      Path path = Paths.get("arrayUsuario.txt");
      Files.write(path,salida.getBytes());
    } catch (Exception e){
      System.out.println("Erro: " + e.getMessage());
    }
    in.close();
  }
}
