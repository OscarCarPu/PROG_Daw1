package ejercicio_extra;

public class Gato extends Animal{
  private boolean bigoteLargo;
  private final String ruido = "MIAU";

  public Gato(String nombre,int edad,boolean bigoteLargo){
    super(nombre,edad);
    this.bigoteLargo=bigoteLargo;
  }

  public boolean getbigoteLargo(){
    return bigoteLargo;
  }

  public void setbigoteLargo(boolean bigoteLargo){
    this.bigoteLargo=bigoteLargo;
  }

  public String getRuido(){
    return ruido;
  }

  public String getTipo(){
    return "Gato";
  }
}
