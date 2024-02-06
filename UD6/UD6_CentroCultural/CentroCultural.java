import java.time.LocalDate;
import java.util.Scanner;



public class CentroCultural {
	private final int MAX_CLIENTES=5;
	private final int MAX_LIBROS=15;
	private final int MAX_DISCOS=15;
	private final int MAX_PRESTAMOS_DISCOS=3;
	private final int MAX_PRESTAMOS_LIBROS=3;
	private Cliente[] clientes;
	private Libro[] libros;
	private Disco[] discos;
	private PrestamoDisco[] prestamosDiscos;
	private PrestamoLibro[] prestamosLibros;
	
	public CentroCultural() {
		clientes = new Cliente[MAX_CLIENTES];
		libros = new Libro[MAX_LIBROS];
		discos = new Disco[MAX_DISCOS];
		prestamosDiscos = new PrestamoDisco[MAX_PRESTAMOS_DISCOS];
		prestamosLibros = new PrestamoLibro[MAX_PRESTAMOS_LIBROS];
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
			int idx=-1;
			for(int i=0;i<MAX_LIBROS;i++) {
				if(libros[i]==null) {
					idx=i;
				}
			}
			if(idx==-1) {
				System.out.println("No hay capacidad para mas libros");
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
			libros[idx]= new Libro(id,titulo,estanteria,altura,autor,num_paginas);
		}
		else {
			int idx=-1;
			for(int i=0;i<MAX_DISCOS;i++) {
				if(discos[i]==null) {
					idx=i;
				}
			}
			if(idx==-1) {
				System.out.println("No hay capacidad para mas discos");
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
			discos[idx]= new Disco(id,titulo,estanteria,altura,autor,discografica);
		}
	}

	public void prestamo(Scanner in) {
		System.out.println("Que quieres prestar (disco/libro):");
		String tipo=in.next();
		int idx=-1;
		for(int i=0;i<((tipo.equals("disco"))?MAX_DISCOS:MAX_LIBROS);i++) {
			if(tipo.equals("disco")) {
				if(discos[i]==null) {
					idx=i;
					break;
				}
			}else {
				if(libros[i]==null) {
					idx=i;
					break;
				}
			}
		}
		if(idx==-1) {
			System.out.println("No se pueden prestar más materiales de ese tipo");
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
		for(int i=0;i<((tipo.equals("disco"))?MAX_DISCOS:MAX_LIBROS);i++) {
			if(tipo.equals("disco")) {
				if(discos[i]!=null && discos[i].getId()==id) {
					pres=discos[i];
				}
			}else {
				if(libros[i]!=null && libros[i].getId()==id) {
					pres=libros[i];
				}
			}
		}
		if(pres == null) {
			System.out.println("No existe tal material");
			return;
		}
		String fecha_inicio=LocalDate.now().toString();
		if(tipo.equals("disco")) {
			prestamosDiscos[idx] = new PrestamoDisco(dni,fecha_inicio,(Disco) pres);
		}
		else {
			prestamosLibros[idx] = new PrestamoLibro(dni,fecha_inicio,(Libro) pres);
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
		for(int i=0;i<MAX_PRESTAMOS_DISCOS;i++) {
			if(prestamosDiscos[i]!=null && prestamosDiscos[i].getDni()==dni) {
				System.out.println(prestamosDiscos[i].toString());
			}
		}
		for(int i=0;i<MAX_PRESTAMOS_LIBROS;i++) {
			if(prestamosLibros[i]!=null) {
				System.out.println(prestamosLibros[i].toString());
			}
			if(prestamosLibros[i]!=null && prestamosLibros[i].getDni()==dni) {
				System.out.println(prestamosLibros[i].toString());
			}
		}
	}

	public void compararLibros(Scanner in) {
		System.out.println("Introduce el id del primer libro:");
		int id1=in.nextInt();
		int idx1=-1;
		for(int i=0;i<MAX_LIBROS;i++) {
			if(libros[i]!=null && libros[i].getId()==id1)idx1=i;
		}
		if(idx1==-1) {
			System.out.println("No existe tal libro");
			return;
		}
		System.out.println("Introduce el id del segundo libro:");
		int id2=in.nextInt();
		int idx2=-1;
		for(int i=0;i<MAX_LIBROS;i++) {
			if(libros[i]!=null && libros[i].getId()==id2)idx2=i;
		}
		if(idx2==-1) {
			System.out.println("No existe tal libro");
			return;
		}
		
		if(libros[idx1].equals(libros[idx2])) {
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
		for(int i=0;i<MAX_LIBROS;i++) {
			if(libros[i]!=null && libros[i].getId()==id)mat=libros[i];
		}
		for(int i=0;i<MAX_DISCOS;i++) {
			if(discos[i]!=null && discos[i].getId()==id)mat=discos[i];
		}
		if(mat==null) {
			System.out.println("No existe tal material");
			return;
		}
		System.out.println(mat.dondeColocar());
	}
}
