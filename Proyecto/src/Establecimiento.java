import java.util.ArrayList;

public class Establecimiento {
	

	private String nombre;
	private ArrayList<Persona> trabajadores;
	private	ArrayList<Dia> registro;
	
	public Establecimiento(String nombre, ArrayList<Persona> trabajadores, ArrayList<Dia> registro) {
		super();
		this.nombre = nombre;
		this.trabajadores = trabajadores;
		this.registro = registro;
	}
	
	
	
	public String getNombre() {
		return nombre;
	}
	
	public ArrayList<Persona> getTrabajadores(){
		return trabajadores;
	}
	
	public ArrayList<Dia> getRegistro(){
		return registro;
	}
	
	
}
