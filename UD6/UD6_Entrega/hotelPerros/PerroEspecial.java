package hotelPerros;

public class PerroEspecial extends Perro{
	PerroEspecial(String nombre,double peso,String color){
		super(nombre,peso,color);
	}
	
	@Override
	public void actualizarPeso(double cambio) {
		if(cambio>0) {
			if(getPeso()<10)cambio*=2;
			if(getPeso()>40)cambio/=2;
		}
		super.actualizarPeso(cambio);
	}
}
