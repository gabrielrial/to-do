package com.gabriel.todolist;

import java.io.File;

public class Config {

    public static int color = 0xFFFFFF;
    public static String TASK_FILE;

    private static String CONFIG_FILE;
    
    private static final String DEFAULT_TASK_PATH_FILE = "../../../../../../data/task.json";

    static {
        setConfigs();
    }

    public static String getTaskFile() {
        return TASK_FILE;
    }

    public static String getDefaultTaskPath() {
        return DEFAULT_TASK_PATH_FILE;
    }

    public static void setTaskFile(String path) {
        TASK_FILE = path;
    }

    public static void setConfigFile(String path) {
        CONFIG_FILE = path;
    }

    public static int setConfigs() {
        File file = new File(CONFIG_FILE);
        if (!file.exists()) {
            System.err.println("Config file does not exist. Creating config file...");
            UtilsFile.CreateFile(CONFIG_FILE);
			setTaskFile(DEFAULT_PATH);
			if (!UtilsFile.AskUser("Y/N"))
				setTaskFile(UtilsFile.AskPath() + "task.json");
        }
        return 1;
    }
}

