package com.gabriel.todolist;

public class App {

	public static void main(String[] args) {

		Config data = new Config();
		String input;

		Initialize.InitProgam(data);
		// UtilsFile.CheckForFile();
		/*
		 * funcion llamada program donde basicamente permite agregar, mostrar,
		 * eliminar tareas y cerrar el programa.
		 */

		while (true) {
			input = Input.scanner.nextLine().trim().toLowerCase();
			
			Taskmanagment.newTask(data);
		}
	}
}