package centroCultural;


public class PrestamoDisco extends Prestamo{
	private Disco disco;
	
	PrestamoDisco(String dni,String fecha_inicio,Disco disco){
		super(dni,fecha_inicio);
		this.disco=disco;
	}
	@Override 
	public String toString() {
		return super.toString()+disco.toString();
	}
}
