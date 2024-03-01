package ejercicio4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class App{

  public static void main(String[] args) throws IOException{
    Path path = Paths.get(args[0]);
    System.out.println("Directorio padre: "+path.getParent());
    System.out.println("Número elementos: "+path.getNameCount());
    System.out.println("Nombre archivo: "+path.getFileName());

    Path cop = Paths.get("L:\\Varios\\aaux");
    copyFolder(path,cop);
    
  }

  public static void copyFolder(Path src,Path dest) throws IOException {
    try (Stream<Path> stream = Files.walk(src)){
      stream.forEach(sour -> {
        try{
          Files.copy(src,dest.resolve(src.relativize(src)));
        }catch(IOException e){
          
        }
      });
    }
  }
}