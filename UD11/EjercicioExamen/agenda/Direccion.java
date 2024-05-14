package agenda;

import java.io.Serializable;

public class Direccion implements Serializable{
  private String calle;
  private int cp;
  private int num;
  private String ciudad;
  private int personal;

  public Direccion(String calle, int cp, int num, String ciudad, int personal) {
    setCalle(calle);
    setCp(cp);
    setNum(num);
    setCiudad(ciudad);
    setPersonal(personal);
  }

  public String getCalle() {
    return calle;
  }

  public void setCalle(String calle) {
    if (calle == null) throw new IllegalArgumentException("calle cannot be null");
    this.calle = calle;
  }

  public int getCp() {
    return cp;
  }

  public void setCp(int cp) {
    this.cp = cp;
  }

  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }

  public String getCiudad() {
    return ciudad;
  }

  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }

  public Integer getPersonal() {
    return personal;
  }

  public void setPersonal(Integer personal) {
    if (personal == null) throw new IllegalArgumentException("personal cannot be null");
    this.personal = personal;
  }
}
