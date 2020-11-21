import java.util.ArrayList;

public class Burbuja {
	
	private String id;
	private ArrayList<Persona> burbuja;
	
	public Burbuja(String id) {
		super();
		this.id = id;
		this.burbuja = new ArrayList<Persona>();
	}
	
	public void añadirPersonas(ArrayList<Persona> personasTotal){
		
		
		for(int i = 0; i<personasTotal.size();i++) {
			
			Persona personaAñadir = personasTotal.get(i);
			
			String burbujaPersonaAñadir = personaAñadir.getBurbuja();
			
			if(burbujaPersonaAñadir.contentEquals(id)) {
				burbuja.add(personaAñadir);
			}
			
		}
		
	}
	
	public String getid() {
		return id;
	}
	
	public String getArrayList(){
		String nombre = null;
		
		for(int i = 0; i<burbuja.size();i++) {
			
			nombre = nombre + burbuja.get(i).getNombre();
		}
		
		return nombre;
		
	}
	
	
}
