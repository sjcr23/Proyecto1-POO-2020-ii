import java.util.ArrayList;
//Se declara la clase Establecimiento
public class Establecimiento {
	// Atributos
	private String nombre;
	private String ubicacion;
	private String permiso;
	private int aforo;
	private ArrayList<Persona> colaboradores;
	private	ArrayList<Dia> registro;
	// Método Constructor
	public Establecimiento(String nombre, String ubicacion, String permiso, int aforo) {
		super();
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.permiso = permiso;
		this.aforo = aforo;
		this.colaboradores= new ArrayList<Persona>();
		this.registro = new ArrayList<Dia>();
	}
	
	// Llamada en el Parser para añádir los trabajadores a cada instancia de establecimiento
	public void añadirTrabajadores(String[] listaTrabajadores, ArrayList<Persona> personasTotal) {
		// Recorre la lista de trabajadores
		for(int i = 0; i<listaTrabajadores.length;i++) {
			// Declara la persona de la lista de trabajadores
			String persona = listaTrabajadores[i];
			// Recorre la lista total de personas
			for(int j = 0; j<personasTotal.size();j++) {
				// Declara la persona de la lista total de personas
				Persona personaAñadir = personasTotal.get(j);
				// Si hay match en el nombre:
				if(persona.contentEquals(personaAñadir.getNombre())){
					// Añade a 'persona' a la lsita de colaboradores
					this.colaboradores.add(personaAñadir);
					continue;
				}
			}
		}
	}
	
	// Añade una instacia de Dia al registro
	public void actualizarRegistro(Dia dia) {
		registro.add(dia);
	}
	// Método para retornar el atributo 'nombre'
	public String getNombre() {
		return nombre;
	}
	// Método para retornar el atributo 'colaboradores'
	public ArrayList<Persona> getTrabajadores(){
		return colaboradores;
	}
	// Método para retornar el atributo 'registro'
	public ArrayList<Dia> getRegistro(){
		return registro;
	}
	// Método para imprimir el registro
	public void imprimirRegistro(){
		// Recorre la lista dle registro
		for(int  i = 0 ; i<registro.size(); i++) {
			// Declara el día
			Dia diaRegistro = registro.get(i);
			// Imprime el nombre del establecimineto y la fecha del registro.
			System.out.println("Registro de clientes del establecimiento " + this.nombre + " del dia"
					+ ": " + diaRegistro.getFecha());
			// Recorre la lista de clientes
			for(int k = 0; k < diaRegistro.getClientes().size(); k++) {
				// Imprime los clientes del registro y el nombre de los clientes
				System.out.println(diaRegistro.getClientes().get(k).getNombre());
			}	
		}
	}
	
	// Se sobre escribe el método 'toString' de la clase
	@Override
	public String toString() {
		String colaboradores = "";
		for(int i = 0; i<this.colaboradores.size();i++) {
			colaboradores = colaboradores + this.colaboradores.get(i).getNombre() + ", ";
		}
		String nombre = "Nombre: " + this.nombre + "\n" + 
				 "   -Ubicacion: " + this.ubicacion + "\n" +
				 "   -Permiso: " + this.permiso + "\n" + 
				 "   -aforo: " + this.aforo + "\n" +
				 "   -colaboradores: " + colaboradores + "\n";

		return nombre;
	}
	
	
	
}
