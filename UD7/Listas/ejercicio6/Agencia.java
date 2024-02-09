package ejercicio6;

import java.util.*;

public class Agencia implements Ejercicio6{
    private LinkedList<Reserva> l = new LinkedList<Reserva>();
    int idCurrent=0;
    public void insert(Object x){
      l.add((Reserva)x);
    } //Inserta x 
    public void remove(Object x ){
      l.remove((Reserva)x);
    } //Elimina el primer x
    public void removeCurrent(){
      if(idCurrent>=0 && idCurrent<l.size()){
        l.remove(idCurrent);
      }      
    }  //Elimina el elemento current
    public boolean find(Object x){
      if(l.contains(x)){
        idCurrent = l.indexOf(x);
        return true;
      }
      return false;
    } //Coloca current para poder ver x
    public void goFirst(){
      idCurrent =0;
    } // Coloca current en la primera posición
    public void advance(){
      idCurrent++;
    } // Avanza current al siguiente nodo
    public boolean isOnList(){
      return l.size()!=0;
    } //No está vacía
    public Object getCurrent(){
      if(idCurrent>=0 && idCurrent < l.size()){
        return l.get(idCurrent); 
      }
      return null;
    } //Elemento en la posición current
    public Object getPrevious(){
      if(idCurrent>0 && idCurrent <l.size()+1){
        return l.get(idCurrent-1);
      }
      return null;
    } // Elemento de la posición anterior al current
}