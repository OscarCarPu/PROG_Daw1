package ejercicio4;

abstract class Item {
	protected String titulo;
	protected float precio = 5.0f;
	public abstract boolean esAlquilable();
	public float getPrecio() {
		return precio;
	}
}

class Pelicula extends Item {
	public boolean esAlquilable() {
		return true;
	}
}

class Libro extends Item {
	public boolean esAlquilable() {
		return true;
	}
	public float getPrecio() {
		return 0.0f;
	}
}

class TestAbstract {
	public static void main(String[] args) {
		Pelicula peli = new Pelicula();
		Libro libro = new Libro();
		System.out.println(peli.esAlquilable());
		System.out.println(libro.getPrecio());
	}
}