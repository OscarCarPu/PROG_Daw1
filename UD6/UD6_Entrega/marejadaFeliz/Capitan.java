package marejadaFeliz;

public class Capitan extends Tripulante{
	private int horasExperiencia;
	private final int sueldo=4500000;
	private int sueldoTotal;
	private float bono;
	
	public void calcularBono() {
		if(horasExperiencia>=5000) {
			bono=(float)0.2;
		}
		if(horasExperiencia>=150000) {
			bono=(float)0.4;
		}
		if(horasExperiencia>=300000) {
			bono=(float)0.75;
		}
	}
	
	Capitan(int horasExperiencia,int numeroCarnet,int edad,int tiempoEmpresa,String nombre,String telefono,char sexo){
		super(numeroCarnet,edad,tiempoEmpresa,nombre,telefono,sexo);
		this.horasExperiencia=horasExperiencia;
	}
	public int sueldo() {
		calcularBono();
		sueldoTotal=sueldo+(int)(sueldo*bono);
		return sueldoTotal;
	}
}
