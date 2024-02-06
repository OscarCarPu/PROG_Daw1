package personas;

public class Persona {
	private int edad;
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		edad=Math.min(edad, 65);
		this.edad=edad;
	}
	
	public Persona(int edad) {
		setEdad(edad);
	}
}
