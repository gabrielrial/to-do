package com.gabriel.todolist;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Json {

	public static <T> void saveTaskToJson(T object, String filePath) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try (FileWriter writer = new FileWriter(filePath)) {
			gson.toJson(object, writer);
			System.out.println("Task saved as JSON in " + filePath);
		} catch (IOException e) {
			System.err.println("Error saving task: " + e.getMessage());
		}
	}
}
