import java.io.File;

public class App {
    public static void main(String[] args) {
		File file = new File("../../../../../../data/data.txt");
		boolean fileExists = file.exists();
		if (fileExists){
			System.out.println("El archivo existe.\n");
		}
		else
			System.out.println("El archivo no existe.\n");
    }
}

		// comprobar si existe archivo.
			// crear archivo en caso de no existir
				// preguntar si deeas crearlo.
					// leer de la conosola si el usuario presiona Y / N