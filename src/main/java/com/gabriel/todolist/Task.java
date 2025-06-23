package com.gabriel.todolist;

public class Task {

	private String title;
	private String description;
	private String date;
	private boolean done;

	public Task() {
		setTitle();
		setDescription();
		setDate();
		this.done = false;
	}

	public void setTitle() {
		System.out.print("Enter task title: ");
		this.title = Input.scanner.nextLine();
	}

	public void setDescription() {
		System.out.print("Enter description: ");
		this.description = Input.scanner.nextLine();
	}

	public void setDate() {
		System.out.print("Enter date (DD/MM/YYYY): ");
		this.date = Input.scanner.nextLine();
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
