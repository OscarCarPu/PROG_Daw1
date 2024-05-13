package ejercicio1;

public class App{

}

abstract sealed class Forma permits Circulo, Rectangulo, Triangulo {
    abstract double area();
    abstract double permitro();
}

record Circulo(double r) implements Forma{
    
    double area(){
        return Math.PI*r*r;
    }
    ;
    double permitro(){
        return Math.PI*2*r;
    }
}

record Rectangulo(double b,double h) implements Forma{
    
    double area(){
        return b*h;
    }
    
    double permitro(){
        return b*2+h*2;
    }
}

record Triangulo(double a,double b,double c) implements Forma{
    
    double area(){
        double s = (a+b+c)/2;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }
    
    double permitro(){
        return a+b+c;
    }
}