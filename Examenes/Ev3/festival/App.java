package festival;

import java.util.List;

public class App {

	private static Festival festival;
	private static List<Grupo> grupos;

	public static void initFestival() throws Exception {
		festival = DB.getFestival();
	}

	public static void initGrupos() throws Exception {
		grupos = DB.getGrupos();
	}

	public static Festival getFestival() {
		return festival;
	}

	public static List<Grupo> getGrupos() {
		return grupos;
	}

	public static boolean hasGrupo(String nombre) throws Exception {
		return grupos.contains(new Grupo(nombre, 0, "Pop"));
	}

	public static void deleteGrupo(String nombre) throws Exception {
		DB.deleteGrupo(nombre);
		initGrupos();
		initFestival();
	}

	public static void actualizarCache(String nombre, int cache) throws Exception {
		DB.actualizarCache(nombre, cache);
		initGrupos();
		initFestival();
	}

	public static List<Grupo> getGruposFiltered(String tipo, int minPresupuesto, int maxPresupuesto) {
		return grupos.stream().filter(g -> g.getTipoMusica().equals(tipo)).filter(g -> g.getCache() >= minPresupuesto)
				.filter(g -> g.getCache() <= maxPresupuesto).toList();
	}

	public static Grupo getGrupoMasCaro(String tipo) {
		return grupos.stream().filter(g -> g.getTipoMusica().equals(tipo))
				.max((g1, g2) -> g1.getCache() - g2.getCache()).get();
	}

}
