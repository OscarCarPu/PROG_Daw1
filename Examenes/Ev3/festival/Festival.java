package festival;

import java.util.List;
import java.util.stream.Collectors;

public class Festival {
	private final static int AFORO_MAXIMO = 30000;
	private String nombre;
	private String tipo;
	private int aforo;
	private int presupuesto;
	private List<Slot> slots;

	public Festival(String nombre, int tipo, int aforo, int presupuesto, List<Slot> slots) throws Exception {
		setNombre(nombre);
		setTipoWNum(tipo);
		setAforo(aforo);
		setPresupuesto(presupuesto);
		setSlots(slots);
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setTipo(String tipo) {

		this.tipo = tipo;
	}

	public void setTipoWNum(int tipo) {
		if (tipo == 0)
			this.tipo = "Indoor";
		else
			this.tipo = "Exterior";
	}

	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getTipo() {
		return this.tipo;
	}

	public int getPresupuesto() {
		return this.presupuesto;
	}

	public List<Slot> getSlots() {
		return slots;
	}

	public void setSlots(List<Slot> slots) {
		this.slots = slots;
	}

	public void setAforo(int aforo) throws Exception {
		if (aforo > AFORO_MAXIMO) {
			throw new Exception("Aforo máximo excedido");
		}
		this.aforo = aforo;
	}

	public int getAforo() {
		return this.aforo;
	}

	public String toString() {
		String ret = "--------------Festival---------------\n";
		ret += "Nombre:\t\t" + nombre + "\n" + "Aforo:\t\t" + aforo + "\n" + "Tipo:\t\t" + tipo + "\n"
				+ "Presupuesto:\t" + presupuesto + " €\n";
		ret += "--------------Artistas---------------\n";
		ret += slots.stream().map(s -> s.toString()).collect(Collectors.joining("\n"));
		ret += "\n-------------------------------------";
		return ret;
	}
}
