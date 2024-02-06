package ejercicio3;

public class Agenda {

	private Contacto [] agenda;
	
	public Agenda() {
		agenda = new Contacto[20];
		for(int i=0;i<20;i++)agenda[i]=new Contacto();
	}
	
	public void mostrar() {
		for(Contacto i : agenda) {
			
			System.out.println(i.getNombre()+" "+i.getEmail()+" "+i.getTelefono());
		}
	}
	
	public void actualizar(String emailBef,String nombre,String email,int telefono) {
		int cnt=0;
		for(int i=0;i<email.length();i++) {
			if(email.charAt(i)=='@')cnt++;
		}
		if(cnt!=1) {
			System.out.println("El email no es válido");
			return;
		}
		for(Contacto i : agenda) {
			if(i.getEmail().contentEquals(email))continue;
			i=new Contacto(nombre,email,telefono);
		}
	}
	
	public void actualizarIdx(int x,String nombre,String email,int telefono) {
		int cnt=0;
		for(int i=0;i<email.length();i++) {
			if(email.charAt(i)=='@')cnt++;
		}
		if(cnt!=1) {
			System.out.println("El email no es válido");
			return;
		}
		agenda[x]=new Contacto(nombre,email,telefono);
		System.out.println("Nuevo valor");
	}
}
