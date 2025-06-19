package com.gabriel.todolist;

import com.gabriel.todolist.UtilsFile;
import com.gabriel.todolist.Taskmanagment;

public class App {
    public static void main(String[] args) {
        Config.initialize();
        UtilsFile.CheckForFile();
        Taskmanagment.newTask();
    }
}