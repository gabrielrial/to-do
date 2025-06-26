package com.gabriel.todolist;

public class App {

	public static void main(String[] args) {

		Config data = new Config();

		Initialize.InitProgam(data);
		Menu.menu(data);
	}
}