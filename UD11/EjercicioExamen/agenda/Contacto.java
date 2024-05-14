package agenda;

import java.io.Serializable;
import java.util.Date;

public class Contacto implements Serializable{
  private String nombre;
  private int numero_telefono;
  private Date fecha_nacimiento;
  private Direccion direccion;
  private String email;

  public Contacto(String nombre, int numero_telefono, Date fecha_nacimiento, Direccion direccion, String email) {
    setNombre(nombre);
    setNumero_telefono(numero_telefono);
    setFecha_nacimiento(fecha_nacimiento);
    setDireccion(direccion);
    setEmail(email);
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    if (nombre == null) throw new IllegalArgumentException("nombre cannot be null");
    this.nombre = nombre;
  }

  public int getNumero_telefono() {
    return numero_telefono;
  }

  public void setNumero_telefono(Integer numero_telefono) {
    if (numero_telefono == null) throw new IllegalArgumentException("numero_telefono cannot be null");
    this.numero_telefono = numero_telefono;
  }

  public Date getFecha_nacimiento() {
    return fecha_nacimiento;
  }

  public void setFecha_nacimiento(Date fecha_nacimiento) {
    this.fecha_nacimiento = fecha_nacimiento;
  }

  public Direccion getDireccion() {
    return direccion;
  }

  public void setDireccion(Direccion direccion) {
    this.direccion = direccion;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    if (email == null) throw new IllegalArgumentException("email cannot be null");
    this.email = email;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Contacto contacto = (Contacto) o;

    if (numero_telefono != contacto.numero_telefono) return false;
    if (!nombre.equals(contacto.nombre)) return false;
    if (!email.equals(contacto.email)) return false;
    return true;
  }
}