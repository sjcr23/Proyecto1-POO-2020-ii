
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
	
	
	
}
