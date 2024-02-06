package ejercicio2;

public class Ip{
  private String ip;

  public Ip(String ip) throws IpException{
    if(!ip.matches("((([0-9])|([1-9][0-9])|(1[0-9][0-9])|(2[0-4][0-5])|(25[0-5]))(\\.)){3}(([0-9])|([1-9][0-9])|(1[0-9][0-9])|(2[0-4][0-5])|(25[0-5]))")){
      throw new IpException("Error en el formato de la ip");
    }
  }
}