package personas;

public class Hombre extends Persona{
	private boolean hizoMili;

	public boolean isHizoMili() {
		return hizoMili;
		
	}

	public void setHizoMili(boolean hizoMili) {
		this.hizoMili = hizoMili;
		
	}
	
	public Hombre(int edad, boolean hizoMili) {
		super(edad);
		setHizoMili(hizoMili);
	}
}
