
//Declaración de la clase hija 'Notificacion_contacto' que extiende de 'Notificación'
public class Notificacion_contacto extends Notificacion{
	
	//Atributos
	private Dia registro_dia;

	//Constructor
	public Notificacion_contacto(Dia diaActual, Persona paciente) {
		
		//Constructor de la clase madre
		super(paciente);
		
		this.registro_dia = diaActual;
	}

	
	//Genera el mensaje de Notificacion_contacto
	public void setMensaje() {
		//Variables
		String destinatarios = "";
		
		//Recorre el átributo 'Registro' para encontrar los destinatarios del mensaje
		for(int i = 0; i < registro_dia.getClientes().size(); i++) {
			
			//Si encuentra al contagiado no lo agrega a los destinatarios
			if(registro_dia.getClientes().get(i) == this.paciente) {
				continue;
			}
			
			//Genera el mensaje para cada destinatario
			destinatarios = destinatarios + "Para: " + registro_dia.getClientes().get(i).getNombre() + "\n"
					+ "se le informa que el día " + registro_dia.getFecha() + " usted tuvo contacto "
					+ " con una persona positiva de covid19\n"
					+ "por lo que se les recomienda extremar medidas preventitas y prestar atención a aparición de posibles síntomas\n\n";
		}
		

		//Modifica el átributo mensaje, de la clase madre, de esta instancia
		super.mensaje = destinatarios;
		
		
	}
	@Override
	//Retorna el mensaje que de la notifiación
	public String toString() {
		return super.mensaje + "\n";
	}
	
	
}
