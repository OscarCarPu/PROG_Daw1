package ejercicio1;

import java.io.*;
import java.nio.*;

public class App{
  public static void main(String[] args){
    File file = new File(".\\ejercicio1\\ficheiro");
    File dir = new File(".\\ejercicio1\\carpeta");
    if(file.isDirectory()){
      System.out.println("ficheiro és un directorio");
    }
    else{
      System.out.println("ficheiro és un archivo");
    }
    if(file.canWrite()){
      System.out.println("se puede escribir en ficheiro");
    }
    else{
      System.out.println("no se puede escribir en fichero");
    }
    if(dir.isDirectory()){
      System.out.println("carpeta és un directorio");
    }
    else{
      System.out.println("carpeta és un archivo");
    }
    if(dir.canWrite()){
      System.out.println("se puede escribir en fcarpeta");
    }
    else{
      System.out.println("no se puede escribir en carpeta");
    }
  }
}