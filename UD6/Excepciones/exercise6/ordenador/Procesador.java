package exercise6.ordenador;

public class Procesador{
    private String modelo;
    private float velocidad;

    Procesador(String modelo, float velocidad) {
        this.modelo = modelo;
        this.velocidad = velocidad;
    }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return "Modelo:" + modelo + " vel:" + velocidad; 
    }
    
}
