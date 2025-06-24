package com.gabriel.todolist;

public class Config {

	public String user;
	public String taskFile;
	public int color;

	public Config() {
		this.user = "Alpha";
		this.taskFile = null;
		this.color = 0;
	}

	public boolean SetColor(int color) {
		this.color = color;
		return true;
	}

	public String getTaskFile() {
		return this.taskFile;
	}
	public boolean setTaskFile(String path) {
		this.taskFile = path;
		return true;
	}

	public static boolean ConfigToJson(Config config, String path) {
		System.out.println("Saving config to " + path);
		return true;
	}
}
