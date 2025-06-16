
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class UtilsFile {

    public static void CheckForFile(String[] args) {
        File file = new File(Config.FILE_PATH);
        boolean fileExists = file.exists();
        if (fileExists) {
            System.out.println("El archivo existe.\n");
        } else {
            System.out.println("Would you like to create a task file? (Y/N).\n");
            AskPath(args);
            CreateFile(args);
        }
    }

    public static void CreateFile(String[] args) {
        File fileCreate = new File(Config.FILE_PATH);
        boolean Created = fileCreate.createNewFile();
    }

    public static void AskPath(String[] args) {
        System.out.print("Would you like to create a task file in the in the Standar Path?. (Y/N)\n" + Config.STD_PATH + "\n");
        if (N) {
 
        }
        Scanner scanner = new Scanner(System.in);
        String nombre = scanner.nextLine();
    }

    public static String AskUser(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if () { 
           do {
				String input = scanner.nextLine();
            } while (!input || ((input != 'y' || input != 'n') && !input[2]));

        }
        if (path) {
            String path = scanner.nextLine();
            // verificar que PATH esxista.
            // si no existe preguntar si crear o no

        }
        return scanner;
    }

	public static boolean CheckPath(String[] args)
	{
		File file = new File(Config.FILE_PATH);
        boolean fileExists = file.exists();
        if (fileExists) {
            return (true);
        } else {
            return (false);
	}
}

// comprobar si existe archivo.
// crear archivo en caso de no existir
// preguntar si deeas crearlo.
					// leer de la conosola si el usuario presiona Y / N
