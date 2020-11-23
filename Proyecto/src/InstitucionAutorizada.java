import java.util.ArrayList;

public class InstitucionAutorizada {
	private String nombre;
	private ArrayList<PruebaCovid> reporte;
	
	
	public InstitucionAutorizada(String nombre) {
		super();
		this.nombre = nombre;
		this.reporte = new ArrayList<PruebaCovid>();
	}
	
	public void añadirPruebas(ArrayList<PruebaCovid> reporte, ArrayList<Persona> personasTotal) {
		for(int i = 0; i < personasTotal.size(); i += 5) {
			Persona	persona_añadida = personasTotal.get(i);
			PruebaCovid prueba = new PruebaCovid(persona_añadida);
			prueba.setCovid19(persona_añadida);
			boolean resultado = prueba.get_resultado();
			
			if(resultado == true) {
				persona_añadida.setCovid19();
				reporte.add(prueba);
				
			}
			
			else {
				continue;
			}
		}
	}
		
	public ArrayList<PruebaCovid> get_reporte(){
		return reporte;
	}

}



