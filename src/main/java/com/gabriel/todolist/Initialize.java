package com.gabriel.todolist;

import java.io.File;

public class Initialize {

	public static final String CONF_PATH = "data/config.json";
	public static final String TASK_PATH_DEFAULT = "data/task.json";

	public static String USER_TASK;

	public static boolean InitProgam(Config data) {

		if (!ConfigFile(data)) {
			System.out.println("Check: Initialitze.InitPogram.ConfigFile: Error");
			return false;
		}
		if (!TaskFile(data)) {
			System.out.println("Check: Initialitze.InitPogram.TaskFile: Error");
			return false;
		}
		Json.saveToJson(data, CONF_PATH);
		return true;
	}

	private static boolean ConfigFile(Config data) {
		File configFile = new File(CONF_PATH);

		if (!configFile.exists()) {
			System.out.println("Check: Initialitze.ConfigFile: creating file");
			if (!UtilsFile.CreateFile(CONF_PATH)) {
				System.out.println("Check: Initialitze.ConfigFile: error creating file");
				return false;
			}
			return true;
		}

		System.out.println("Si el archivo existe, tomar ruta de task file");

		// ✅ Leer config.json y obtener el path de task
		Config savedConfig = Json.readFromJson(CONF_PATH, Config.class);
		if (savedConfig != null && savedConfig.getTaskFile() != null) {
			USER_TASK = savedConfig.getTaskFile();
			data.setTaskFile(USER_TASK);
			System.out.println("Ruta obtenida desde config.json: " + USER_TASK);
		} else {
			System.out.println("No se encontró una ruta válida en config.json");
		}
		return true;
	}

	private static boolean TaskFile(Config data) {
		File TaskFile = new File(TASK_PATH_DEFAULT);

		if (TaskFile.exists()) {
			System.out.println("chau");
			return true;
		}
		System.out.println("Do you have a task file already?");

		if (!UtilsFile.AskUser()) {
			USER_TASK = TASK_PATH_DEFAULT;
		} else {
			USER_TASK = UtilsFile.AskPath();
		}
		UtilsFile.CreateFile(USER_TASK);
		data.setTaskFile(USER_TASK);
		return true;
	}
}