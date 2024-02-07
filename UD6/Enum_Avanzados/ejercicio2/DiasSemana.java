package ejercicio2;

public enum DiasSemana implements Dia{
  Lunes(1),Martes(2),Miercoles(3),Jueves(4),Viernes(5),Sabado(6),Domingo(7);

  private final int num;

  private DiasSemana(int num){
    this.num=num;
  }
  public int Dia(){
    return this.num;
  }
}