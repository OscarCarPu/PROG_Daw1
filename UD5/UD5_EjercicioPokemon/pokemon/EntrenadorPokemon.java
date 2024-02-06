package pokemon;

public class EntrenadorPokemon {
	String nombre;
	Pokemon[] equipo;
	
	public EntrenadorPokemon(String nombre) {
		this.nombre=nombre;
		equipo = new Pokemon[5];
	}
	
	public void crearEquipo() {
		for(int i=0;i<5;i++) {
			equipo[i] = new Pokemon();
		}
	}
	
	public void agregarPokemon(Pokemon p) {
		for(int i=0;i<5;i++) {
			if(equipo[i]==null) {
				equipo[i]=p;
				return;
			}
		}
		System.out.println("No hay espacios libres");
	}
	
	public void eliminarPokemon(int p) {
		if(p<1 || p>5) {
			System.out.println("Posición inexistente");
			return;
		}
		if(equipo[p-1]!=null) {
			equipo[p]=null;
		}
		else {
			System.out.println("No existe pokemon en esa posición");
		}
	}
	
	public void eliminarPokemon(String nombre) {
		for(int i=0;i<5;i++) {
			if(equipo[i]!=null && equipo[i].nombre.equalsIgnoreCase(nombre)) {
				equipo[i]=null;
			}
		}
	}
	
	public void asignarPokemonfusion() {
		
	}
	
	public void mostrarEquipo() {
		for(int i=0;i<5;i++) {
			System.out.println("En la posición "+i+" está el pokemon:");
			if(equipo[i]==null)System.out.println("vacio.");
			else equipo[i].mostrarDatos();
		}
	}
	
	
	
}
