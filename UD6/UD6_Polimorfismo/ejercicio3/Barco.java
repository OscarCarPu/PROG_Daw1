package ejercicio3;

public class Barco {
	private String nombre;
	private String tipo;
	private int capacidadDePasajero;
	private int carga;
	
	public String toString() {
		return "El barco "+nombre+" de tipo: "+tipo+" tiene capacidad para "+capacidadDePasajero+" pasajeros y "+carga+" para carga";
	}
}
