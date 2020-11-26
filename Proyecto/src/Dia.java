import java.time.LocalDate;
import java.util.ArrayList;


public class Dia {
	
	private LocalDate fecha;
	private ArrayList<Persona> clientes;
	
	public Dia() {
		super();
		this.fecha = LocalDate.now();
		this.clientes = new ArrayList<Persona>();
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	public ArrayList<Persona> getClientes(){
		return clientes;
	}
	
	
	
	//Llamada en la funcion de persona de visitarEstablecimiento
	//Añade la persona la la lista de clientes, que estará incluida la lista de dias del registro del establecimiento
	public ArrayList<Persona>  añadirCliente(Persona cliente) {
		this.clientes.add(cliente);
		return clientes;
	}

	@Override
	public String toString() {
		String nombre = " ";
		for(int i = 0; i<clientes.size();i++) {
			
			nombre = nombre + ", " + clientes.get(i).getNombre();
		}
		
		return nombre;
		
	}
	
	
	
	

}
