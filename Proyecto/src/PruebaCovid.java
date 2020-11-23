import java.time.LocalDate;

public class PruebaCovid {
	private LocalDate fecha;
	private Persona paciente;
	private boolean resultado;
	
	public PruebaCovid(Persona paciente) {
		super();
		this.fecha = LocalDate.now();
		this.paciente = paciente;
		this.resultado = resultado;
	}


	public void setCovid19(Persona paciente){
		double resultado = Math.floor(Math.random()*1);
		if(resultado == 0) {
			this.resultado = false;
		}
		else {
			this.resultado = true;
		}
	}
	
	public boolean get_resultado(){
		return resultado;
	}
}
