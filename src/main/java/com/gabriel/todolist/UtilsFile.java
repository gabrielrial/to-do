package com.gabriel.todolist;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class UtilsFile {

    public static boolean CheckForFile() {

        File file = new File(Config.FILE_PATH);
        boolean fileExists = file.exists();

        if (fileExists) {
            return true;
        } else {
            System.out.println("File does not exist. Would you like to create a task file? (Y/N).");
            if (AskUser("Y/N")) {
                AskPath();
                CreateFile(Config.FILE_PATH);
            } else {
                return false;
            }
            return new File(Config.FILE_PATH).exists();  // chequear otra vez después de intentar crearlo
        }
    }

	public static string AskPath() {
		Scanner	scanner = new Scanner(System.in);
		String	path;
		
		System.out.print("Insert the folder path: ");
		do {
			path = scanner.nextLine();
		} while (!checkPath(path));
	}

    public static void CreateFile(String path) {
        File fileCreate = new File(path);
        try {
            boolean created = fileCreate.createNewFile();
            if (created) {
                System.out.println("Archivo creado correctamente.");
            } else {
                System.out.println("El archivo ya existe.");
            }
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + e.getMessage());
        }
    }

    public static boolean AskUser(String mode) {
        Scanner scanner = new Scanner(System.in);
        String input;

        switch (mode) {
            case "Y/N" -> {
                do {
                    input = scanner.nextLine().toLowerCase();
                } while (!input.equals("y") && !input.equals("n"));
                if (input.equals("y")) {
                    return true;
                } else {
                    return false;
                }
            }
            case "path" -> {
                String path;
                System.out.print("Insert the folder path: ");
                do {
                    path = scanner.nextLine();
                } while (!checkPath(path));
                Config.FILE_PATH = path + "/data.json";
                return true;
            }

            default -> {
                System.err.println("Error.\n");
                return false;
            }
        }
    }

    public static boolean checkPath(String path) {
        File dir = new File(path);

        if (!dir.exists()) {
            boolean created = dir.mkdirs();
            if (!created) {
                System.err.println("Path could not be created.\n");
                return false;
            }
        }
        return dir.exists() && dir.isDirectory(); // asegúrate de que realmente es un directorio
    }
}
