import java.util.ArrayList;
import java.util.Scanner;
//Se declara la clase InstitucionAutorizada
public class InstitucionAutorizada {
	// Atributos
	private String nombre;
	private ArrayList<PruebaCovid19> reporte;
	// Método constructor
	public InstitucionAutorizada(String nombre) {
		super();
		this.nombre = nombre;
		this.reporte = new ArrayList<PruebaCovid19>();
	}
	
	public void realizarPrueba(Persona persona_añadidad) {
		// Declara una nueva instancia de PrubeaCovid19
		PruebaCovid19 prueba = new PruebaCovid19(persona_añadidad);
		// Hace que la persona se haga la prueba
		prueba.setCovid19(persona_añadidad);
		// Imprime el resultado
		System.out.println(prueba.toString());
		// Se declara 'resultado' el resultado de la prueba
		boolean resultado = prueba.get_resultado();
		// Si el resultado es positivo
		if(resultado) {
			// Declaramos que la persona tiene covid
			persona_añadidad.setCovid19();
			// Se reporta la prueba
			this.reportarPruebas(prueba);
		}
	}	
	// Añade una prueba al registro
	public void reportarPruebas(PruebaCovid19 prueba) {
		// Se declara 'resultado' el resultado de la prueba
		boolean resultado = prueba.get_resultado();
		// Si el resultado es positivo
		if(resultado) {
			// Se añade la prueba al reporte
			reporte.add(prueba);
		}	
	}
	// Método que retorna el atributo 'reporte'
	public ArrayList<PruebaCovid19> get_reporte(){
		return reporte;
	}
	
	// Se sobre escribe el método 'toString' de la clase
	@Override
	public String toString() {
		// Si el reporte está vacío no hay pruebas positivas
		if(reporte.size() == 0) {
			return "La institucion " + this.nombre + " no tiene registro de haber realizado pruebas covid o no hay pruebas positivas";
		}
		// Imprime el nombre de la Institución
		String mensaje = this.nombre+"\n";
		// Recorre la lista de reportes
		for(int i = 0 ; i < reporte.size(); i++) {
			// Concatena los resultados de las pruebas Covid19
			mensaje = mensaje + reporte.get(i).toString() + "\n";
		}
		return mensaje;
	}
}