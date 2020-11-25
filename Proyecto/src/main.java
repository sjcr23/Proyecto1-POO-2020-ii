import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		JSONParser parser = new JSONParser();
		Sistema sistema = parser.generarDatos();
		InstitucionAutorizada institucion = new InstitucionAutorizada("CCSS");
		
		
		for(int i = 0;i<sistema.getPersonas().size();i++) {
			System.out.println( i + 1 + " " + sistema.getPersonas().get(i).getNombre() + "\n");
		}
		
		System.out.println("Ingrese la personas\n");
		int persona = scanner.nextInt() -1;
		
		Persona personaEscogia = sistema.getPersonas().get(persona);
		
		personaEscogia.visitar_establecimiento(sistema.getEstablecimientos(), personaEscogia);
		
		System.out.println(sistema.toString());
		
		
		institucion.realizarPrueba(sistema, sistema.getPersonas(), null, null);
		System.out.println(institucion.get_reporte());
	}

}
