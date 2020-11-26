import java.time.LocalDate;
import java.util.ArrayList;
//Se declara la clase Dia
public class Dia {
	// Atributos
	private LocalDate fecha;
	private ArrayList<Persona> clientes;
	// Método Constructor
	public Dia() {
		super();
		this.fecha = LocalDate.now();
		this.clientes = new ArrayList<Persona>();
	}
	// Método para retornar el atributo 'fecha'
	public LocalDate getFecha() {
		return fecha;
	}
	// Método para retornar el atributo 'clientes'
	public ArrayList<Persona> getClientes(){
		return clientes;
	}
	
	public ArrayList<Persona>  añadirCliente(Persona cliente) {
		// Añade la persona a la lista de clientes, que estará incluida en la lista de dias del registro del establecimiento
		this.clientes.add(cliente);
		// Retorna la lista de clientes
		return clientes;
	}
	
	// Se sobre escribe el método 'toString' de la clase
	@Override
	public String toString() {
		// Declara nombre como string vacío
		String nombre = " ";
		// Recorre la lista del cliente
		for(int i = 0; i<clientes.size();i++) {
			// Concatena el nombre del cliente
			nombre = nombre + ", " + clientes.get(i).getNombre();
		}
		return nombre;
	}
}