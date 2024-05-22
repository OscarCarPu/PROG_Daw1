package festival;

import java.util.Map;

public class Slot {
	private char dia;
	private int franja;
	private Grupo grupo;
	private final static Map<Integer, String> horas = Map.of(1, "18:00", 2, "19:00", 3, "20:30", 4, "21:30", 5, "23:00",
			6, "24:30");

	public Slot(char dia, int franja, Grupo grupo) throws Exception {
		setDia(dia);
		setFranja(franja);
		setGrupo(grupo);
	}

	public void setDia(char dia) throws Exception {
		if (dia != 'V' && dia != 'S')
			throw new Exception("Dia incorrecto");
		this.dia = dia;
	}

	public void setFranja(int franja) throws Exception {
		if (franja < 1 || franja > 6)
			throw new Exception("Franja incorrecta");
		this.franja = franja;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public char getDia() {
		return dia;
	}

	public int getFranja() {
		return franja;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public String getFranjaFormated() {
		return horas.get(franja);
	}

	public String getDiaCompleto() {
		if (dia == 'V')
			return "Viernes";
		return "Sábado";
	}

	public String toString() {
		String ret = getDiaCompleto() + " - " + getFranjaFormated() + ":\t" + (getDia() == 'S' ? "\t" : "");
		ret += grupo.toStringReduced();
		return ret;
	}
}
