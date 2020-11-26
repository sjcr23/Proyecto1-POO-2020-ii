import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Sistema{
	
	private ArrayList<Persona> personas;
	private ArrayList<Establecimiento> establecimientos;
	private ArrayList<Burbuja> burbujas;
	private Dia DiaActual;

	
	public Sistema() {
		super();
		this.personas = new ArrayList<Persona>();
		this.establecimientos = new ArrayList<Establecimiento>();
		this.burbujas = new ArrayList<Burbuja>();
	}
	


	
	public void añadirPersonas(Persona nuevaPersona) {
		personas.add(nuevaPersona);
		
	}
	
	public void añadirEstablecimiento(Establecimiento nuevoEstablecimiento) {
		establecimientos.add(nuevoEstablecimiento);
	}
	
	public void añadirBurbuja(Burbuja nuevaBurbuja) {
		burbujas.add(nuevaBurbuja);
	}
	public void setDia(Dia dia) {
		this.DiaActual = dia;
		
	}
	public ArrayList<Persona> getPersonas(){
		return personas;
	}
	
	public ArrayList<Establecimiento> getEstablecimientos(){
		return establecimientos;
	}

	public ArrayList<Burbuja> getBurbujas(){
		return burbujas;
	}

	public void notificarContagio(Sistema sistema, Persona paciento) {
		ArrayList<Burbuja> listaBurbujas = sistema.getBurbujas();
		ArrayList<Establecimiento> listaEstablecimientos = sistema.getEstablecimientos();
		
		ArrayList<Dia> registro;
		
		Notificacion_burbuja notificacion1;
		Notificacion_recinto notificacion2;
		Notificacion_contacto notificacion3;
		
		for(int i = 0; i < listaBurbujas.size() ; i++) {
			
			if(paciento.getBurbuja().equals(listaBurbujas.get(i).getid())) {
				
				notificacion1 = new Notificacion_burbuja(listaBurbujas.get(i), paciento);
				notificacion1.setMensaje();
				System.out.println("---------------------------------------------------------------------------");
				System.out.println("NOTIFICACION BURBUJA\n");
				System.out.println(notificacion1.toString());
				System.out.println("---------------------------------------------------------------------------\n");
			}
			
			
		}
		
		for(int i = 0; i < listaEstablecimientos.size() ; i++) {
			
			if(listaEstablecimientos.get(i).getTrabajadores().contains(paciento)) {
				
				notificacion2 = new Notificacion_recinto(listaEstablecimientos.get(i), paciento);
				notificacion2.setMensaje();
				System.out.println("---------------------------------------------------------------------------\n");
				System.out.println("NOTIFICACION RECINTO\n");
				System.out.println(notificacion2.toString());
				System.out.println("---------------------------------------------------------------------------\n");
			}
			
			registro = listaEstablecimientos.get(i).getRegistro();
			
			if(registro.size() == 0) {
				continue;
			}
			
			for(int k = 0; k < registro.size() ; k++) {
				
				if(registro.get(k).getClientes().contains(paciento)) {
					
					notificacion3 = new Notificacion_contacto(registro.get(k),paciento);
					notificacion3.setMensaje();
					System.out.println("---------------------------------------------------------------------------\n");
					System.out.println("NOTIFICACION CONTACTOS\n");
					System.out.println(notificacion3.toString());
					System.out.println("---------------------------------------------------------------------------\n");
					
				}
			}
			
			
		}
		
	}
	
	@Override
	public String toString() {
		String mensaje;
		mensaje = establecimientos.get(2).toString();
		
		
		return mensaje;
	}
	
	

	
	
	
	

}
