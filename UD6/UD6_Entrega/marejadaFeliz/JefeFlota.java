package marejadaFeliz;

public class JefeFlota extends Tripulante{
	private int pesoPescado;
	private int pesoMarisco;
	private final int sueldo=350000000;
	private int sueldoTotal;
	private float bonoPescado;
	private float bonoMarisco;
	
	public void calcularBono() {
		bonoPescado=(float)(pesoPescado*0.01);
		bonoMarisco=(float)(pesoMarisco*0.02);
	}
	
	public int sueldo() {
		calcularBono();
		sueldoTotal=sueldo+(int)(sueldo*bonoPescado)+(int)(sueldo*bonoMarisco);
		return sueldoTotal;
	}
	
	JefeFlota(int pesoPescado,int pesoMarisco,int numeroCarnet,int edad,int tiempoEmpresa,String nombre,String telefono,char sexo){
		super(numeroCarnet,edad,tiempoEmpresa,nombre,telefono,sexo);
		this.pesoMarisco=pesoMarisco;
		this.pesoPescado=pesoPescado;
	}
}
