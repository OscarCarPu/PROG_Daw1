package centro_academico;

import java.util.Scanner;

public class Menu {

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
          System.out.print("Ingrese nombre del alumno: ");
          String nombreAlumno = in.nextLine();
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
          System.out.print("Ingrese nombre de la asignatura: ");
          String nombreAsignatura = in.nextLine();
          System.out.print("Ingrese número de créditos de la asignatura: ");
          String creditosAsignatura = in.nextLine();
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
          System.out.print("Ingrese código de la asignatura: ");
          String codigoMatricula = in.nextLine();
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
          centroAcademico.imprimirAlumno(expedienteImprimir);
          break;
        case 5:
          centroAcademico.imprimirAlumnos();
          break;
        case 6:
          System.out.print("Ingrese código de la asignatura a imprimir: ");
          String codigoImprimir = in.nextLine();
          centroAcademico.imprimirAsignatura(codigoImprimir);
          break;
        case 7:
          System.out.print("Ingrese expediente del alumno: ");
          String expedienteCalificacion = in.nextLine();
          System.out.print("Ingrese código de la asignatura: ");
          String codigoCalificacion = in.nextLine();
          System.out.print("Ingrese calificación: ");
          double calificacion = in.nextDouble();
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
          System.out.print("Ingrese expediente del segundo alumno: ");
          String expediente2 = in.nextLine();
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
