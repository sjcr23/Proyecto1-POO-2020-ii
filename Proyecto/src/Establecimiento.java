import java.util.ArrayList;

public class Establecimiento {
	
	private String nombre;
	private String ubicacion;
	private String permiso;
	private int aforo;
	private ArrayList<Persona> colaboradores;
	private	ArrayList<Dia> registro;

	public Establecimiento(String nombre, String ubicacion, String permiso, int aforo) {
		super();
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.permiso = permiso;
		this.aforo = aforo;
		this.colaboradores= new ArrayList<Persona>();
		this.registro = new ArrayList<Dia>();
	}
	
	
	//Llamada en el Parser para añádir los trabajadores a cada instancia de establecimiento
	public void añadirTrabajadores(String[] listaTrabajadores, ArrayList<Persona> personasTotal) {
		for(int i = 0; i<listaTrabajadores.length;i++) {
			String persona = listaTrabajadores[i];
			for(int j = 0; j<personasTotal.size();j++) {
				
				Persona personaAñadir = personasTotal.get(j);
				
				if(persona.contentEquals(personaAñadir.getNombre())){
					this.colaboradores.add(personaAñadir);
					continue;
					
				}
			}
			
		}
	}
	
	
	//Añade una instacia de Dia al registro
	public void actualizarRegistro(Dia dia) {
		registro.add(dia);
	}
	
	
	
	
	public String getNombre() {
		return nombre;
	}
	
	public ArrayList<Persona> getTrabajadores(){
		return colaboradores;
	}
	
	public ArrayList<Dia> getRegistro(){
		return registro;
	}

	@Override
	public String toString() {
		String nombre = " ";
		for (int i = 0; i<registro.size();i++) {
			nombre = nombre  + registro.get(i).toString() + ", ";
		}
		return nombre;
	}
	
	
	
}
