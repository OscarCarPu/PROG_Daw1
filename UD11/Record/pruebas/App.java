package pruebas;

public class App{
    public static void main(String[] args){
        Point p = new Point(23,23);
        System.out.println(p);
    }
}

record Point(int x,int y){}