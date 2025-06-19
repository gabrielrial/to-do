package com.gabriel.todolist;

import java.io.File;
import java.io.IOException;

public class UtilsFile {

	public static boolean CheckForFile() {

		File file = new File(Config.getConfig());
		boolean fileExists = file.exists();

		if (fileExists) {
			return true;
		} else {
			System.out.println("File does not exist. Would you like to create a task file? (Y/N).");
			if (AskUser()) {
				CreateFile(AskPath());
			} else {
				return false;
			}
			return new File(Config.getConfig()).exists(); // chequear otra vez después de intentar crearlo
		}
	}

	public static String AskPath() {
		String path;

		System.out.print("Insert the folder path: ");
		do {
			path = Input.scanner.nextLine();
		} while (!checkPath(path));

		return path;
	}

	public static boolean CreateFile(String path) {
		File fileCreate = new File(path);
		try {
			boolean created = fileCreate.createNewFile();
			if (created) {
				return true;
			} else {
				System.out.println("El archivo ya existe.");
			}
		} catch (IOException e) {
			System.err.println("Error al crear el archivo: " + e.getMessage());
		}
		return false;
	}

	public static boolean AskUser() {
		String input;
		do {
			System.out.print("Please enter Y/N: ");
			input = Input.scanner.nextLine().trim().toLowerCase();
		} while (!input.equals("y") && !input.equals("n"));

		return input.equals("y");
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

	public static boolean InitConfigFile(String path)
	{
		
		return true;
	}
}
