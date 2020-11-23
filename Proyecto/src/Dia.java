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
	
	
	public ArrayList<Persona>  setCliente(Persona cliente) {
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
