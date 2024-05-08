package competicion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.Scanner;

public class Menu {
  private static App app = new App();

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    try {
      app.crearDatosInternalmente();
    } catch (Exception e) {
      System.err.print(e.getMessage());
    }
    mostrarCarreras();
    mostrarEquipos();
    mostrarParticipantes();
    int opcion = 0;
    do {
      mostrarMenu();
      opcion = in.nextInt();
      in.nextLine();
      switch (opcion) {
        case 1:
          altaParticipante(in);
          break;
        case 2:
          altaEquipo(in);
          break;
        case 3:
          altaCarrera(in);
          break;
        case 4:
          altaParticipanteEquipo(in);
          break;
        case 5:
          altaEquipoCarrera(in);
          break;
        case 6:
          otorgarPremio(in);
          break;
        case 7:
          mostrarParticipantesEquipo(in);
          break;
        case 8:
          mostrarSeniorsMasculinos(in);
          break;
        case 9:
          mostrarMenorParticipante(in);
          break;
        case 10:
          mostrarEquipos();
          mostrarParticipantes();
          mostrarCarreras();
          break;
        case 11:
          volcarDatos(in);
          break;
        case 12:
          mostrarDatosBD();
          break;
        case 13:
          borrarDatosBD();
          break;
        default:
          break;
      }
    } while (opcion != 0);
    in.close();
    System.out.print("Fin del programa");

  }

  public static void mostrarMenu() {
    System.out.println("Menu");
    System.out.println("Seleccione una opcion:");
    System.out.println("----------------------");
    System.out.println("0. Salir");
    System.out.println("1. Alta participante");
    System.out.println("2. Alta equipo");
    System.out.println("3. Alta carrera");
    System.out.println("4. Alta participante en equipo");
    System.out.println("5. Alta equipo en carrera");
    System.out.println("6. Otorgar premio");
    System.out.println("7. Mostrar paricipantes de un equipo");
    System.out.println("8. Mostrar seniors masculinos de dos equipos");
    System.out.println("9. Mostrar menor participante de un equipo");
    System.out.println("10 - Mostrar equipos, participantes y carreras");
    System.out.println("11 - Volcar datos a base de datos");
    System.out.println("12 - Mostrar datos de la base de datos");
    System.out.println("13 - Borrar datos de la base de datos");
  }

  public static void mostrarEquipos() {
    System.out.println("Equipos");
    System.out.println("-------");
    for (Equipo e : app.getEquipos()) {
      System.out.println(e);
    }
  }

  public static void mostrarParticipantes() {
    System.out.println("Participantes");
    System.out.println("------------");
    for (Participante p : app.getParticipantes()) {
      System.out.println(p);
    }
  }

  public static void mostrarCarreras() {
    System.out.println("Carreras");
    System.out.println("--------");
    for (Carrera c : app.getCarreras()) {
      System.out.println(c);
    }
  }

  public static void altaParticipante(Scanner in) {
    System.out.println("Introduce el nombre del participante:");
    String nombre = in.nextLine();
    System.out.println("Introduce los apellidos del participante:");
    String apellidos = in.nextLine();
    System.out.println("Introduce el sexo del participante:");
    char sexo = in.nextLine().charAt(0);
    System.out.println("Introduce la edad del participante:");
    int edad = in.nextInt();
    in.nextLine();
    Participante p;
    try {
      p = new Participante(nombre, apellidos, sexo, edad);
    } catch (IllegalArgumentException e) {
      System.out.print(e.getMessage());
      return;
    }
    try {
      app.altaParticipante(p);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    System.out.println("Participante dado de alta");
  }

  public static void altaEquipo(Scanner in) {
    System.out.println("Introduce el nombre del equipo:");
    String nombre = in.nextLine();
    System.out.println("Introduce el nombre del capitan:");
    String nombreCapitan = in.nextLine();
    Optional<Participante> capitan = app.getParticipante(nombreCapitan);
    if (capitan.isEmpty()) {
      System.out.println("El capitan no existe");
      return;
    }
    Equipo e = new Equipo(nombre, capitan.get());
    try {
      app.altaEquipo(e);
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
    System.out.println("Equipo dado de alta");
  }

  public static void altaCarrera(Scanner in) {
    System.out.println("Introduce el nombre de la carrera:");
    String nombre = in.nextLine();
    Date fecha = null;
    do {
      System.out.println("Introduce la fecha de la carrera (dd/MM/yyyy):");
      String fechaStr = in.nextLine();
      try {
        fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaStr);
      } catch (ParseException e) {
        System.out.println("Mal formato de fecha");
      }
    } while (fecha == null);
    System.out.println("Introduce los km de la carrera:");
    double km = in.nextDouble();
    in.nextLine();
    System.out.println("Introduce los premios de la carrera:");
    int[] premios = new int[3];
    for (int i = 0; i < 3; i++) {
      premios[i] = in.nextInt();
    }
    in.nextLine();
    Carrera c = new Carrera(nombre, fecha, km, premios);
    try {
      app.altaCarrera(c);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    System.out.println("Carrera dada de alta");
  }

  public static void altaParticipanteEquipo(Scanner in) {
    mostrarEquipos();
    mostrarParticipantes();
    System.out.println("Introduce el nombre del equipo:");
    String nombreEquipo = in.nextLine();
    System.out.println("Introduce el nombre del participante:");
    String nombreParticipante = in.nextLine();
    Optional<Equipo> equipo = app.getEquipo(nombreEquipo);
    Optional<Participante> participante = app.getParticipante(nombreParticipante);
    if (equipo.isEmpty() || participante.isEmpty()) {
      System.out.println("El equipo o el participante no existen");
      return;
    }
    try {
      app.altaParticipanteEquipo(participante.get(), equipo.get());
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    System.out.println("Participante dado de alta en el equipo");
  }

  public static void altaEquipoCarrera(Scanner in) {
    mostrarEquipos();
    mostrarCarreras();
    System.out.println("Introduce el nombre del equipo:");
    String nombreEquipo = in.nextLine();
    System.out.println("Introduce el nombre de la carrera:");
    String nombreCarrera = in.nextLine();
    Optional<Equipo> equipo = app.getEquipo(nombreEquipo);
    Optional<Carrera> carrera = app.getCarrera(nombreCarrera);
    if (equipo.isEmpty() || carrera.isEmpty()) {
      System.out.println("El equipo o la carrera no existen");
      return;
    }
    try {
      app.altaEquipoCarrera(equipo.get(), carrera.get());
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    System.out.println("Equipo dado de alta en la carrera");
  }

  public static void otorgarPremio(Scanner in) {
    mostrarEquipos();
    mostrarCarreras();
    System.out.println("Introduce el nombre del equipo:");
    String nombreEquipo = in.nextLine();
    System.out.println("Introduce el nombre de la carrera:");
    String nombreCarrera = in.nextLine();
    System.out.println("Introduce la posicion (1-3):");
    int posicion = in.nextInt();
    in.nextLine();
    Optional<Equipo> equipo = app.getEquipo(nombreEquipo);
    Optional<Carrera> carrera = app.getCarrera(nombreCarrera);
    if (equipo.isEmpty() || carrera.isEmpty()) {
      System.out.println("El equipo o la carrera no existen");
      return;
    }
    try {
      app.otorgarPremio(equipo.get(), carrera.get(), posicion);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    System.out.println("Premio otorgado");
  }

  public static void mostrarParticipantesEquipo(Scanner in) {
    mostrarEquipos();
    System.out.println("Introduce el nombre del equipo:");
    String nombreEquipo = in.nextLine();
    Optional<Equipo> equipo = app.getEquipo(nombreEquipo);
    if (equipo.isEmpty()) {
      System.out.println("El equipo no existe");
      return;
    }
    System.out.println(app.mostrarListadoParticipantes(equipo.get()));
  }

  public static void mostrarSeniorsMasculinos(Scanner in) {
    mostrarEquipos();
    System.out.println("Introduce el nombre del equipo 1:");
    String nombreEquipo1 = in.nextLine();
    System.out.println("Introduce el nombre del equipo 2:");
    String nombreEquipo2 = in.nextLine();
    Optional<Equipo> equipo1 = app.getEquipo(nombreEquipo1);
    Optional<Equipo> equipo2 = app.getEquipo(nombreEquipo2);
    if (equipo1.isEmpty() || equipo2.isEmpty()) {
      System.out.println("El equipo 1 o el equipo 2 no existen");
      return;
    }
    System.out.println(app.mostrarSeniorEquipos(equipo1.get(), equipo2.get()));
  }

  public static void mostrarMenorParticipante(Scanner in) {
    mostrarEquipos();
    System.out.println("Introduce el nombre del equipo:");
    String nombreEquipo = in.nextLine();
    Optional<Equipo> equipo = app.getEquipo(nombreEquipo);
    if (equipo.isEmpty()) {
      System.out.println("El equipo no existe");
      return;
    }
    System.out.println(app.menoParticipante(equipo.get()));
  }

  public static void volcarDatos(Scanner in) {
    try{
      BD.connectar();
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return;
    }
    try {
      if (!BD.tablaCreada()){
        System.out.println("Creando tabla en la base de datos...");
        try {
          BD.crearTabla();
        } catch (Exception e) {
          System.out.println(e.getMessage());
          return;
        }
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return;
    }
    System.out.println("La tabla ya existe, de que carrera quieres guardar datos (nombre,equipo con mas puntos,participantes,fecha)?");
    String nombreCarrera = in.nextLine();
    Optional<Carrera> carrera = app.getCarrera(nombreCarrera);
    if (carrera.isEmpty()) {
      System.out.println("La carrera no existe");
      return;
    }
    try {
      BD.guardarDatos(carrera.get(),app);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return;
    
    }
    System.out.println("Datos guardados correctamente");
    try{
      BD.cerrar();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public static void mostrarDatosBD() {
    try{
      BD.connectar();
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return;
    }
    try {
      if (!BD.tablaCreada()){
        System.out.println("Creando tabla en la base de datos...");
        try {
          BD.crearTabla();
        } catch (Exception e) {
          System.out.println(e.getMessage());
          return;
        }
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return;
    }
    try {
      System.out.println(BD.mostrarDatos());
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return;
    }
    try{
      BD.cerrar();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public static void borrarDatosBD() {
    try{
      BD.connectar();
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return;
    }
    try {
      if (!BD.tablaCreada()){
        System.out.println("La tabla no existe");
        return;
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return;
    }
    try {
      BD.borrarTabla();
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return;
    }
    System.out.println("Datos borrados correctamente");
    try{
      BD.cerrar();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

}
