import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;


public class JSONParser {
	
	private File filePersonas;
	private File fileEstablecimientos;
	
	private ObjectMapper mapper;
	private JsonNode nodoPersonas;
	private JsonNode nodoEstablecimientos;

	
	public JSONParser() {
		filePersonas = new File("resources/personas.json");
		mapper = new ObjectMapper();
		
		try {
			nodoPersonas = mapper.readTree(filePersonas);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
		
	public Sistema generarDatos() {
		//Parámetros para crear la instancia de sistema (todo comienza vació)
		ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
		ArrayList<Establecimiento> listaEstablecimientos = new ArrayList<Establecimiento>();
		ArrayList<Burbuja> listaBurbujas = new ArrayList<Burbuja>();
		
		//Lista con las burbujas que se van a añadir 
		ArrayList<String> burbujasAñadir = new ArrayList<String>();			
			
		Sistema sistema = new Sistema(listaPersonas, listaEstablecimientos, listaBurbujas);
		ArrayNode personas = (ArrayNode) nodoPersonas.get("personas");
		
		//Itera por las personas del jason
		if(personas!=null) {
				
			for(int i = 0;i<personas.size();i++) {
				//Persona actual
				JsonNode persona = personas.get(i);
					
				String id = persona.get("id").asText();
				String telefono = persona.get("telefono").asText();
				String fechaNacimiento = persona.get("fechaNacimiento").asText();
				String nombre = persona.get("nombre").asText();
				String tipo = persona.get("tipo").asText();
				String correo = persona.get("correo").asText();
				
				//Con este id verificaremos modificaremos la lista de las burbujas a crear
				String burbujaId = persona.get("burbujaId").asText();
				
				//Si la lista con las burbujas esta vacia, se añade
				if(burbujasAñadir.isEmpty()) {
					burbujasAñadir.add(burbujaId);
				}
				
				else {
					//recorre la lista de burbujas
					for(int k = 0; k<burbujasAñadir.size();k++) {
						//Si el id ya esta en la lista, entonces no es necesario agragarlo, porque la clase Burbuja se encarga de añadir a las
						//personas de esa burbuja, entonces solo habrá una instanica por burbuja social
						if(burbujasAñadir.get(k).contentEquals(burbujaId)) {
							break;
						}
						
						//Si es el úlitmo y no hubieron coincidencias se añade
						if(k == burbujasAñadir.size() -1 ) {
							burbujasAñadir.add(burbujaId);
						}
							
					}
				}
				
				//Continua con la creacion de Personas 
				
				String genero = persona.get("genero").asText();
					
				Persona nuevaPersona = new Persona(nombre, id, telefono, fechaNacimiento, tipo, correo, burbujaId, genero );
				sistema.añadirPersonas(nuevaPersona);
			}
			
		}
		
		//Recorre la lista de las burbujas a crear
		for(int j = 0; j<burbujasAñadir.size();j++) {
			//Crea la burbujas con ese id
			Burbuja nuevaBurbuja = new Burbuja(burbujasAñadir.get(j));
			
			//Metodo que se encarga de rellenarlas con la lista de todas las personas
			nuevaBurbuja.añadirPersonas(sistema.getPersonas());
			
			//añade la burbuja a la lista de burbujas del sistema
			sistema.añadirBurbuja(nuevaBurbuja);
		}
		
		return sistema;
				
			
	}
		
		
		
		
		

	


}
