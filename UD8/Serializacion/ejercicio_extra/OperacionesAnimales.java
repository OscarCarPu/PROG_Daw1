package ejercicio_extra;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class OperacionesAnimales {
  static Gato[] gatos = new Gato[5];
  static Perro[] perros = new Perro[5];
  static int contPerros=0,contGatos=0;
  public boolean addPerro(Perro perro){
    if(contPerros==5)return false;
    perros[contPerros++] = perro;
    return true;
  }

  public boolean addGato(Gato gato){
    if(contGatos==5)return false;
    gatos[contGatos++] = gato;
    return true;
  }

  public void gardarAnimaisADisco(String fichero){
    try{
      ObjectOutputStream output = new ObjectOutputStream(Files.newOutputStream(Paths.get(fichero)));
      output.writeInt(contGatos);
      for(int i=0;i<contGatos;i++){
        output.writeObject(gatos[i]);
      }
      output.writeInt(contPerros);
      for(int i=0;i<contPerros;i++){
        output.writeObject(perros[i]);
      }
      output.close();
    } catch(Exception e){
      System.err.println("Erro: "+e.getMessage());
    }
  }

  public void lerAnimaisDisco(String fichero){
    try{
      ObjectInputStream input = new ObjectInputStream(Files.newInputStream(Paths.get(fichero)));
      int cG = input.readInt();
      Gato [] aGatos = new Gato[cG];
      for(int i=0;i<cG;i++){
        Gato g = (Gato) input.readObject();
        aGatos[i] = g;
      }
      int cP = input.readInt();
      Perro [] aPerros = new Perro[cP];
      for(int i=0;i<cP;i++){
        Perro p = (Perro) input.readObject();
        aPerros[i] = p;
      }
      perros = aPerros;
      gatos = aGatos;
    } catch(Exception e){
      System.err.println("Erro: "+e.getMessage());
    }
  }
}
