package personas;

public class Mujer extends Persona{
	private boolean fueMadre;

	public boolean isFueMadre() {
		return fueMadre;
		
	}

	public void setFueMadre(boolean fueMadre) {
		this.fueMadre = fueMadre;
		
	}
	
	public Mujer(int edad,boolean fueMadre) {
		super(edad);
		setFueMadre(fueMadre);
	}
}
