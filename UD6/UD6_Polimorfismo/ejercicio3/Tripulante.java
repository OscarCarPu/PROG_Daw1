package ejercicio3;

public abstract class Tripulante {
	private int numeroCarnet;
	private GPS posicionGps;
	private int edad;
	private int tiempoEmpresa;
	private String nombre;
	private String telefono;
	private char sexo;
	private Barco barco;
	
	Tripulante(int numeroCarnet,int edad,int tiempoEmpresa,String nombre,String telefono,char sexo){
		this.numeroCarnet=numeroCarnet;
		this.edad=edad;
		this.tiempoEmpresa=tiempoEmpresa;
		this.nombre=nombre;
		this.telefono=telefono;
		this.sexo=sexo;
		this.posicionGps=new GPS();
		this.barco = new Barco();
	}
	
	public abstract int sueldo();
	
	public String toString() {
		return "El tripulante tiene numero de carnet: "+numeroCarnet+
				" posicion gps: "+posicionGps+
				" edad: "+edad+
				" tiempo en empresa: "+tiempoEmpresa+
				" nombre: "+nombre+
				" telefono: "+telefono+
				" sexo: "+sexo+
				" barco: "+barco.toString()+
				" sueldo: "+sueldo();
	}
}
