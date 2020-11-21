import java.util.ArrayList;

public class Sistema{
	
	private ArrayList<Persona> personas;
	private ArrayList<Establecimiento> establecimientos;
	private ArrayList<Burbuja> burbujas;
	
	public Sistema(ArrayList<Persona> personas, ArrayList<Establecimiento> establecimientos,
			ArrayList<Burbuja> burbujas) {
		super();
		this.personas = personas;
		this.establecimientos = establecimientos;
		this.burbujas = burbujas;
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
		mensaje = "personas";
		
		for(int i = 0; i<burbujas.size(); i++) {
			
			mensaje = mensaje + "\n" + burbujas.get(i).getArrayList();
		
		}
		return mensaje;
	}
	
	

	
	
	
	

}
