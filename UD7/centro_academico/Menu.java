package centro_academico;


import java.util.Scanner;

public class Menu {

	public static boolean validoDni(String a) {
		if(!a.matches("\\d{8}[A-Z]")) {
			return false;
		}
		int sum=0;
		for(int i=0;i<8;i++) {
			sum+=(Math.pow(10,(7-i)))*((int)a.charAt(i)-(int)('0'));
		}
		System.out.println(sum);
		String order="TRWAGMYFPDXBNJZSQVHLCKE";
		if(order.charAt(sum%23)!=a.charAt(8))return false;
		
		return true;
	}
	
	public static String LRtrim(String a) {
		a=a.replaceAll("^\\s+", "");
		a=a.replaceAll("\\s+$", "");
		return a;
	}
	
  public static void main(String[] args) {
    CentroAcademico centroAcademico = new CentroAcademico();
    Scanner in = new Scanner(System.in);

    int choice;
    do {
      System.out.println("1. Crear Alumno");
      System.out.println("2. Crear Asignatura");
      System.out.println("3. Matricular");
      System.out.println("4. Imprimir Alumno");
      System.out.println("5. Imprimir Alumnos");
      System.out.println("6. Imprimir Asignatura");
      System.out.println("7. Agregar Calificación");
      System.out.println("8. Comparar Alumnos");
      System.out.println("0. Salir");
      System.out.print("Ingrese su elección: ");
      choice=-1;
      while(choice==-1){
        try{
          choice=in.nextInt();
          in.nextLine();
          if(choice<0 || choice>8){
            System.out.println("Introduce un número válido");
            choice=-1;
          }
        }catch(Exception e){
          in.nextLine();
          System.out.println("Introduce un número");
        }
      }
      System.out.println();
      switch (choice) {
        case 1:
          System.out.print("Ingrese expediente del alumno: ");
          String expedienteAlumno = in.nextLine();
          expedienteAlumno=LRtrim(expedienteAlumno);
          while(!validoDni(expedienteAlumno)){
        	  System.out.println("Ingrese un expediente válido: ");
        	  expedienteAlumno = in.nextLine();
              expedienteAlumno=LRtrim(expedienteAlumno);

          }
          System.out.print("Ingrese nombre del alumno: ");
          String nombreAlumno = in.nextLine();
          nombreAlumno=LRtrim(nombreAlumno);
          boolean creado = centroAcademico.crearAlumno(
            expedienteAlumno,
            nombreAlumno
          );
          if (creado) {
            System.out.println("Alumno creado exitosamente.");
          } else {
            System.out.println("Error: El alumno ya existe.");
          }
          break;
        case 2:
          System.out.print("Ingrese código de la asignatura: ");
          String codigoAsignatura = in.nextLine();
          codigoAsignatura=LRtrim(codigoAsignatura);
          while(!codigoAsignatura.matches("A-\\d{3}")) {
        	  System.out.println("Ingrese un código válido: ");
        	  codigoAsignatura = in.nextLine();
        	  codigoAsignatura=LRtrim(codigoAsignatura);
          }
          System.out.print("Ingrese nombre de la asignatura: ");
          String nombreAsignatura = in.nextLine();
          nombreAsignatura=LRtrim(nombreAsignatura);
          int creditosAsignatura=0;
          while (creditosAsignatura <= 0) {
              System.out.println("Ingrese el número de créditos de la asignatura (debe ser un número entero mayor que 0):");
              try {
                  creditosAsignatura = Integer.parseInt(in.nextLine());
              } catch (NumberFormatException e) {
                  System.out.println("Error: Debe ingresar un número entero válido.");
              }
              if (creditosAsignatura <= 0) {
                  System.out.println("Error: Debe ingresar un número de créditos mayor a 0.");
              }
          }
          boolean creadoAsignatura = centroAcademico.crearAsignatura(
            codigoAsignatura,
            nombreAsignatura,
            creditosAsignatura
          );
          if (creadoAsignatura) {
            System.out.println("Asignatura creada exitosamente.");
          } else {
            System.out.println("Error: La asignatura ya existe.");
          }
          break;
        case 3:
          System.out.print("Ingrese expediente del alumno: ");
          String expedienteMatricula = in.nextLine();
          expedienteMatricula=LRtrim(expedienteMatricula);
          System.out.print("Ingrese código de la asignatura: ");
          String codigoMatricula = in.nextLine();
          codigoMatricula=LRtrim(codigoMatricula);
          boolean matriculado = centroAcademico.matricular(
            expedienteMatricula,
            codigoMatricula
          );
          if (matriculado) {
            System.out.println("Matrícula exitosa.");
          } else {
            System.out.println(
              "Error: No se pudo matricular al alumno o la asignatura no existe."
            );
          }
          break;
        case 4:
          System.out.print("Ingrese expediente del alumno a imprimir: ");
          String expedienteImprimir = in.nextLine();
          expedienteImprimir=LRtrim(expedienteImprimir);
          centroAcademico.imprimirAlumno(expedienteImprimir);
          break;
        case 5:
          centroAcademico.imprimirAlumnos();
          break;
        case 6:
          System.out.print("Ingrese código de la asignatura a imprimir: ");
          String codigoImprimir = in.nextLine();
          codigoImprimir=LRtrim(codigoImprimir);
          centroAcademico.imprimirAsignatura(codigoImprimir);
          break;
        case 7:
          System.out.print("Ingrese expediente del alumno: ");
          String expedienteCalificacion = in.nextLine();
          expedienteCalificacion=LRtrim(expedienteCalificacion);
          System.out.print("Ingrese código de la asignatura: ");
          String codigoCalificacion = in.nextLine();
          codigoCalificacion=LRtrim(codigoCalificacion);
          double calificacion=0;
          while (calificacion <= 0) {
              System.out.println("Ingrese una calificación válida (>0): ");
              try {
                  calificacion = Double.parseDouble(in.nextLine());
              } catch (NumberFormatException e) {
                  System.out.println("Error: Debe ingresar un número válido.");
              }
              if (calificacion <= 0) {
                  System.out.println("Error: Debe ingresar una calificación mayor a 0.");
              }
          }
          boolean agregada = centroAcademico.agregarCalificacion(
            expedienteCalificacion,
            codigoCalificacion,
            calificacion
          );
          if (agregada) {
            System.out.println("Calificación agregada exitosamente.");
          } else {
            System.out.println(
              "Error: No se pudo agregar la calificación o el alumno no está matriculado en la asignatura."
            );
          }
          break;
        case 8:
          System.out.print("Ingrese expediente del primer alumno: ");
          String expediente1 = in.nextLine();
          expediente1=LRtrim(expediente1);
          System.out.print("Ingrese expediente del segundo alumno: ");
          String expediente2 = in.nextLine();
          expediente2=LRtrim(expediente2);
          centroAcademico.compararAlumno(expediente1, expediente2);
          break;
        case 0:
          System.out.println("Saliendo del programa...");
          return;
        default:
          System.out.println(
            "Opción no válida. Por favor, seleccione una opción válida."
          );
      }
      System.out.println();
      System.out.println("Pulsa ENTER para continuar...");
      in.nextLine();
      System.out.println();
    } while (choice != 0);

    in.close();
  }
}
