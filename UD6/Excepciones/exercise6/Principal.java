package exercise6;
import exercise6.ordenador.*;
public class Principal{
    public static void main(String[] args) {
        //formato contructor Ordenador:
        //NumeroDeSerie,capacidadMemoria,tipMemoria,velocidadMemoria,capacidadDisco,tipoDisco,velocidadDisco,tipoProcesador,velocidadProcesador,precio
        try{
                new Ordenador("DELL122",8,"DDR2",533,(float)2.0,"SATA",7200,"i7",(float)3.3,400);
                System.out.println("ORDENADOR DELL122 OK");
        }catch(OrdenadorException e){
                System.out.println(e.getMessage());
        }
        try{
                new Ordenador("CLONIC900",8,"DDR2",533,(float)2.0,"SATA3",7200,"i7",(float)3.3,400);
                System.out.println("ORDENADOR CLONIC900 OK");
        }catch(OrdenadorException e){
                System.out.println(e.getMessage());
        }
        try{
                new Ordenador("HP511",2,"DDR2",533,(float)2.0,"SATA",7200,"i5",(float)3.3,400);
                System.out.println("ORDENADOR HP511 OK");
        }catch(OrdenadorException e){
                System.out.println(e.getMessage());
        }
    }
}