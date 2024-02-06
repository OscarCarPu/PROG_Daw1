package departamento_cientifico;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Departamento departamento = new Departamento("Departamento de Ciencias", 5, 0);

    Scanner scanner = new Scanner(System.in);

    int choice;
    do {
        System.out.println("\nMenu:");
        System.out.println("1. Mostrar información del departamento");
        System.out.println("2. Añadir nuevo científico");
        System.out.println("3. Calcular presupuesto del departamento");
        System.out.println("4. Eliminar científico");
        System.out.println("5. Buscar científico");
        System.out.println("6. Nueva investigación");
        System.out.println("7. Mostrar tabla de científicos");
        System.out.println("8. Cade calculo investigación");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
        choice = scanner.nextInt();

        switch (choice) {
            case 1:
                departamento.imprimir();
                break;
            case 2:
                departamento.nuevoCientifico();
                break;
            case 3:
                departamento.calcPresupuesto();
                System.out.println("Presupuesto calculado.");
                break;
            case 4:
                System.out.print("Introduce el nombre del científico a eliminar: ");
                String nombreEliminar = scanner.next();
                departamento.eliminarCientifico(nombreEliminar);
                System.out.println("Científico eliminado.");
                break;
            case 5:
                System.out.print("Introduce el nombre del científico a buscar: ");
                String nombreBuscar = scanner.next();
                departamento.buscarCientifico(nombreBuscar);
                break;
            case 6:
                departamento.nuevaInvestigacion();
                break;
            case 7:
                departamento.mostrarTablaCientificos();
                break;
            case 0:
                System.out.println("Saliendo del programa.");
                break;
            default:
                System.out.println("Opción no válida. Inténtelo de nuevo.");
        }
    } while (choice != 0);

    scanner.close();
}
}
}
