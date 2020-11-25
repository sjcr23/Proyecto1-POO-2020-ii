import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Sistema{
	
	private ArrayList<Persona> personas;
	private ArrayList<Establecimiento> establecimientos;
	private ArrayList<Burbuja> burbujas;
	private Dia DiaActual;

	
	public Sistema() {
		super();
		this.personas = new ArrayList<Persona>();
		this.establecimientos = new ArrayList<Establecimiento>();
		this.burbujas = new ArrayList<Burbuja>();
	}
	


	
	public void añadirPersonas(Persona nuevaPersona) {
		personas.add(nuevaPersona);
		
	}
	
	public void añadirEstablecimiento(Establecimiento nuevoEstablecimiento) {
		establecimientos.add(nuevoEstablecimiento);
	}
	
	public void añadirBurbuja(Burbuja nuevaBurbuja) {
		burbujas.add(nuevaBurbuja);
	}
	public void setDia(Dia dia) {
		this.DiaActual = dia;
		
	}
	public ArrayList<Persona> getPersonas(){
		return personas;
	}
	
	public ArrayList<Establecimiento> getEstablecimientos(){
		return establecimientos;
	}

	public ArrayList<Burbuja> getBurbujas(){
		return burbujas;
	}

	
	@Override
	public String toString() {
		String mensaje;
		mensaje = establecimientos.get(2).toString();
		
		
		return mensaje;
	}
	
	

	
	
	
	

}
