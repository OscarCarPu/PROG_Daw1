package pokemon;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		EntrenadorPokemon ash = new EntrenadorPokemon("ash");
		Scanner in = new Scanner(System.in);
		int contPokemons[][] = new int[5][4];
		for(int i=0;i<5;i++) {
			EntrenadorPokemon p = new EntrenadorPokemon("a");
			p.crearEquipo();
			for(int j=0;j<5;j++) {
				if(p.equipo[j].nombre.equals("Squirtle")) {
					contPokemons[i][0]++;
				}
				if(p.equipo[j].nombre.equals("Charmander")) {
					contPokemons[i][1]++;
				}
				if(p.equipo[j].nombre.equals("Bulbasaur")) {
					contPokemons[i][2]++;
				}
				if(p.equipo[j].nombre.equals("Pikachu")) {
					contPokemons[i][3]++;
				}
			}
		}
		do {
			System.out.println("Selecciona una opción (1-7)");
			System.out.println("1 - crearEquipo");
			System.out.println("2 - agregarPokemon");
			System.out.println("3 - eliminarPokemon por posición");
			System.out.println("4 - eliminarPokemon por nombre");
			System.out.println("5 - asignarPokemonFusion");
			System.out.println("6 - mostrarEquipo");
			System.out.println("7 - Resumen Equipos");
			int opc=in.nextInt();
			switch(opc) {
				case 1:
					ash.crearEquipo();
					break;
				case 2:
					Pokemon p = new Pokemon();
					ash.agregarPokemon(p);
					break;
				case 3:
					System.out.println("Introduce posición:");
					int po = in.nextInt();
					ash.eliminarPokemon(po);
					break;
				case 4:
					System.out.println("Introduce nombre:");
					String a = in.next();
					ash.eliminarPokemon(a);
					break;
				case 5:
					ash.asignarPokemonfusion();
					break;
				case 6:
					ash.mostrarEquipo();
					break;
				case 7:
					for(int i=0;i<5;i++) {
						System.out.println("El enemigo nº"+(i+1)+" tiene "+contPokemons[i][0]+" Squirtles, "+contPokemons[i][1]+" Charmanders "+contPokemons[i][2]+" Bulbasaurs y "+contPokemons[i][3]+" Pikachus.");
					}
					break;
				default:break;
			}
			System.out.println("Operación terminada");
		}while(true);
	}
}
