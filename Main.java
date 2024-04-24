import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Task class representing a single task
class Task {
    private String title;
    private String description;
    private boolean completed;

    // Constructor
    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.completed = false; // By default, a task is not completed
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}

// ToDoList class representing the to-do list and managing tasks
class ToDoList {
    private List<Task> tasks;

    // Constructor
    public ToDoList() {
        this.tasks = new ArrayList<>();
    }

    // Add a new task
    public void addTask(Task task) {
        tasks.add(task);
    }

    // Delete a task
    public void deleteTask(Task task) {
        tasks.remove(task);
    }

    // Mark a task as completed
    public void markTaskAsCompleted(Task task) {
        task.setCompleted(true);
    }

    // Update the details of a task
    public void updateTask(Task task, String newTitle, String newDescription) {
        task.setTitle(newTitle);
        task.setDescription(newDescription);
    }

    // View the list of tasks
    public List<Task> viewTasks() {
        return tasks;
    }
}

// Main class containing the main application logic
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ToDoList toDoList = new ToDoList();

        while (true) {
            // Display menu options
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Update Task Details");
            System.out.println("5. View Tasks");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add Task
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    Task newTask = new Task(title, description);
                    toDoList.addTask(newTask);
                    System.out.println("Task added successfully!");
                    break;
                case 2:
                    // Delete Task
                    System.out.print("Enter title of task to delete: ");
                    String deleteTitle = scanner.nextLine();
                    for (Task task : toDoList.viewTasks()) {
                        if (task.getTitle().equals(deleteTitle)) {
                            toDoList.deleteTask(task);
                            System.out.println("Task deleted successfully!");
                            break;
                        }
                    }
                    break;
                case 3:
                    // Mark Task as Completed
                    System.out.print("Enter title of task to mark as completed: ");
                    String completeTitle = scanner.nextLine();
                    for (Task task : toDoList.viewTasks()) {
                        if (task.getTitle().equals(completeTitle)) {
                            toDoList.markTaskAsCompleted(task);
                            System.out.println("Task marked as completed!");
                            break;
                        }
                    }
                    break;
                case 4:
                    // Update Task Details
                    System.out.print("Enter title of task to update: ");
                    String updateTitle = scanner.nextLine();
                    for (Task task : toDoList.viewTasks()) {
                        if (task.getTitle().equals(updateTitle)) {
                            System.out.print("Enter new title: ");
                            String newTitle = scanner.nextLine();
                            System.out.print("Enter new description: ");
                            String newDescription = scanner.nextLine();
                            toDoList.updateTask(task, newTitle, newDescription);
                            System.out.println("Task details updated successfully!");
                            break;
                        }
                    }
                    break;
                case 5:
                    // View Tasks
                    System.out.println("Tasks:");
                    for (Task task : toDoList.viewTasks()) {
                        System.out.println("Title: " + task.getTitle());
                        System.out.println("Description: " + task.getDescription());
                        System.out.println("Completed: " + task.isCompleted());
                        System.out.println();
                    }
                    break;
                case 6:
                    // Exit
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
