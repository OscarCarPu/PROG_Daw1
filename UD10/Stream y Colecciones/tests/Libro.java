package tests;

public class Libro {

  private String titulo;
  private String categoria;
  private int paginas;

  public Libro(String titulo, String categoria, int paginas) {
    this.titulo = titulo;
    this.categoria = categoria;
    this.paginas = paginas;
  }

  public String getTitulo() {
    return titulo;
  }

  public String getCategoria() {
    return categoria;
  }

  public int getPaginas() {
    return paginas;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  public void setPaginas(int paginas) {
    this.paginas = paginas;
  }



}
