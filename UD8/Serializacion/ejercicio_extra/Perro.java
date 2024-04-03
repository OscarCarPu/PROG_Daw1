package ejercicio_extra;

public class Perro extends Animal{
  private boolean raboLargo;
  private final String ruido = "GUAU";

  public Perro(String nombre,int edad,boolean raboLargo){
    super(nombre,edad);
    this.raboLargo=raboLargo;
  }

  public boolean getRaboLargo(){
    return raboLargo;
  }

  public void setRaboLargo(boolean raboLargo){
    this.raboLargo=raboLargo;
  }

  public String getRuido(){
    return ruido;
  }

  public String getTipo(){
    return "Perro";
  }
}
