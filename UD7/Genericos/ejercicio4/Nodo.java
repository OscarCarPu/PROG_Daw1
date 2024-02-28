package ejercicio4;

public class Nodo<T>{
  private Nodo<T> sig;
  private T dato;
  public Nodo(T dato) {
    this.dato = dato;
    this.sig=null;
  }
  public Nodo(T dato, Nodo<T> sig) {
    this.dato = dato;
    this.sig = sig;
  }
  public void setSiguiente(Nodo<T> sig) {
    this.sig = sig;
  }
  public Nodo<T> getSiguiente() {
    return sig;
  }
  public T getDato() {
      
    return dato;
  }
}


