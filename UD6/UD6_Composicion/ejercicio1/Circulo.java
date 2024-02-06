package ejercicio1;

class Circulo{
	private Punto centro;
	private int radio;
	
	public Punto getCentro() {
		return centro;
	}
	
	public int getRadio() {
		return radio;
	}
	
	public void setCentro(Punto centro) {
		this.centro=centro;
	}
	
	public void setRadio(int radio) {
		this.radio=radio;
	}
	
	public Circulo(int radio,Punto centro) {
		setRadio(radio);
		setCentro(centro);
	}
}
