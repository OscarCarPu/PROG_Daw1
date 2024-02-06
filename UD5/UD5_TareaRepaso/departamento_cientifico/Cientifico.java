package departamento_cientifico;

public class Cientifico {

	private String nombre;
	private String apellidos;
	private String experiencia;
	private int anos_trabajados;
	private Investigacion investigacion;
	public Cientifico() {
		nombre="";
		apellidos="";
		experiencia="";
		anos_trabajados=0;
		investigacion=null;
	}
	public Cientifico(String nombre,String apellidos,String experiencia,int anos_trabajados,Investigacion investigacion) {
		setNombre(nombre);
		setApellidos(apellidos);
		setExperiencia(experiencia);
		setAnos_trabajados(anos_trabajados);
		setInvestigacion(investigacion);
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getExperiencia() {
		return experiencia;
	}
	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}
	public int getAnos_trabajados() {
		return anos_trabajados;
	}
	public void setAnos_trabajados(int anos_trabajados) {
		this.anos_trabajados = anos_trabajados;
	}
	public Investigacion getInvestigacion() {
		return investigacion;
	}
	public void setInvestigacion(Investigacion investigacion) {
		this.investigacion = investigacion;
	}
	public void imprimir() {
		System.out.println("Informacion cientifico: ");
		System.out.println("Nombre: "+nombre);
		System.out.println("Apellidos: "+apellidos);
		System.out.println("Experiencia: "+experiencia);
		System.out.println("Años trabajados: "+anos_trabajados);
		System.out.println("Investigación: ");
		investigacion.imprimir();
	}
}
