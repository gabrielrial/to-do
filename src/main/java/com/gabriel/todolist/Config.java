package com.gabriel.todolist;


package com.gabriel.todolist;

import java.io.File;

public class Config {

    public static int color = 0xFFFFFF;

    private static final String CONFIG_FILE = "../../../../../../data/config.json";
    private static final String DEFAULT_PATH = "../../../../../../data/task.json";
    private static String TASK_FILE = DEFAULT_PATH;

	private static final Scanner scanner = new Scanner(System.in);

    static {
        setConfigs();
    }

    public static String getConfig() {
        return CONFIG_FILE;
    }

    public static String getTaskFile() {
        return TASK_FILE;
    }

    public static String getDefaultPath() {
        return DEFAULT_PATH;
    }

    public static void setTaskFile(String path) {
        TASK_FILE = path;
    }

    public static int setConfigs() {
        File file = new File(CONFIG_FILE);
        if (!file.exists()) {
            System.err.println("Config file does not exist. Creating config file...");
            UtilsFile.createFile(CONFIG_FILE);
			setTaskFile(DEFAULT_PATH);
			if (!AskUser("Y/N"))
				setTaskFile(AskPath());
        }
        return 1;
    }
}

