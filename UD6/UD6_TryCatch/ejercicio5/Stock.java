package ejercicio5;

class FaltaStockException extends Exception{
	int id;
	int cantidad;
	public FaltaStockException(int id,int cantidad,String msg) {
		super(msg);
		this.cantidad=cantidad;
		this.id=id;
	}
	public String toString() {
		return "Error: falta stock para hacer un pedido de "+cantidad+ " productos con id "+id;
	}
}

public class Stock {
	private int id;
	private int precio;
	private int cantidad;
	public void vender() {
		System.out.println("Vendido producto "+id+", "+cantidad+" unidades a "+precio+"€.");
	}
	
	public void sinStock() throws FaltaStockException{
		throw new FaltaStockException(id,cantidad,"Falt aStock");
	}
}
