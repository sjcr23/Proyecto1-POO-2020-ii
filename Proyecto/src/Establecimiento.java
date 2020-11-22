import java.util.ArrayList;

public class Establecimiento {
	

	private String nombre;
	private String ubicacion;
	private String permiso;
	private int aforo;
	
	private ArrayList<Persona> trabajadores;
	private	ArrayList<Dia> registro;
	


	public Establecimiento(String nombre, String ubicacion, String permiso, int aforo) {
		super();
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.permiso = permiso;
		this.aforo = aforo;
		this.trabajadores = new ArrayList<Persona>();
		this.registro = new ArrayList<Dia>();
	}
	
	public void añadirTrabajadores(String[] listaTrabajadores, ArrayList<Persona> personasTotal) {
		for(int i = 0; i<listaTrabajadores.length;i++) {
			String persona = listaTrabajadores[i];
			for(int j = 0; j<personasTotal.size();j++) {
				
				Persona personaAñadir = personasTotal.get(j);
				
				if(persona.contentEquals(personaAñadir.getNombre())){
					this.trabajadores.add(personaAñadir);
					continue;
					
				}
			}
			
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

	@Override
	public String toString() {
		String nombre = " ";
		for (int i = 0; i<trabajadores.size();i++) {
			nombre = nombre + ", " + trabajadores.get(i).getNombre();
		}
		return nombre;
	}
	
	
	
	
}
