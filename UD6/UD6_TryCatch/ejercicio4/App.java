package ejercicio4;
class Punto{
	int x=0;
	int y=0;
	Punto(int x,int y) throws Exception{
		if(x<0 || y<0)throw new Exception("Cordenadas negativas");
		this.x=x;
		this.y=y;
	}
}

class Rectangulo{
	Punto origen;
	int ancho;
	int alto;
	Rectangulo(int x,int y,int w,int h) throws Exception{
		try {
			origen = new Punto(x,y);
		}catch(Exception e) {
			throw e;
		}
		ancho = w;
		alto=h;
	}
}
public class App {
	public static void main(String[] args) {
		try {
			Rectangulo miRectangulo = new Rectangulo(                                                                                                                                                                      2,3,4,5);
			System.out.println("Creado rectanglo");
		}catch(Exception e) {
			System.out.println("Error: "+e.getMessage());
		}finally {
			System.out.println("Fin M<in");
		}
	}
}
