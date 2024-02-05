package exercise6.ordenador;

public class Ordenador {
    private static int cont = 0;
    private Procesador p;
    private Memoria m;
    private DiscoDuro d;
    private int pvp;
    private String numeroDeSerie;

    public Ordenador(String numeroDeSerie, int m_capacidad, String m_tipo, int m_velocidad, float d_capacidad,
            String d_tipo, int d_velocidad, String p_modelo, float p_velocidad, int precio) throws OrdenadorException {
        if (p_modelo.equals("I7") && !d_tipo.equals("SATA3")) {
            throw new OrdenadorException(numeroDeSerie, "Cannot configure an I7 processor without a SATA3 disk");
        }
        if (numeroDeSerie.startsWith("HP") && m_capacidad < 4) {
            throw new OrdenadorException(numeroDeSerie, "HP series number cannot have less than 4GB of RAM");
        }
        this.numeroDeSerie = numeroDeSerie;
        m = new Memoria(m_capacidad, m_tipo, m_velocidad);
        d = new DiscoDuro(d_capacidad, d_tipo, d_velocidad);
        p = new Procesador(p_modelo, p_velocidad);
        pvp = precio;
        cont++;
    }

    public int getCapacidadMemoria() {
        return m.getCapacidad();
    }

    @Override
    public String toString() {
        return " " + p + m + d + " pvp:" + pvp;
    }

}
