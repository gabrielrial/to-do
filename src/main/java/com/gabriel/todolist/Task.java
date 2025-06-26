package com.gabriel.todolist;

import java.time.LocalDate;

public class Task {

	private String title;
	private String description;
	private String date;
	private String dead_line;
	private boolean done;

	public Task() {
		this.title = null;
		this.description = null;
		this.date = null;
		this.dead_line = null;
		this. done = false;
	}

//	public void setDeadLine() {
//		System.out.print("Enter dead line: ");
//		this.dead_line = Input.scanner.nextLine();
//	}

	public void setTitle() {
		System.out.print("Enter task title: ");
		this.title = Input.scanner.nextLine();
	}

	public void setDescription() {
		System.out.print("Enter description: ");
		this.description = Input.scanner.nextLine();
	}

	public void setDate() {
		date = LocalDate.now().toString();
	}

	public String getTitle() {
		return this.title;
	}

	public String getDescription() {
		return this.description;
	}

	public String getDate() {
		return this.date;
	}

	public boolean isDone() {
		return this.done;
	}

	public void markAsDone() {
		this.done = true;
	}

	public void displayTask() {
		System.out.println("Title: " + title);
		System.out.println("Description: " + description);
		System.out.println("Date: " + date);
		System.out.println("Done: " + (done ? "Yes" : "No"));
	}
}
