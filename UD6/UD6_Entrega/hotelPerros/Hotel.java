package hotelPerros;

import java.util.Scanner;

public class Hotel {
	static int perros_registrados=0;
	private Perro[] inquilinos;
	
	public Hotel(){
		inquilinos=new Perro[10];
	}
	public void registrar_perro(String nombre,double peso,String color,Scanner in) {
		if(perros_registrados==10) {
			System.out.println("El hotel esta lleno");
			return;
		}
		System.out.println("Quieres que se alimente al perro dependiendo de su peso (si/no)?");
		String a=in.nextLine();
		if(a.equals("si")) {
			inquilinos[perros_registrados++] = new PerroEspecial(nombre,peso,color);
		}
		else inquilinos[perros_registrados++] = new Perro(nombre,peso,color);
	}
	
	public void alimentar() {
		for(int i=0;i<perros_registrados;i++) {
			inquilinos[i].actualizarPeso(.5);
		}
	}
	
	public void patio() {
		for(int i=0;i<perros_registrados;i++) {
			inquilinos[i].actualizarPeso(-.5);
		}
	}
	
	
	public void mostrarPerros() {
		for(int i=0;i<perros_registrados;i++) {
			System.out.println("Perro nº"+(i+1));
			inquilinos[i].mostrarPerro();
		}
	}
}
