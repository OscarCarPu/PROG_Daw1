package parking_repaso;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Parking {

  private int numPlazas;
  private String direccion;
  private double facturado;
  final int maxPlazas = 10;
  private List<Registro> entradas;
  private List<Registro> salidas;
  private List<Vehiculo> vehiculos;
  private Map<String,Double> factVehiculos;

  public Parking(String direccion) {
    this.direccion = direccion;
    entradas = new ArrayList<>();
    salidas = new ArrayList<>();
    factVehiculos= new HashMap<>();
    this.facturado = 0;
    numPlazas = 0;
  }

  public void entrada(String hora, Vehiculo vehiculo) throws ParkingException{
	if(numPlazas+vehiculo.getPlazas()>maxPlazas) {
		throw new ParkingException();
	}
    entradas.add(new Registro(hora, vehiculo));
    vehiculos.add(vehiculo);
    numPlazas += vehiculo.getPlazas();
  }

  public void salir(String hora, Vehiculo vehiculo) {
    Registro r = this.getLastEntrada(vehiculo);
    vehiculos.remove(vehiculo);
    numPlazas-=vehiculo.getPlazas();
    double horas = this.diferencia(hora, r.getHora());
    if(factVehiculos.containsKey(vehiculo.getMatricula())) {
    	factVehiculos.replace(hora, factVehiculos.get(vehiculo.getMatricula())+horas*1.5);
    }
    else {
    	factVehiculos.put(hora, horas*1.5);
    }
    facturado += horas * 1.5;
    salidas.add(new Registro(hora,vehiculo));
  }

  public Registro getLastEntrada(Vehiculo vehiculo) {
	    return entradas.stream()
	            .filter(a -> a.getVehiculo().getMatricula().equals(vehiculo.getMatricula()))
	            .reduce((first, second) -> second)
	            .orElse(null);
	}
  
  public double diferencia(String hora1,String hora2) {
	  String hr1[] = hora1.split(":");
	  String hr2[] = hora2.split(":");
	  int h1 = Integer.parseInt(hr1[0]);
	  int m1 = Integer.parseInt(hr1[1]);
	  int s1 = Integer.parseInt(hr1[2]);
	  int h2 = Integer.parseInt(hr2[0]);
	  int m2 = Integer.parseInt(hr2[1]);
	  int s2 = Integer.parseInt(hr2[2]);
	  int segDiff = (h1-h2)*3600+(m1-m2)*60+(s1-s2);
	  return (double)segDiff/3600;
  }
  
  public List<Vehiculo> getVehiculosParking(){
	  return this.vehiculos;
  }
  
  public int plazasLibres() {
	  return maxPlazas-numPlazas;
  }

  public void generarResumen() throws IOException {
	  try(PrintWriter w = new PrintWriter(new FileWriter(".\\parking_repaso\\historico.txt"))){
		  Iterator<Registro> itEntradas = entradas.iterator();
		  Iterator<Registro> itSalidas = salidas.iterator();
		  Registro currEntrada = null;
		  Registro currSalida = null;
		  while(itEntradas.hasNext() || itSalidas.hasNext()) {
			  if(currEntrada == null && itEntradas.hasNext()) {
				  currEntrada = itEntradas.next();
			  }
			  if(currSalida == null && itSalidas.hasNext()) {
				  currSalida = itSalidas.next();
			  }
			  
			  if(currEntrada != null && currSalida != null) {
				  if(this.diferencia(currEntrada.getHora(), currSalida.getHora())<=0) {
					  w.println("Entrada "+currEntrada.getHora()+" "+currEntrada.getVehiculo().getMatricula());
					  currEntrada = itEntradas.next();
				  }
				  else {
					  w.println("Salida "+currSalida.getHora()+" "+currSalida.getVehiculo().getMatricula());
					  currSalida = itSalidas.next();
				  }
			  } else if(currEntrada != null) {
				  w.println("Entrada "+currEntrada.getHora()+" "+currEntrada.getVehiculo().getMatricula());
				  currEntrada = itEntradas.next();
			  } else if(currSalida != null) {
				  w.println("Salida "+currSalida.getHora()+" "+currSalida.getVehiculo().getMatricula());
				  currSalida = itSalidas.next();
			  }
		  }
	  }
  }
  
  public void generarFacturacion() throws IOException {
	  String dia = (new SimpleDateFormat("EEEE")).format(new Date());
	  try(PrintWriter w = new PrintWriter(new FileWriter(".\\parking_repaso\\"+dia+"_facturacion.txt"))){
		  w.println("Facturación del "+dia+": "+facturado);
		  for(Map.Entry<String,Double> e : factVehiculos.entrySet()) {
			  w.println("Facturación m:"+e.getKey()+" "+e.getValue());
		  }
	  }
  }
}
