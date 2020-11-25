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
	public void realizarPrueba(Sistema sistema, ArrayList<Persona> personas, ArrayList<Establecimiento> establecimientos, 
			ArrayList<Burbuja> burbujas) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("A que persona se le hará la prubeas?\n");
		int opcion = scanner.nextInt() -1;
		Persona	persona_añadida = personas.get(opcion);
		PruebaCovid19 prueba = new PruebaCovid19(persona_añadida);
		
		prueba.setCovid19(persona_añadida);
		
		boolean resultado = prueba.get_resultado();
		
		if(resultado) {
			persona_añadida.setCovid19();
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

}



