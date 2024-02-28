package ejercicio2;

public class Pair<T,V> {
  private T first;
  private V second;
  public T getFirst() {
    return first;
  }
  public V getSecond() {
    return second;
  }
  public void setFirst(T first) {
    this.first=first;
  }
  public void setSecond(V second) {
    this.second=second;
  }

  public Pair(T first,V second){
    this.first=first;
    this.second=second;
  }

  @Override
  public String toString() {
      return "[ "+this.first+", "+this.second+" ]";
  }
}