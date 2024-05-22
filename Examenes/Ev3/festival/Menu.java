package festival;

import java.util.Scanner;

public class Menu {

	static Scanner in = null;

	public static void main(String[] args) {
		try {
			App.initFestival();
			App.initGrupos();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		showFestival();

		in = new Scanner(System.in);

		int opcion = -1;
		do {
			printMenu();
			opcion = in.nextInt();
			in.nextLine();
			switch (opcion) {
			case 1:
				imprimirGruposFiltrados("Pop", 6000, 10000);
				break;
			case 2:
				imprimirGrupoMasCaro("Electronica");
				break;
			case 3:
				borrarGrupo(in);
				break;
			case 4:
				actualizarCache(in);
				break;
			default:
				break;
			}

		} while (opcion != 0);

	}

	public static void showFestival() {
		System.out.println(App.getFestival());
	}

	public static void printMenu() {
		System.out.println("-----------------Menu----------------");
		System.out.println("1. Imprimir grupos de pop con un presupuesto entre 6000€ y 10,000€");
		System.out.println("2. Imprimir el grupo más caro de electrónica");
		System.out.println("3. Eliminar un grupo");
		System.out.println("4. Actualizar el caché de un grupo");
		System.out.println("0. Salir");
		System.out.println("-------------------------------------");
		System.out.println("Elige una opción:");
	}

	public static void actualizarCache(Scanner in) {
		System.out.println("--------------Grupos-----------------");
		App.getGrupos().forEach(g -> {
			System.out.println(g);
		});
		System.out.println("-------------------------------------");
		System.out.println("Elige un grupo escribiendo su nombre:");
		String nombre = in.nextLine();
		try {
			if (!App.hasGrupo(nombre)) {
				System.out.println("El grupo no existe");
				return;
			}
		} catch (Exception e) {
			System.out.println("Error al buscar el grupo");
			return;
		}
		System.out.println("Cual es el nuevo caché?");
		int cache = in.nextInt();
		in.nextLine();
		try {
			App.actualizarCache(nombre, cache);
		} catch (Exception e) {
			System.out.println("Error al actualizar el caché");
			return;
		}
		System.out.println("Caché actualizado");
	}

	public static void borrarGrupo(Scanner in) {
		System.out.println("--------------Grupos-----------------");
		App.getGrupos().forEach(g -> {
			System.out.println(g);
		});
		System.out.println("-------------------------------------");
		System.out.println("Elige un grupo escribiendo su nombre:");
		String nombre = in.nextLine();
		try {
			if (!App.hasGrupo(nombre)) {
				System.out.println("El grupo no existe");
				return;
			}
		} catch (Exception e) {
			System.out.println("Error al buscar el grupo");
			return;
		}
		try {
			App.deleteGrupo(nombre);
		} catch (Exception e) {
			System.out.println("Error al eliminar el grupo" + e.getMessage());
			return;
		}
		System.out.println("Grupo eliminado");
	}

	public static void imprimirGrupoMasCaro(String tipo) {
		System.out.println("-----------Grupo más caro------------");
		System.out.println(App.getGrupoMasCaro(tipo));
		System.out.println("-------------------------------------");
	}

	public static void imprimirGruposFiltrados(String tipo, int minPresupuesto, int maxPresupuesto) {
		System.out.println("----------Grupos Filtrados-----------");
		App.getGruposFiltered(tipo, minPresupuesto, maxPresupuesto).forEach(System.out::println);
		System.out.println("-------------------------------------");
	}
}
