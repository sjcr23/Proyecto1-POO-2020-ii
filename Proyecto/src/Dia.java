import java.time.LocalDate;
import java.util.ArrayList;


public class Dia {
	
	private LocalDate fecha;
	private ArrayList<Persona> clientes;
	
	public Dia(ArrayList<Persona> clientes) {
		super();
		this.fecha = LocalDate.now();
		this.clientes = clientes;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	public ArrayList<Persona> getClientes(){
		return clientes;
	}
	
	
	
	
	
	

}
