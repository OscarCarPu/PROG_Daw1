package exercise6.ordenador;

class Memoria {
    static final int MIN_MEM=2;
    static final String TIPO = "DDR4";
    private int capacidad;
    //private String tipo;
    private int velocidad;
    
    Memoria(int capacidad, String tipo, int velocidad){
        if(capacidad<MIN_MEM)
          this.capacidad=MIN_MEM;
        else
          this.capacidad=capacidad;
        //this.tipo=tipo;
        this.velocidad=velocidad;
    }
    int getCapacidad(){
        return capacidad;
    }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return "Capacidad:" + capacidad + " Vel:" + velocidad;
    }
    
}
