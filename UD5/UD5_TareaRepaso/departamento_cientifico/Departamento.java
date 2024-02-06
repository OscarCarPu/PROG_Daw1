package departamento_cientifico;

import java.util.Scanner;

public class Departamento {

	private String nombre;
	private int antiguedad;
	private int presupuesto;
	private Cientifico[] plantilla;
	private int num_cientificos;
	public Departamento(String nombre,int antiguedad,int presupuesto) {
		this.nombre=nombre;
		this.antiguedad=antiguedad;
		this.presupuesto=presupuesto;
		num_cientificos=0;
	}
	public String getNombre() {
		return nombre;
		
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
		
	}
	public int getAntiguedad() {
		return antiguedad;
		
	}
	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
		
	}
	public int getPresupuesto() {
		return presupuesto;
		
	}
	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
		
	}
	public Cientifico[] getPlantilla() {
		return plantilla;
		
	}
	public void setPlantilla(Cientifico[] plantilla) {
		this.plantilla = plantilla;
		
	}
	public int getNum_cientificos() {
		return num_cientificos;
		
	}
	public void setNum_cientificos(int num_cientificos) {
		this.num_cientificos = num_cientificos;
		
	}
	
	public void imprimir() {
		System.out.println("Departamento:");
		System.out.println("Nombre: "+nombre);
		System.out.println("Antigüedad: "+antiguedad);
		System.out.println("Presupuesto: "+presupuesto);
		for(int i=0;i<num_cientificos;i++) {
			System.out.println("Cientifico nº"+i);
			plantilla[i].imprimir();
		}
	}
	
	public void nuevoCientifico() {
		String nombre,apellidos,experiencia;
		int identificador;
		String nombre_inv;
		double calculos;
		System.out.println("Introduce el nombre del cientifico");
		Scanner in = new Scanner(System.in);
		nombre=in.nextLine();
		System.out.println("Introduce los apellidos del científico");
		apellidos=in.nextLine();
		System.out.println("Introduce la experiencia del cientifico");
		experiencia =in.nextLine();
		System.out.println("Introduce el identificador de su investigación");
		identificador=in.nextInt();
		System.out.println("Introduce el nombre de su investigación");
		nombre_inv=in.nextLine();
		System.out.println("Introduce los calculos de su investigación");
		calculos=in.nextDouble();
		in.close();
		Investigacion inv = new Investigacion(identificador,nombre_inv,calculos);
		Cientifico c = new Cientifico(nombre,apellidos,experiencia,0,inv);
		Cientifico [] aux= new Cientifico[num_cientificos+1];
		for(int i=0;i<num_cientificos;i++) {
			aux[i]=plantilla[i];
		}
		aux[num_cientificos]=c;
		num_cientificos++;
		plantilla=aux;
	}
	
	public void calcPresupuesto() {
		int sum_experiencia=0,sum_antiguedad=0;
		for(int i=0;i<num_cientificos;i++) {
			if(plantilla[i].getExperiencia().equals("baja"))sum_experiencia+=10;
			if(plantilla[i].getExperiencia().equals("media"))sum_experiencia+=25;
			if(plantilla[i].getExperiencia().equals("alta"))sum_experiencia+=50;
			sum_antiguedad+=plantilla[i].getAnos_trabajados();
		}
		presupuesto=num_cientificos*sum_experiencia+sum_antiguedad;
	}
	
	public void eliminarCientifico(String nombre) {
		Cientifico[] cc=new Cientifico[num_cientificos-1];
		int idx=0;
		for(int i=0;i<num_cientificos;i++) {
			if(plantilla[i].getNombre()!=nombre) {
				if(idx==num_cientificos-1)return;
				cc[idx++]=plantilla[i];
			}
		}
		plantilla=cc;
	}
	public void buscarCientifico(String nombre) {
		for(int i=0;i<num_cientificos;i++) {
			if(plantilla[i].getNombre()==nombre) {
				plantilla[i].imprimir();
			}
		}
	}
	
	public void nuevaInvestigacion() {
		Scanner in = new Scanner(System.in);
		System.out.println("Introduce el identificador, nombre y calculos de una investigación");
		int identificador = in.nextInt();
		String nombre = in.nextLine();
		double calculos = in.nextDouble();
		Investigacion inv = new Investigacion(identificador,nombre,calculos);
		System.out.println("Introduce nombres de cientificos para asignarles esta investigación, para salir imprime salir");
		String c;
		c=in.nextLine();
		while(c!="salir") {
			for(int i=0;i<num_cientificos;i++) {
				if(plantilla[i].getNombre()==c) {
					plantilla[i].setInvestigacion(inv);
					break;
				}
			}
			c=in.nextLine();
		}
		in.close();
	}
	
	public void nuevoCalculo() {
    Scanner in = new Scanner(System.in);
    System.out.println("Introduce la cadena alfanumérica de cálculos de investigaciones:");
    String cadenaCalculos = in.nextLine();

    // Split the input string into individual research calculations
    String[] investigaciones = cadenaCalculos.split("\\|");

    for (String investigacion : investigaciones) {
        // Split each research calculation into its components
        String[] partes = investigacion.split(",");
        if (partes.length == 3) {
            int identificador = Integer.parseInt(partes[0]);
            String nombre = partes[1];
            double calculos = Double.parseDouble(partes[2]);

            // Find the corresponding research by identifier
            boolean encontrado = false;
            for (int i = 0; i < num_cientificos; i++) {
                if (plantilla[i].getInvestigacion().getIdentificador() == identificador) {
                    encontrado = true;
                    plantilla[i].getInvestigacion().setCalculos(calculos);
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("Error: No se encontró una investigación con el identificador " + identificador);
            }
        } else {
            System.out.println("Error: Formato incorrecto en la cadena de cálculos.");
        }
    }

    in.close();
}
	
  public void mostrarTablaCientificos() {
    System.out.println("Tabla de Cientificos:");
    System.out.printf("%-20s%-15s%s\n", "Nombre", "Antigüedad", "Investigación");
    for (int i = 0; i < num_cientificos; i++) {
        System.out.printf("%-20s%-15d%s\n", plantilla[i].getNombre(), plantilla[i].getAnos_trabajados(),
                plantilla[i].getInvestigacion().getNombre());
    }
}
}
