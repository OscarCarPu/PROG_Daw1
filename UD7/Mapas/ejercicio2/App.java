package ejercicio2;

public class App{
  public static void main(String[] args){
    GuiaTelefonica g = new GuiaTelefonica();
    g.addNumber("Jose",132132542);
    g.addNumber("Maria",123456789);
    g.addNumber("Juan",789456789);
    g.retrieveAll();
    g.retrieveNumber("Juan");
    g.updateNumber("Juan",874478754);
    g.retrieveAll();
  }
}