import java.time.LocalDate;
import java.util.Random;

public class PruebaCovid19 {
	private LocalDate fecha;
	private Persona paciente;
	private boolean resultado;
	
	public PruebaCovid19(Persona paciente) {
		super();
		this.fecha = LocalDate.now();
		this.paciente = paciente;

	}


	//Genera resultado random de una prueba de covid
	public void setCovid19(Persona paciente){
		Random r = new Random();
		
		boolean resultado = r.nextBoolean();
		if(resultado) {
			this.resultado = true;
		}
		else {
			this.resultado = false;
		}
	}
	
	public boolean get_resultado(){
		return resultado;
	}


	@Override
	public String toString() {
		return "PruebaCovid19 {Fecha: " + fecha + ", Paciente: " + paciente.getNombre() + ", Tipo: " + paciente.getTipo() + ", Resultado: " + resultado + "}\n";
	}
	
	
}