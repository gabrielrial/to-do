package com.gabriel.todolist;

import java.io.File;

public class Initialize {

	private static final String CONFIG_FILE = "../../../../../../data/config.json";

	public static boolean InitProgam() {

		if (!ConfigFile()) {
			System.out.println("Check: Initialitze.InitPogram.ConfigFile: Error");
			return false;
		}
		if (!TaskFile()) {
			System.out.println("Check: Initialitze.InitPogram.TaskFile: Error");
			return false;
		}

		return true;
	}

	private static boolean ConfigFile() {
		File ConfigFile = new File(CONFIG_FILE);

		if (!ConfigFile.exists()) {
			System.out.println("Check: Initialitze.ConfigFile: creating file");
			if (!UtilsFile.CreateFile(CONFIG_FILE)) {
				System.out.println("Check: Initialitze.ConfigFile: error creating file");
				return false;
			}
			UtilsFile.InitConfigFile(Config.getDefaultTaskPath());
		}
		return true;
	}

	private static boolean TaskFile() {

		System.out.println("Do you have a task file already?");

		if (!UtilsFile.AskUser()) {
			UtilsFile.CreateFile(Config.getDefaultTaskPath());
			// cargar opciones configutaciones en .json
		} else {
			Config.setTaskFile(UtilsFile.AskPath());
			// cargar configuraciones en classe
		}
		return true;
	}

}