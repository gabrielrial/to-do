package com.gabriel.todolist;

import com.gabriel.todolist.UtilsFile;
import com.gabriel.todolist.Taskmanagment;

public class App {
    public static void main(String[] args) {
        Config config = new Config();
        if (!config.exists)
            return;
        
        UtilsFile.CheckForFile();
        Taskmanagment.newTask();
    }
}