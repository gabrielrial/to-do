package com.gabriel.todolist;

public class Menu {

	public static void menu(Config data) {

		String input;

		while (true) {
			clearConsole();
			DisplayInterfrace();
			input = Input.scanner.nextLine();
			if (input.equals("1")) {
				TaskManagement.newTask(data);
			} else if (input.equals("2")) {
				System.err.println("Showing files...");
				TaskManagement.showTask(data.getTaskFile());
			} else if (input.equals("3")) {
				break;
			}
		}
	}

	private static void DisplayInterfrace() {
		System.out.println("1 - ADD TASK");
		System.out.println("2 - SHOW TASK");
		System.out.println("3 - EXIT");
	}

	public static void clearConsole() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
}
