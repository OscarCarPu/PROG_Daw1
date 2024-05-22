package festival;

public class Grupo {
	private String nombre;
	private int cache;
	private String tipoMusica;

	public Grupo(String nombre, int cache, String tipoMusica) throws Exception {
		setNombre(nombre);
		setCache(cache);
		setTipoMusica(tipoMusica);
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setCache(int cache) {
		this.cache = cache;
	}

	public int getCache() {
		return cache;
	}

	public void setTipoMusica(String tipoMusica) throws Exception {
		if (!(tipoMusica.equals("Rock") || tipoMusica.equals("Pop") || tipoMusica.equals("Rap")
				|| tipoMusica.equals("Electronica")))
			throw new Exception("Tipo de música invalido");
		this.tipoMusica = tipoMusica;
	}

	public String getTipoMusica() {
		return tipoMusica;
	}

	public String toStringReduced() {
		return nombre + ", " + tipoMusica;
	}

	public String toString() {
		return nombre + ", " + tipoMusica + ", " + cache + "€";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof Grupo))
			return false;
		if (obj == this)
			return true;
		return this.getNombre().equals(((Grupo) obj).getNombre());
	}
}
