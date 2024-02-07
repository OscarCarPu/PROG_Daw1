package ejercicio6;

import java.util.*;

public class Agencia implements Ejercicio6{
  LinkedList<Reserva> reservas;
  Iterator<Reserva> current;

  public Agencia(){
    reservas = new ArrayList<>();
    current = reservas.iterator();
  }

  public void insert(Object x){
    reservas.add((Reserva) x);
  }

  public void remove(Object x){
    reservas.remove((Reserva) x);
  }

  public void removeCurrent(){
    current.remove();
  }

  public boolean find(Object x){
    Iterator<Reserva> it = reservas.iterator();
    boolean found=false;
    while(it.hasNext() && found==false){
      Reserva a = it.next();
      if(a.equals((Reserva) x)){
        current=it;
        found=true;
      }
    }
    return found;
  }

  public void goFirst(){
    current=reservas.iterator();
  }

  public void advance(){
    if(current.hasNext()){
      current.next();
    }
  }

  public boolean isOnList(){
    return reservas.size()!=0;
  }

  public Object getCurrent(){
    return (Reserva) current.next();
  }

  public Object getPrevious(){
    ListIterator<Reserva> l = (ListIterator<Reserva>) current;
    if(l.hasPrevious()){
      return (Reserva) l.previous();
    }
    return getCurrent();
  }
}