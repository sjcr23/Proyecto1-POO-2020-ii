import java.util.ArrayList;
import java.util.Scanner;

public class InstitucionAutorizada {
	private String nombre;
	private ArrayList<PruebaCovid19> reporte;
	
	
	
	
	public InstitucionAutorizada(String nombre) {
		super();
		this.nombre = nombre;
		this.reporte = new ArrayList<PruebaCovid19>();
	}

	
	//LLama a la funcion que hace la prueba, con la persona escogida dentro de la funcion y si da positvo,
	//llama a la funcion que agrega esa prueba al registro de la institucion
	public void realizarPrueba(Persona persona_añadidad) {
		
		PruebaCovid19 prueba = new PruebaCovid19(persona_añadidad);
		
		prueba.setCovid19(persona_añadidad);
		System.out.println(prueba.toString());
		boolean resultado = prueba.get_resultado();
		
		if(resultado) {
			persona_añadidad.setCovid19();
			this.reportarPruebas(prueba);
		}
	}	
	
	
	//Añade una prueba al registro
	public void reportarPruebas(PruebaCovid19 prueba) {
		boolean resultado = prueba.get_resultado();
		if(resultado) {
			reporte.add(prueba);
		}	
	}
	
	
		
	public ArrayList<PruebaCovid19> get_reporte(){
		return reporte;
	}


	@Override
	public String toString() {
		String mensaje = nombre+"\n";
		for(int i = 0 ; i < reporte.size(); i++) {
			mensaje = mensaje + reporte.get(i).toString() + "\n";
			
		}
		return mensaje;
	}
	
	

}



