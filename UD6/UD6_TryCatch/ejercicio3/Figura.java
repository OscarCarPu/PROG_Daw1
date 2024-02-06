package ejercicio3;

public abstract class Figura {
	protected String color;
	public Figura(String color) throws Exception {
		if(this.color.equals("blanco"))throw new Exception("Error in color");
		this.color=color;
	}
	abstract public double area();
}


