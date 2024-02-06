package pokemon;

import java.util.Random;

public class Pokemon {
	String nombre;
	String tipo;
	int vida;
	int VIDA_MAXIMA=100;
	int nivel=1;
	Pokemon pokemonFusion;
	
	public void sanarTotalmente() {
		vida=VIDA_MAXIMA;
	}
	
	public void tomarPocion(int vida) {
		this.vida+=vida;
	}
	
	public void tomarPocion(float porcentaje) {
		this.vida=(int) Math.min(this.vida+VIDA_MAXIMA*(porcentaje/100), VIDA_MAXIMA);
	}
	
	public void reducirVida(int cantidad) {
		vida-=cantidad;
	}
	
	public void mostrarDatos() {
		System.out.println("El pokemon "+nombre+" es de tipo "+tipo+" tiene "+vida+" puntos de vida, con una vida maxima de "+VIDA_MAXIMA+" y un nivel "+nivel);
	}
	
	public void asignarPokemonfusino(Pokemon p2) {
	}
	
	public Pokemon() {
		Random ra = new Random();
		int r=ra.nextInt(0,10);
		if(r>=0 && r<=2) {
			nombre="Squirtle";
			tipo="Agua";
		}
		if(r>=3 && r<=5) {
			nombre="Charmander";
			tipo="Fuego";
		}
		if(r>=6 && r<=8) {
			nombre="Bulbasaur";
			tipo="Planta";
		}
		if(r==9) {
			nombre="Pikachu";
			tipo="Electricidad";
		}
	}
}
