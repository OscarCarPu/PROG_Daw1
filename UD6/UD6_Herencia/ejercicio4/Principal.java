package ejercicio4;

import personas.*;
public class Principal {
	public static void main(String[] args) {
    Hombre carmelo=new Hombre(85,true);
    Mujer telma=new Mujer(21,false);
    System.out.println("Edad Carmelo: "+ carmelo.getEdad() +" Hizo mili Carmelo: "+ carmelo.isHizoMili());
    System.out.println("Edad Telma: "+ telma.getEdad() +" Fue madre Telma: "+ telma.isFueMadre());
}
}
