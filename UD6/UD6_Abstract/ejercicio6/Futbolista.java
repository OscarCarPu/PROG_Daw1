package ejercicio6;

public class Futbolista extends IntegranteEquipo implements IntegranteCampo{
	private String dorsal;
	private Demarcacion demarcacion;
	
	Futbolista(int id,String nombre,int edad,String dorsal,Demarcacion demarcacion){
		super(id,nombre,edad);
		this.dorsal=dorsal;
		this.demarcacion=demarcacion;
	}
	public void jugar() {
		
	}
	
	public void entrenar() {
		
	}
}
