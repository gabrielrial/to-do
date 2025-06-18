package com.gabriel.todolist;

import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Taskmanagment {

    // Add and save task
    public static void newTask() {
        Task newTask = new Task(); // Esto ya pide datos al usuario

        // Muestra la tarea ingresada
        System.out.println("🔹 Tarea ingresada:");
        System.out.println("Title: " + newTask.getTitle());
        System.out.println("Description: " + newTask.getDescription());
        System.out.println("Date: " + newTask.getDate());
        System.out.println("Option to edit any of the fields");
        // Guardar en archivo JSON
        saveTaskToJson(newTask, Config.FILE_PATH);
    }

    // Save task to a JSON file
    public static void saveTaskToJson(Task task, String filePath) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(task, writer);
            System.out.println("✅ Task saved as JSON in " + filePath);
        } catch (IOException e) {
            System.err.println("❌ Error saving task: " + e.getMessage());
        }
    }
}
