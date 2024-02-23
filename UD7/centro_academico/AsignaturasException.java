package centro_academico;

public class AsignaturasException extends Exception{
  
	public AsignaturasException() {
		super("La asignatura no tiene alumnos");
	}
	
}