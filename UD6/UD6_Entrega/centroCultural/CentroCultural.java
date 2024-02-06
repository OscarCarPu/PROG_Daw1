package centroCultural;
import java.time.LocalDate;
import java.util.Scanner;



public class CentroCultural {
	private final int MAX_CLIENTES=5;
	private final int MAX_LIBROS=15;
	private final int MAX_DISCOS=15;
	private final int MAX_PRESTAMOS_DISCOS=3;
	private final int MAX_PRESTAMOS_LIBROS=3;
	private int contLibros;
	private int contDiscos;
	private int prestamosLibros;
	private int prestamosDiscos;
	private Cliente[] clientes;
	private Prestamo[] prestamos;
	private Material[] materiales;	
	public CentroCultural() {
		clientes = new Cliente[MAX_CLIENTES];
		materiales = new Material[MAX_DISCOS+MAX_LIBROS];
		prestamos = new Prestamo[MAX_PRESTAMOS_DISCOS+MAX_PRESTAMOS_LIBROS];
		contLibros=contDiscos=prestamosLibros=prestamosDiscos=0;
	}
	
	public void altaCliente(Scanner in) {
		int idx=-1;
		for(int i=0;i<MAX_CLIENTES;i++) {
			if(clientes[i]==null) {
				idx=i;
			}
		}
		if(idx==-1) {
			System.out.println("No hay capacidad para mas clientes.");
			return;
		}
		System.out.println("Introduce el dni:");
		String dni=in.next();
		System.out.println("Introduce el nombre:");
		String nombre=in.next();
		clientes[idx]=new Cliente(dni,nombre);
	}
	
	public void altaMaterial(Scanner in) {
		System.out.println("Que tipo quieres dar de alta(libro/disco):");
		String tipo = in.next();
		if(tipo.equals("libro")) {
			if(contLibros>=MAX_LIBROS) {
				System.out.println("No hay capacidad para más libros");
				return;
			}
			System.out.println("Introduce el identificador:");
			int id=in.nextInt();
			in.nextLine();
			System.out.println("Introduce el tituo:");
			String titulo=in.nextLine();
			System.out.println("Introduce la estanteria:");
			int estanteria=in.nextInt();
			System.out.println("Introduce la altura:");
			int altura=in.nextInt();
			in.nextLine();
			System.out.println("Introduce el autor:");
			String autor=in.nextLine();
			System.out.println("Introduce el numero de paginas:");
			int num_paginas=in.nextInt();
			in.nextLine();
			materiales[contLibros++]= new Libro(id,titulo,estanteria,altura,autor,num_paginas);
		}
		else {
			if(contDiscos>=MAX_DISCOS) {
				System.out.println("No hay capacidad para más discos");
				return;
			}
			System.out.println("Introduce el identificador:");
			int id=in.nextInt();
			in.nextLine();
			System.out.println("Introduce el tituo:");
			String titulo=in.nextLine();
			System.out.println("Introduce la estanteria:");
			int estanteria=in.nextInt();
			System.out.println("Introduce la altura:");
			int altura=in.nextInt();
			in.nextLine();
			System.out.println("Introduce el autor:");
			String autor=in.nextLine();
			System.out.println("Introduce la discográfica:");
			String discografica=in.nextLine();
			materiales[MAX_LIBROS+contDiscos++]= new Disco(id,titulo,estanteria,altura,autor,discografica);
		}
	}

	public void prestamo(Scanner in) {
		System.out.println("Que quieres prestar (disco/libro):");
		String tipo=in.next();
		if((tipo.equals("libro") && prestamosLibros>=MAX_PRESTAMOS_LIBROS) || (tipo.equals("disco") && prestamosDiscos>=MAX_PRESTAMOS_DISCOS)) {
			System.out.println("No se pueden prestar más materiales de ese tipo");
			return;
		}
		System.out.println("Introduce el dni del usuario:");
		String dni=in.next();
		boolean is=false;
		for(int i=0;i<MAX_CLIENTES;i++) {
			if(clientes[i]!=null)is =is || clientes[i].getDni().equals(dni);
		}
		if(!is) {
			System.out.println("No existe tal cliente");
			return;
		}
		System.out.println("Introduce el identificador dle material:");
		int id = in.nextInt();
		is=false;
		Material pres = null;
		for(int i=0;i<MAX_DISCOS+MAX_LIBROS;i++) {
			if(materiales[i]!=null && materiales[i].getId()==id) {
				pres=materiales[i];
			}
		}
		if(pres == null) {
			System.out.println("No existe tal material");
			return;
		}
		String fecha_inicio=LocalDate.now().toString();
		if(tipo.equals("disco")) {
			prestamos[MAX_PRESTAMOS_LIBROS+prestamosDiscos++] = new PrestamoDisco(dni,fecha_inicio,(Disco) pres);
		}
		else {
			prestamos[prestamosLibros++] = new PrestamoLibro(dni,fecha_inicio,(Libro) pres);
		}
		System.out.println("Prestamo realizado");
		
	}

	public void listarPrestamos(Scanner in) {
		System.out.println("Introduce el dni: ");
		String dni=in.next();
		boolean is=false;
		for(int i=0;i<MAX_CLIENTES;i++) {
			if(clientes[i]!=null) is = is || clientes[i].getDni().equals(dni);
		}
		if(!is) {
			System.out.println("No existe ese cliente");
			return;
		}
		for(int i=0;i<MAX_PRESTAMOS_DISCOS+MAX_PRESTAMOS_LIBROS;i++) {
			if(prestamos[i]!=null && prestamos[i].getDni().equals(dni)) {
				System.out.println(prestamos[i].toString());
			}
		}
	}

	public void compararLibros(Scanner in) {
		System.out.println("Introduce el id del primer libro:");
		int id1=in.nextInt();
		int idx1=-1;
		for(int i=0;i<MAX_LIBROS;i++) {
			if(materiales[i]!=null && materiales[i].getId()==id1)idx1=i;
		}
		if(idx1==-1) {
			System.out.println("No existe tal libro");
			return;
		}
		System.out.println("Introduce el id del segundo libro:");
		int id2=in.nextInt();
		int idx2=-1;
		for(int i=0;i<MAX_LIBROS;i++) {
			if(materiales[i]!=null && materiales[i].getId()==id2)idx2=i;
		}
		if(idx2==-1) {
			System.out.println("No existe tal libro");
			return;
		}
		
		if(materiales[idx1].equals(materiales[idx2])) {
			System.out.println("Los libros son iguales");
		}
		else {
			System.out.println("Los libros son diferentes");
		}
	}

	public void dondeColocar(Scanner in) {
		System.out.println("Introduce el id del material:");
		int id=in.nextInt();
		Material mat=null;
		for(int i=0;i<MAX_DISCOS+MAX_LIBROS;i++) {
			if(materiales[i]!=null && materiales[i].getId()==id)mat=materiales[i];
		}
		if(mat==null) {
			System.out.println("No existe tal material");
			return;
		}
		System.out.println(mat.dondeColocar());
	}
}
