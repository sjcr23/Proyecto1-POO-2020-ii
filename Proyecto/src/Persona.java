import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Persona {
	
	private String nombre;
	private String id;
	private String teléfono;
	private String fechaDeNacimiento;
	private String tipo;
	private String correo;
	private String idBurbuja;
	private String género;
	private boolean covid19;
	
	public Persona(String nombre, String id, String teléfono, String fechaDeNacimiento, String tipo, String correo,
			String idBurbuja, String género) {
		super();
		this.nombre = nombre;
		this.id = id;
		this.teléfono = teléfono;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.tipo = tipo;
		this.correo = correo;
		this.idBurbuja = idBurbuja;
		this.género = género;
		this.covid19 = false;
	}
	
	public void setCovid19() {
		this.covid19 = true;
	}

	public String getNombre() {
		return nombre;
	}
	
	
	public String getTelefono() {
		return teléfono;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public String getBurbuja() {
		return idBurbuja;
	}
	
	public boolean getCovi19() {
		return covid19;
	}
	
	
	//Actualiza el registro de un establecimiento con el dia actual y la persona que visito dicho lugar
	public void visitar_establecimiento(ArrayList<Establecimiento> establecimientos, Persona persona) {
		Dia dia;
		Scanner scanner = new Scanner(System.in);
		
		for(int i = 0; i < establecimientos.size();i++) {
			System.out.println(i + 1 + " " + establecimientos.get(i).getNombre() + "\n");
			
		}
		System.out.println("Ingrese el establecimiento \n");
		int indice = scanner.nextInt() -1;
		
		
		
		Establecimiento establecimiento = establecimientos.get(indice);
		ArrayList<Dia> registro = establecimiento.getRegistro();
		
		if(registro.size() == 0) {
			dia = new Dia();
			registro.add(dia);
			registro.get(0).setCliente(persona);
			return;
		}
		
		LocalDate fecha = LocalDate.now();
		for(int i = 0; i < registro.size();i++) {
			if(registro.get(i).getFecha() == fecha) {
				registro.get(i).setCliente(persona);
				break;
			}
			
		}
	}

	@Override
	public String toString() {
		String mensaje = "Nombre: " + this.nombre + "\n" + 
	"ID: " + this.id + "\n" +
	"Tipo: " + this.tipo + "\n" + 
	"Burbuja: " + this.idBurbuja + "\n";
		
		return mensaje;
	}
	
	
	
	

	
}
