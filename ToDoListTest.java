import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class ToDoListTest {
    private ToDoList toDoList;

    @Before
    public void setUp() {
        toDoList = new ToDoList();
    }

    @Test
    public void testAddTask() {
        Task task = new Task("Test Task", "This is a test task");
        toDoList.addTask(task);
        List<Task> tasks = toDoList.viewTasks();
        assertEquals(1, tasks.size());
        assertEquals(task, tasks.get(0));
    }

    @Test
    public void testDeleteTask() {
        Task task = new Task("Test Task", "This is a test task");
        toDoList.addTask(task);
        assertTrue(toDoList.viewTasks().contains(task));
        toDoList.deleteTask(task);
        assertFalse(toDoList.viewTasks().contains(task));
    }

    @Test
    public void testMarkTaskAsCompleted() {
        Task task = new Task("Test Task", "This is a test task");
        toDoList.addTask(task);
        assertFalse(task.isCompleted());
        toDoList.markTaskAsCompleted(task);
        assertTrue(task.isCompleted());
    }

    @Test
    public void testUpdateTask() {
        Task task = new Task("Test Task", "This is a test task");
        toDoList.addTask(task);
        String newTitle = "Updated Task";
        String newDescription = "This is an updated test task";
        toDoList.updateTask(task, newTitle, newDescription);
        assertEquals(newTitle, task.getTitle());
        assertEquals(newDescription, task.getDescription());
    }

    @Test
    public void testViewTasks() {
        Task task1 = new Task("Task 1", "This is task 1");
        Task task2 = new Task("Task 2", "This is task 2");
        toDoList.addTask(task1);
        toDoList.addTask(task2);
        List<Task> tasks = toDoList.viewTasks();
        assertEquals(2, tasks.size());
        assertTrue(tasks.contains(task1));
        assertTrue(tasks.contains(task2));
    }
}
