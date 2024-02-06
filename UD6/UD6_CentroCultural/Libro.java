public class Libro extends Material{
	private int num_paginas;
	
	Libro(int id,String titulo,int estanteria,int altura,String autor,int num_paginas){
		super(id,titulo,estanteria,altura,autor);
		this.num_paginas=num_paginas;
	}
	@Override 
	public String toString() {
		return super.toString()+"Es un material de tipo libro y tiene "+num_paginas+" páginas.";
	}
	
	public boolean equals(Libro l) {
		return getTitulo().equals(l.getTitulo()) && num_paginas==l.num_paginas;
	}
}
