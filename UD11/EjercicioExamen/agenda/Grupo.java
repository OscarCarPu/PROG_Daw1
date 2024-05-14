package agenda;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Grupo implements Serializable{
  
  private String nombre;
  private List<Contacto> contactos;

  public Grupo(String nombre,List<Contacto> contactos) {
    setNombre(nombre);
    setContactos(contactos);
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    if (nombre == null) throw new IllegalArgumentException("nombre cannot be null");
    this.nombre = nombre;
  }

  public List<Contacto> getContactos() {
    return contactos;
  }

  public void setContactos(List<Contacto> contactos) {
    if (contactos == null){
      this.contactos = new ArrayList<>();
    }
    this.contactos = contactos;
  }

  public boolean hasContacto(Contacto contacto) {
    return contactos.contains(contacto);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Grupo other = (Grupo) obj;
    return nombre.equals(other.nombre);
  }
}
