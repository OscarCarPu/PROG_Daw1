package ejercicio1;

class Ordenador{
	private String procesador;
	private int memoria;
	Ordenador(String procesador,int memoria){
		this.procesador=procesador;
		this.memoria=memoria;
	}
}

class Sobremesa extends Ordenador{
	private String tipo_caja;
	Sobremesa(String procesador,int memoria,String tipo_caja){
		super(procesador,memoria);
		this.tipo_caja=tipo_caja;
	}
}

class Portatil extends Ordenador{
	private double peso;
	Portatil(String procesador,int memoria,double peso){
		super(procesador,memoria);
		this.peso=peso;
	}
}

public class Ejercicio1 {
	public static void main(String[] args) {
		new Sobremesa("pro",12,"micro-atx");
		new Portatil("pro",12,1.5);
	}
}
