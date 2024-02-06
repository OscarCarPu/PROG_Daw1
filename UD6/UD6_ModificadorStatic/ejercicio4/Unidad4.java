package ejercicio4;


class Unidad4{
	static int pot(int base,int exponente) {
		int resultado=1;
		for(;exponente>0;exponente--) {
			resultado*=base;
		}
		return resultado;
	}
	public static void main(String[] args) {
		System.out.println(Unidad4.pot(2,1));
		System.out.println(pot(5,3));
		System.out.println(new Unidad4().pot(9,0));
	}
}
