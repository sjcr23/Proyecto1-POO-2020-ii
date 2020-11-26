import java.time.LocalDate;
import java.util.Random;
// Se declara la clase PruebaCovid19
public class PruebaCovid19 {
	// Atributos
	private LocalDate fecha;
	private Persona paciente;
	private boolean resultado;
	// Método Constructor
	public PruebaCovid19(Persona paciente) {
		super();
		this.fecha = LocalDate.now();
		this.paciente = paciente;
	}
	// Genera resultado random de una prueba de covid
	public void setCovid19(Persona paciente){
		// Declara 'r' como un random
		Random r = new Random();
		// Delara resultado como un booleano random
		boolean resultado = r.nextBoolean();
		
		// Asigna el booleano el resultado
		
		if(resultado) {
			this.resultado = true;
		}
		
		else {
			this.resultado = false;
		}
	}
	
	// Método para retornar el atributo 'resultado'
	public boolean get_resultado(){
		return resultado;
	}

	// Se sobre escribe el método 'toString' de la clase
	@Override
	public String toString() {
		return "PruebaCovid19 {Fecha: " + fecha + ", Paciente: " + paciente.getNombre() + ", Tipo: " + paciente.getTipo() + ", Resultado: " + resultado + "}\n";
	}
}