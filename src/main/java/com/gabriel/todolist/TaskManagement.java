package com.gabriel.todolist;

import java.util.List;

public class TaskManagement {

	// Add and save task
	public static void newTask(Config data) {
		Task newTask = new Task(); // Esto ya pide datos al usuario

		newTask.setTitle();
		newTask.setDescription();
		newTask.setDate();
		Menu.clearConsole();
		System.out.println("🔹 Tarea ingresada:");
		System.out.print("Title:	" + newTask.getTitle() + "\n");
		System.out.print("Desc.:	" + newTask.getDescription() + "\n");
		System.out.print("Date:	" + newTask.getDate() + "\n");
		System.out.println("\nConfirm task");
		if (UtilsFile.AskUser())
			Json.saveToJsonList(newTask, data.taskFile, Task.class);
	}

	public static void showTask(String path) {
		int i;
		String input;
		List<Task> tasks = Json.getTasksFromJson(path);

		if (tasks.isEmpty()) {
			System.out.println("No hay tareas guardadas.");
			Input.scanner.nextLine(); // Espera Enter
			return;
		}

		while (true) {
			Menu.clearConsole();
			System.out.println("Task List:\n");
			i = 1;
			for (Task t : tasks) {
				System.out.println(i + " " + t.getTitle() + "	" + t.getDate());
				i++;
			}
			System.out.println("\nPress Enter to continue.\n");
			input = Input.scanner.nextLine();
			if (input.equals("")) {
				break;
			}
		}

	}

}
