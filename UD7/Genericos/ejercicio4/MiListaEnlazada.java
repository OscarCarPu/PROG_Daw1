package ejercicio4;

public class MiListaEnlazada<T>{
  private Nodo<T> primero=null;
  public void insertar(T dato){
      if(primero==null){
          primero=new Nodo<T>(dato);
      }else{
          Nodo<T> temp= new Nodo<T>(dato,primero);
          primero=temp;
      }
          
  }
  public int tamano(){
      int i=0;
      Nodo<T> temp=primero;
      while(temp!=null){
          i++;
          temp=temp.getSiguiente();
      }
      return i;
  }
  public T obtener(int indice){
      Nodo<T> temp=primero;
      int i=0;
      while(i<indice){
          temp=temp.getSiguiente();
          i++;
      }
      
      return temp.getDato();
  }
}