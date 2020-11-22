import java.util.ArrayList;

public class Sistema{
	
	private ArrayList<Persona> personas;
	private ArrayList<Establecimiento> establecimientos;
	private ArrayList<Burbuja> burbujas;
	
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
	
	public ArrayList<Persona> getPersonas(){
		return personas;
	}
	

	@Override
	public String toString() {
		String mensaje;
		mensaje = establecimientos.get(0).toString();
		
		
		return mensaje;
	}
	
	

	
	
	
	

}
