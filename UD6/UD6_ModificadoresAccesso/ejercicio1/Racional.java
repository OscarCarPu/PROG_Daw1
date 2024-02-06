package ejercicio1;

class Racional {
	private int numerador;
	private int denominador;
	Racional(int numerador,int denominador){
		this.numerador=numerador;
		this.denominador=denominador;
	}
	static Racional multiplicar(Racional r1,Racional r2) {
		Racional resultado = new Racional(1,1);
		resultado.numerador=r1.numerador*r2.numerador;
		resultado.denominador=r1.denominador*r2.denominador;
		return resultado;
	}
	public int getDenominador() {
		return denominador;
	}
	
	public int getNumerador() {
		return numerador;
	}
}

class Test{
	public static void main(String[] args) {
		Racional r1=new Racional(3,4);
		Racional r2=new Racional(1,2);
		Racional r3=new Racional(1,1);
		r3=Racional.multiplicar(r1, r2);
		System.out.println("MULTIPLICACIÓN DE NÚMEROS RACIONALES");
		System.out.println("r1 vale: "+r1.getNumerador()+"/"+r1.getDenominador());
		System.out.println("r2 vale: "+r2.getNumerador()+"/"+r2.getDenominador());
		System.out.println("r3 vale: "+r3.getNumerador()+"/"+r3.getDenominador());
	}
}
