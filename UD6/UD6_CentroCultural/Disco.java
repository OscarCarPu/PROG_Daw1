

public class Disco extends Material{
	private String discografica;
	Disco(int id,String titulo,int estanteria,int altura,String autor,String discografica){
		super(id,titulo,estanteria,altura,autor);
		this.discografica=discografica;
	}
	
	public String toString() {
		return super.toString()+"Es un material de tipo disco, y tiene de discografica: "+discografica;
	}
}
