package supermercado;

public class Producto {
  private String identificador;
  private String descripcion;
  private double precio;
  
  public Producto(String identificador,String descripcion,double precio) throws Exception{
    setIdentificador(identificador);
    setDescripcion(descripcion);
    setPrecio(precio);
  }

  public void setIdentificador(String identificador) throws Exception{
    if(identificador.matches("[ABC]-[0-9]{4}")){
      this.identificador=identificador;
    }
    else{
      throw new Exception("Mal formato");
    }
  }

  public String getIdentificador(){
    return identificador;
  }

  public void setDescripcion(String descripcion){
    this.descripcion=descripcion;
  }

  public String getDescripcion(){
    return descripcion;
  }

  public void setPrecio(double precio){
    this.precio=precio;
  }

  public double getPrecio(){
    return precio;
  }

  @Override
  public String toString(){
    return identificador+": "+descripcion+" ------ "+String.format("%.2f",precio)+"$";
  }
}
