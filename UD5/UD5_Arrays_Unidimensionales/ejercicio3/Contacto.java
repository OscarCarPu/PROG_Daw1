package ejercicio3;

public class Contacto {
	private String nombre;
	private String email;
	private int telefono;
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public void setEmail(String email) {
		int cnt=0;
		for(int i=0;i<email.length();i++) {
			if(email.charAt(i)=='@')cnt++;
		}
		if(cnt!=1)return;
		this.email=email;
	}
	
	public void setTelefono(int telefono) {
		this.telefono=telefono;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getEmail() {
		return email;
	}
	
	public int getTelefono() {
		return telefono;
	}
	
	public Contacto(String nombre,String email,int telefono) {
		setNombre(nombre);
		setEmail(email);
		setTelefono(telefono);
	}
	
	public Contacto() {
		setNombre("");
		setEmail("");
		setTelefono(0);
	}
}
