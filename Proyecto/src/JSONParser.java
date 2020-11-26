import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

//Declaración de la clase 'JSONParser'
public class JSONParser {
	// Declaración de variables
	private File filePersonas;
	private File fileEstablecimientos;
	private ObjectMapper mapper;
	private JsonNode nodoPersonas;
	private JsonNode nodoEstablecimientos;

	// Método consturctor
	public JSONParser() {
		// Se declara que el archivo de personas va ser 'personas.json'
		filePersonas = new File("resources/personas.json");
		// Se declara que el archivo de establecimientos va ser 'establecimientos.json'
		fileEstablecimientos = new File("resources/establecimientos.json");
		// Se crea una instancia de ObjectMapper.
		mapper = new ObjectMapper();
		
		// Esto es el try-catch
		try {
			nodoPersonas = mapper.readTree(filePersonas);
			nodoEstablecimientos = mapper.readTree(fileEstablecimientos);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	// Método para generar los datos del sistema. (rellenar los arrays)
	public Sistema generarDatos() {
		// Lista con las burbujas que se van a añadir 
		ArrayList<String> burbujasAñadir = new ArrayList<String>();			
		// Se crea una instancia de Sistema
		Sistema sistema = new Sistema();
		// Se declara la lista de personas que va usar del '.json'
		ArrayNode personas = (ArrayNode) nodoPersonas.get("personas");
		
		//=========================== Personas ===========================//
		
		// Se verifica que hayan personas
		if(personas!=null) {
			// Itera por las personas del .json
			for(int i = 0;i<personas.size();i++) {
				// Se declara la persona actual
				JsonNode persona = personas.get(i);
				// Recoje los atributos del .json (todos strings)
				String id = persona.get("id").asText();
				String telefono = persona.get("telefono").asText();
				String fechaNacimiento = persona.get("fechaNacimiento").asText();
				String nombre = persona.get("nombre").asText();
				String tipo = persona.get("tipo").asText();
				String correo = persona.get("correo").asText();
				// Con este id se va crear la lista de las burbujas
				String burbujaId = persona.get("burbujaId").asText();
				
				// Si la lista con las burbujas esta vacia, se añade
				if(burbujasAñadir.isEmpty()) {
					burbujasAñadir.add(burbujaId);
				}
				
				else {
					//recorre la lista de burbujas
					for(int k = 0; k<burbujasAñadir.size();k++) {
						/*  Si el id ya esta en la lista, entonces no es necesario agragarlo.
						 *  Porque la clase Burbuja se encarga de añadir a las personas de esa
						 *  burbuja, entonces solo habrá una instanica por burbuja social.
						 */
						if(burbujasAñadir.get(k).contentEquals(burbujaId)) {
							break;
						}
						
						// Si es el úlitmo y no hubieron coincidencias se añade
						if(k == burbujasAñadir.size() -1 ) {
							burbujasAñadir.add(burbujaId);
						}
					}
				}
				// Continua con la creacion de Personas 
				String genero = persona.get("genero").asText();
				// Crea una nueva instancia con los datos recojidos
				Persona nuevaPersona = new Persona(nombre, id, telefono, fechaNacimiento, tipo, correo, burbujaId, genero );
				// Añade la persona a la lista de personas
				sistema.añadirPersonas(nuevaPersona);
			}
		}
	
		// Recorre la lista de las burbujas a crear
		for(int j = 0; j<burbujasAñadir.size();j++) {
			// Crea la burbujas con ese id
			Burbuja nuevaBurbuja = new Burbuja(burbujasAñadir.get(j));
			// Método que se encarga de rellenarlas con la lista de todas las personas
			nuevaBurbuja.añadirPersonas(sistema.getPersonas());
			// Añade la burbuja a la lista de burbujas del sistema
			sistema.añadirBurbuja(nuevaBurbuja);
		}
		
		//=========================== Establecimientos ===========================//
		// Se declara la lista de establecimientos que va usar del '.json'
		ArrayNode establecimientos = (ArrayNode) nodoEstablecimientos.get("establecimientos");
		// Se verifica que hayan establecimientos
		if(establecimientos!= null) {
			// Itera por las establecimientos del .json
			for(int i = 0; i<establecimientos.size();i++) {
				// Se declara el establecimiento actual
				JsonNode establecimiento = establecimientos.get(i);
				// Recoje los atributos del .json
				String nombre = establecimiento.get("nombre").asText();
				String ubicacion = establecimiento.get("ubicacion").asText();
				String permiso = establecimiento.get("permiso").asText();
				int aforo = establecimiento.get("aforo").asInt();
				ArrayNode listaColaboradoresJSON = (ArrayNode) establecimiento.get("colaboradores");
				// Verifica que el array de colaboradores exista
				if(listaColaboradoresJSON != null) {
					// Crea un array del mismo tamaño del array de colaboradores del Parser
					String[] listaColaboradores = new String[listaColaboradoresJSON.size()];
					// Recorre el array de colaboradores del Parser
					for(int j = 0; j<listaColaboradoresJSON.size(); j++) {
						listaColaboradores[j] = listaColaboradoresJSON.get(j).asText();
					}
					// Crea una nueva instancia con los datos recojidos
					Establecimiento nuevoEstablecimiento = new Establecimiento(nombre,ubicacion,permiso,aforo);
					// Método que se encarga de rellenar el atributo 'colaboradores'
					nuevoEstablecimiento.añadirTrabajadores(listaColaboradores, sistema.getPersonas());
					// Añade el establecimiento a la lista de personas
					sistema.añadirEstablecimiento(nuevoEstablecimiento);	
				}	
			}
		}
		return sistema;		
	}
}
