package ejercicio2;

public class Test {

	public static void main(String[] args) {
		aparato bombilla = new aparato(150);
		aparato plancha = new aparato(2000);
		System.out.println(aparato.consumo_total);
		bombilla.encender();
		plancha.encender();
		System.out.println(aparato.consumo_total);
		bombilla.apagar();
		System.out.println(aparato.consumo_total);
	}
}
