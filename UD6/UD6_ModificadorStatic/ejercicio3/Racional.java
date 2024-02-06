package ejercicio3;

public class Racional {
	int numerador;
	int denominador;
	Racional(int numerador,int denominador){
		this.numerador =numerador;
		this.denominador=denominador;
	}
	static Racional multiplicar(Racional r1,Racional r2) {
		return new Racional(r1.numerador*r2.numerador,r2.denominador*r1.denominador);
	}
}
