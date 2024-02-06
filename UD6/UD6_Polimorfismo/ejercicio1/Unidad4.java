package ejercicio1;

interface Serie{
	int obtenerSiguiente();
	void restablecer();
	void establecerInicio(int x);
}

class MasDos implements Serie{
	int inicio;
	int val;
	MasDos(){
		inicio=0;
		val=0;
	}
	public int obtenerSiguiente() {
		val+=2;
		return val;
	}
	
	public void restablecer() {
		inicio=0;
		val=0;
	}
	public void establecerInicio(int x) {
		inicio=x;
		val=x;
	}
}

class MasTres implements Serie{
	int inicio;
	int val;
	MasTres(){
		inicio=0;
		val=0;
	}
	
	public int obtenerSiguiente() {
		val+=3;
		return val;
	}
	
	public void restablecer() {
		inicio=0;
		val=0;
	}
	
	public void establecerInicio(int x) {
		inicio=x;
		val=x;
	}
}

public class Unidad4{
  public static void main(String[] args) {
      MasDos serie1 = new MasDos();
      MasDos serie2= new MasDos();
      MasTres serie3 = new MasTres();
      MasTres serie4= new MasTres();
      serie2.establecerInicio(200);
      serie4.establecerInicio(300);
      Serie series[] = new Serie[4];
      series[0] = new MasDos();
      series[1] = new MasDos();
      series[2] = new MasTres();
      series[3] = new MasTres();
      series[1].establecerInicio(200);
      series[3].establecerInicio(300);
      for(int i=0;i<4;i++) {
      	System.out.print("\nSerie"+(i+1)+": ");
      	for(int x=0;x<5;x++) {
      		System.out.print(series[i].obtenerSiguiente()+" ");
      	}
      }
 }
}