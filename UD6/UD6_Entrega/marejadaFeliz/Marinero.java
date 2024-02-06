package marejadaFeliz;

public class Marinero extends Tripulante{
	private int totalPescado;
	private final int sueldo=90000;
	private int sueldoTotal;
	private float bono;
	
	public void calcularBono() {
		bono=(float)((totalPescado>=1?1:0)*0.25);
	}
	
	public int sueldo() {
		sueldoTotal=sueldo+(int)(sueldo*bono);
		return sueldoTotal;
	}
	
	Marinero(int totalPescado,int numeroCarnet,int edad,int tiempoEmpresa,String nombre,String telefono,char sexo){
		super(numeroCarnet,edad,tiempoEmpresa,nombre,telefono,sexo);
		this.totalPescado=totalPescado;
	}
}
