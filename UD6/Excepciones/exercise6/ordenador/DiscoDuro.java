package exercise6.ordenador;

class DiscoDuro {
    private float capacidad;
    private String tipo;
    private int velocidad;
    
    public DiscoDuro(float capacidad, String tipo, int velocidad){
         this.capacidad=capacidad;
        this.tipo=tipo;
        this.velocidad=velocidad;
        
  }
    
    public static DiscoDuro crearDD () {
    	
    	return new DiscoDuro(1024f,"ssd", 3500);
    }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return tipo + capacidad + velocidad;
    }
    
}

