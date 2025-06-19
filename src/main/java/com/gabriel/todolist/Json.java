package com.gabriel.todolist;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Json {

	public static void saveTaskToJson(Task task, String filePath) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try (FileWriter writer = new FileWriter(filePath)) {
			gson.toJson(task, writer);
			System.out.println("Task saved as JSON in " + filePath);
		} catch (IOException e) {
			System.err.println("Error saving task: " + e.getMessage());
		}
	}
}
