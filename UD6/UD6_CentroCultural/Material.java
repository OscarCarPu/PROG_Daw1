abstract public class Material {
	private int id;
	private String titulo;
	private int estanteria;
	private int altura;
	private String autor;
	
	Material(int id,String titulo,int estanteria,int altura,String autor){
		this.id=id;
		this.titulo=titulo;
		this.estanteria=estanteria;
		this.altura=altura;
		this.autor=autor;
	}
	
	public final String dondeColocar() {
		return "El material con código "+id+" debe colocarlo en la estantería "+estanteria+" y altura "+altura;
	}
	
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "El material con código "+id+" tiene de titulo: "+titulo+" y autor "+autor+"\n"+dondeColocar()+"\n";
	}
	
	public String getTitulo() {
		return titulo;
	}
}
