package ejercicio1;

public class App {
	public static void main(String[] args) {
		int[] x = {0,1,2,3,4};
		try {
			x[5]=5;
		}catch(Exception e){
			System.out.println("El programa se recupera de la excepción y continúa");
		}
	}
}
