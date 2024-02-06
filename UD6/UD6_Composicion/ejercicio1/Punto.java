package ejercicio1;

class Punto {
	private int x;
	private int y;
	Punto(){
		
	}
	Punto(int x,int y){
		setX(x);
		setY(y);
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setX(int x) {
		this.x=x;
	}
	public void setY(int y) {
		this.y=y;
	}
	public void desplazar(int x,int y) {
		setX(x);
		setY(y);
	}
	public boolean puntosIguales(Punto p) {
		return p.x==this.x && p.y==this.y;
	}
}
