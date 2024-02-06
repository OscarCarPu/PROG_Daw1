package ejercicio5;

abstract class Figura {
	private String color;
	
	Figura(String color){
		this.setColor(color);
	}
	
	abstract double area();

	public String getColor() {
		return color;
		
	}

	public void setColor(String color) {
		this.color = color;
		
	}

}
