
public class Taskmanagment {

    // Add task.
    public static void newTask() {
		Task newTask = new Task();
		System.out.println(newTask.getTitle());
		System.out.println(newTask.getDescription());
		System.out.println(newTask.getDate());
    }

}
