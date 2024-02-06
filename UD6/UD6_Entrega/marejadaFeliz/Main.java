package marejadaFeliz;

public class Main {
	public static void main(String[] args) {
		Tripulante marineros[] = new Tripulante[7];
		marineros[0] = new Capitan(1000,1,54,12,"Juan","6237238723",'H');
		marineros[1] = new JefeFlota(5,9,2,56,5,"Jose","000000123",'H');
		marineros[2] = new Marinero(4,3,34,1,"Juana","109209123",'M');
		marineros[3] = new Marinero(3,4,43,12,"Juanma","198238423",'H');
		marineros[4] = new Marinero(2,5,18,0,"Josefina","98129812378",'M');
		marineros[5] = new JefeFlota(7,6,6,20,1,"Joselito","9827398273",'H');
		marineros[6] = new Capitan(155643,7,67,30,"Jorge","92839823",'H');
		for(int i=0;i<7;i++) {
			System.out.println(marineros[i].toString());
		}
		
	}
}
