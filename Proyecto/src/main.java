
public class main {

	public static void main(String[] args) {
		JSONParser parser = new JSONParser();
		Sistema sistema = parser.generarDatos();
		
		System.out.println(sistema.toString());
		

	}

}
