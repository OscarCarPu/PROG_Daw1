package ejercicio2;

public class aparato {
	static int consumo_total=0;
	private int consumo;
	public aparato(int consumo) {
		this.consumo=consumo;
	}
	
	public void encender() {
		consumo_total+=consumo;
	}
	
	public void apagar() {
		consumo_total-=consumo;
	}


}
