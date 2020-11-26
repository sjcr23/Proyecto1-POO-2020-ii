import java.util.ArrayList;
// Declaración de la Clase Burbuja
public class Burbuja {
	// Atributos
	private String id;
	private ArrayList<Persona> burbuja;
	// Método constructor
	public Burbuja(String id) {
		super();
		this.id = id;
		this.burbuja = new ArrayList<Persona>();
	}
	
	
	// Llamada en el parser para añadir instancias de personas al arreglo
	public void añadirPersonas(ArrayList<Persona> personasTotal){
		
		// Recorre todas la spersonas
		for(int i = 0; i<personasTotal.size();i++) {
			// Declara la persona a añadir
			Persona personaAñadir = personasTotal.get(i);
			// Declara la burbuja a añadir
			String burbujaPersonaAñadir = personaAñadir.getBurbuja();
			// Si hay correspondencia entre el id de la burbuja de la persona y el nombre de la burbuja: 
			if(burbujaPersonaAñadir.contentEquals(id)) {
				// Añade la persona a la burbuja
				burbuja.add(personaAñadir);
			}	
		}
	}
	
	// Método que devuelve el ArrayList del atributo 
	public ArrayList<Persona> getPeronas(){
		return burbuja;
	}
	// Método que devuelve el ArrayList del atributo 'id'
	public String getid() {
		return id;
	}
	// Se sobre escribe el método 'toString' de la clase
	@Override
	public String toString() {
		// Guarda en nombre "Burbuja : [id de la burbuja]"
		String nombre = "Burbuja :" + this.id + "\n";
		// Se recorre la lista de burbujas.
		for(int i = 0; i < burbuja.size(); i++) {
			// Se sobre escribe nombre
			nombre = nombre + "     " + burbuja.get(i).getNombre()  + "\n";
		}
		return nombre;
	}
}