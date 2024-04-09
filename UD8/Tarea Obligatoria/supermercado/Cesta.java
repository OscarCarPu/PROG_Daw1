package supermercado;

import java.util.ArrayList;

public class Cesta {
  private int id;
  private boolean descuento;
  private ArrayList<ProductoCesta> compra;

  public Cesta(int id){
    this.id=id;
    compra = new ArrayList<>();
    descuento=false;
  }

  public Cesta(int id,boolean descuento){
    this.id=id;
    compra = new ArrayList<>();
    this.descuento=descuento;
  }

  public Cesta(int id,ArrayList<ProductoCesta> compra){
    this.id=id;
    this.compra=compra;
    descuento=false;
  }

  public Cesta(int id,ArrayList<ProductoCesta> compra,boolean descuento){
    this.id=id;
    this.compra=compra;
    this.descuento=descuento;
  }

  public void setId(int id){
    this.id=id;
  }

  public int getId(){
    return id;
  }

  public void setCompra(ArrayList<ProductoCesta> compra){
    this.compra=compra;
  }

  public ArrayList<ProductoCesta> getCompra(){
    return compra;
  }

  public void setDescuento(boolean descuento){
    this.descuento=descuento;
  }

  public boolean getDescuento(){
    return descuento;
  }
  

  @Override
  public String toString(){
    String aux="Cesta de cliente nº "+id+"\n";
    double total=0;
    for(ProductoCesta p : compra){
      aux+=p.toString()+"\n";
      total+=p.getCantidad()*p.getProducto().getPrecio();
    }
    if(descuento){
      aux+="Precio sin descuento: "+String.format("%.2f",total)+"$\n";
      total*=0.95;
    }
    aux+="Precio final: "+String.format("%.2f",total)+"$";
    return aux;
  }
}
