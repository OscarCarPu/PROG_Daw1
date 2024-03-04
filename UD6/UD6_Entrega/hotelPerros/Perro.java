package hotelPerros;

public class Perro {
	private String nombre;
	private double peso;
	private String color;
	
	public Perro(String nombre,double peso,String color) {
		setNombre(nombre);
		setPeso(peso);
		setColor(color);
	}
	
	public void actualizarPeso(double cambio) {
		setPeso(peso+cambio);
	}

	public String getColor() {
		return color;
		
	}

	public void setColor(String color) {
		this.color = color;
		
	}

	public double getPeso() {
		return peso;
		
	}

	public void setPeso(double peso) {
		this.peso = peso;
		
	}

	public String getNombre() {
		return nombre;
		
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
		
	}
	
	public void mostrarPerro() {
		System.out.println(nombre+" pesa "+peso+" kilos y es de color: "+color);
	}
}
