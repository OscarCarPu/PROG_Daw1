package ejercicio1;

public class DNI{
  private String dni;
  public DNI(String dni) throws DNIException{
      if(!dni.matches("^[0-9]{8}[A-Z]")){
        throw new DNIException("El dni no tiene un buen formato");
      }
      this.dni=dni;
  }
}

class DNIException extends Exception{
  public DNIException(String msg){
    super(msg);
  }
}