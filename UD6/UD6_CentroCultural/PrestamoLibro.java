

public class PrestamoLibro extends Prestamo{
	private Libro libro;
	
	PrestamoLibro(String dni,String fecha_inicio,Libro libro){
		super(dni,fecha_inicio);
		this.libro=libro;
	}
	@Override 
	public String toString() {
		return super.toString()+libro.toString();
	}
}
