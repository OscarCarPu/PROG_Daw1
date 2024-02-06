package ejercicio2;

public class Deposito {
	private String nombre;
	private int largo;
	private int ancho;
	private int alto;
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Deposito))return false;
		Deposito d = (Deposito)o;
		return largo*ancho*alto==d.largo*d.ancho*d.alto && nombre==d.nombre;
	}
}
