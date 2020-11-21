import java.util.ArrayList;

public class Establecimiento {
	

	private String nombre;
	private String ubicacion;
	private String permiso;
	private int aforo;
	
	private ArrayList<Persona> trabajadores;
	private	ArrayList<Dia> registro;
	


	public Establecimiento(String nombre, String ubicacion, String permiso, int aforo, ArrayList<Persona> trabajadores,
			ArrayList<Dia> registro) {
		super();
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.permiso = permiso;
		this.aforo = aforo;
		this.trabajadores = trabajadores;
		this.registro = registro;
	}
	
	public void añadirTrabajadores(String[] listaTrabajadores, ArrayList<Persona> personasTotal) {
		for(int i = 0; i<listaTrabajadores.length;i++) {
			
			
			
			
			if(personaAñadir.g)
		}
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
