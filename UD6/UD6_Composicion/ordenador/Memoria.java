package ordenador;

class Memoria {
	private int capacidad;
	private String tipo;
	private int velocidad;
	Memoria(int capacidad,String tipo,int velocidad) {
		capacidad=Math.max(2, capacidad);
		this.capacidad=capacidad;
		this.tipo=tipo;
		this.velocidad=velocidad;
	}
	int getCapacidad() {
		return capacidad;
	}
	
}
