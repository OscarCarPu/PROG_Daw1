

public class Principal {
	public static void main(String[] args)

	{

	ordenador.Ordenador miOrdenador1=null;

	ordenador.Ordenador miOrdenador2=null;

	/*formato contructor:capacidadMemoria,tipMemoria,velocidadMemoria,capacidadDisco,tipoDisco,velocidadDisco,tipoProcesador,velocidadProcesador,precio

	*/

	miOrdenador1= new ordenador.Ordenador(1,"DDR2",533,(float)2.0,"SATA",7200,"i3",(float)3.3,400); System.out.println("memoria miOrdenador1: " + miOrdenador1.getCapacidadMemoria());

	miOrdenador2= new ordenador.Ordenador(8,"DDR2",533,(float)1.7,"SATA",7200,"i5",(float)3.3,400);

	System.out.println("memoria miOrdenador2: " + miOrdenador2.getCapacidadMemoria());

	} 
}
