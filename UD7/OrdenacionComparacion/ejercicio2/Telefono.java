package ejercicio2;

public class Telefono implements Comparable<Object>{
  private String tel;

  public String getTel(){
    return tel;
  }

  public Telefono(String tel){
    this.tel=tel;
  }

  @Override
  public String toString(){
    return tel;
  }

  @Override
  public int compareTo(Object o){
    Telefono t = (Telefono)o;
    if(t.getTel().charAt(0)=='+' && this.tel.charAt(0)!='+'){
      return -1;
    }
    if(t.getTel().charAt(0)!='+' && this.tel.charAt(0)=='+'){
      return 1;
    }
    return -1*this.tel.compareTo(t.getTel());
  }
}