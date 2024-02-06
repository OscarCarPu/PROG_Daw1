package ejercicio2;

class Persona{
	private String dni;
	private String nombre;
	private String direccion;
}

class Empleados extends Persona{
	private int sueldo;
}

class Clientes extends Persona{
	private int deuda;
}

public class Ejercicio2 {
	public static void main(String[] args) {
		Persona p = new Persona();
		Empleados e = new Empleados();
		Clientes c = new Clientes();
		
	}
}
