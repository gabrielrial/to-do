package com.gabriel.todolist;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Json {

	public static <T> void saveToJson(T object, String filePath) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try (FileWriter writer = new FileWriter(filePath)) {
			gson.toJson(object, writer);
			System.out.println("Task saved as JSON in " + filePath);
		} catch (IOException e) {
			System.err.println("Error saving task: " + e.getMessage());
		}
	}

	public static <T> T readFromJson(String filePath, Class<T> clazz) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try (FileReader reader = new FileReader(filePath)) {
			return gson.fromJson(reader, clazz);
		} catch (IOException e) {
			System.err.println("Error reading file: " + filePath);
			return null;
		}
	}

	public static <T> void saveToJsonList(T newObject, String filePath, Class<T> clazz) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		List<T> objects = new ArrayList<>();

		// Leer objetos existentes si el archivo ya existe
		try (FileReader reader = new FileReader(filePath)) {
			Type listType = TypeToken.getParameterized(List.class, clazz).getType();
			objects = gson.fromJson(reader, listType);
			if (objects == null) {
				objects = new ArrayList<>();
			}
		} catch (IOException e) {
			System.out.println("No existing file. Creating new list.");
		}

		// Agregar el nuevo objeto
		objects.add(newObject);

		// Guardar la lista actualizada
		try (FileWriter writer = new FileWriter(filePath)) {
			gson.toJson(objects, writer);
			System.out.println("Saved to JSON: " + filePath);
		} catch (IOException e) {
			System.err.println("Error saving: " + e.getMessage());
		}
	}

	public static List<Task> getTasksFromJson(String filePath) {
		Gson gson = new Gson();
		List<Task> tasks = null;

		try (FileReader reader = new FileReader(filePath)) {
			Type taskListType = new TypeToken<List<Task>>() {
			}.getType();
			tasks = gson.fromJson(reader, taskListType);
		} catch (IOException e) {
			System.err.println("Error reading task file: " + e.getMessage());
		}

		if (tasks == null) {
			tasks = List.of(); // return empty list if file is empty or invalid
		}

		return tasks;
	}
}
