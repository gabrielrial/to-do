package com.gabriel.todolist;

public class Taskmanagment {

	// Add and save task
	public static void newTask(Config data) {
		Task newTask = new Task(); // Esto ya pide datos al usuario

		// Muestra la tarea ingresada
		System.out.println("🔹 Tarea ingresada:");
		System.out.println("Title: " + newTask.getTitle());
		System.out.println("Description: " + newTask.getDescription());
		System.out.println("Date: " + newTask.getDate());
		System.out.println("Option to edit any of the fields");
		Json.saveToJsonList(newTask, data.taskFile, Task.class);
	}
}
