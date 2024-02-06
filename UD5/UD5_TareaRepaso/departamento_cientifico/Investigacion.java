package departamento_cientifico;

public class Investigacion {

	private int identificador;
	private String nombre;
	private double calculos;
	double PI=Math.PI;
	public Investigacion(int identificador,String nombre,double calculos) {
		this.identificador=identificador;
		this.nombre=nombre;
		this.calculos=calculos;
	}
	public int getIdentificador() {
		return identificador;
		
	}
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
		
	}
	public String getNombre() {
		return nombre;
		
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
		
	}
	public double getCalculos() {
		return calculos;
		
	}
	public void setCalculos(double calculos) {
		this.calculos = calculos;
		
	}
	
	public void imprimir() {
		System.out.println("Información investigación:");
		System.out.println("Identificador: "+identificador);
		System.out.println("Nombre: "+nombre);
		System.out.println("Calculos: "+calculos);
	}
}
