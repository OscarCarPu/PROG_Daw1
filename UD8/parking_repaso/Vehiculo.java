package parking_repaso;

public class Vehiculo{
  private String matricula;
  private String color;
  private int plazas;

  public Vehiculo(String matricula,String color){
    this.matricula=matricula;
    this.color=color;
  }

  public String getMatricula(){
    return matricula;
  }

  public void setMatricula(String matricula){
    this.matricula=matricula;
  }

  public String getColor(){
    return color;
  }

  public void setColor(String color){
    this.color=color;
  }

  public int getPlazas(){
    return plazas;
  }

	public void setPlazas(int plazas) {
		this.plazas = plazas;
		
	}

}