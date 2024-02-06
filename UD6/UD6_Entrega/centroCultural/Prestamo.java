package centroCultural;


public class Prestamo {
	private String dni;
	private String fecha_inicio;
	private String fecha_fin;
	
	Prestamo(String dni,String fecha_inicio){
		this.dni=dni;
		this.fecha_inicio=fecha_inicio;
	}
	
	public String getDni() {
		return dni;
	}
	@Override 
	public String toString() {
		return "Prestamo de cliente "+dni+" con inicio en "+fecha_inicio+" y fin en "+fecha_fin+"\n";
	}
}
