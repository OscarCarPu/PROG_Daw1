package ejercicio2;

public class App{
  public static void main(String[] args){
    DiasSemana d1 = DiasSemana.Lunes;
    DiasSemana d2 = DiasSemana.Miercoles;
    System.out.println(d1.toString()+":"+d1.Dia());
    System.out.println(d2.toString()+":"+d2.Dia());
  }
}