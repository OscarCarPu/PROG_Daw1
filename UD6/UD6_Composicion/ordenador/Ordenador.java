package ordenador;

public class Ordenador {
	private Procesador procesador;
	private Memoria memoria;
	private DiscoDuro discoduro;
	private int pvp;
	static int cont=0;
	
	public Ordenador(int capacidadMemoria,String tipoMemoria,int velocidadMemoria,float capacidadDisco,String tipoDisco,int velocidadDisco,String tipoProcesador,float velocidadProcesador,int precio) {
		memoria = new Memoria(capacidadMemoria,tipoMemoria,velocidadMemoria);
		discoduro = new DiscoDuro(capacidadDisco,tipoDisco,velocidadDisco);
		procesador = new Procesador(tipoProcesador,velocidadProcesador);
		pvp=precio;
		cont++;
	}
	
	public int getCapacidadMemoria() {
		return this.memoria.getCapacidad();
	}
}
