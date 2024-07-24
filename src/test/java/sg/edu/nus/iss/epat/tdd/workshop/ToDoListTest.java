package sg.edu.nus.iss.epat.tdd.workshop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ToDoListTest  {
    // Define Test Fixtures
    private ToDoList toDoList;
    private Task task1, task2, task3, task4;
    
    public ToDoListTest() {
        super();
    }

    @Before
    public void setUp() throws Exception {
        // Initialise Test Fixtures
        toDoList = new ToDoList();
        task1 = new Task("task 1");
        task2 = new Task("task 2");
        task3 = new Task("task 3");
        task4 = new Task("task 4");
    }

    @After
    public void tearDown() throws Exception {
        // Uninitialise test Fixtures
    }

    @Test
    public void testAddSingleTask() {
        Task task1 = new Task("task 1");
        toDoList.addTask(task1);
        assertEquals(toDoList.getTask("task 1"), task1);
    }

    @Test
    public void testAddMultipleTasks() {
        toDoList.addTask(task1);
        toDoList.addTask(task2);
        toDoList.addTask(task3);
        toDoList.addTask(task4);
        assertEquals(toDoList.getTask("task 1"), task1);
        assertEquals(toDoList.getTask("task 2"), task2);
        assertEquals(toDoList.getTask("task 3"), task3);
        assertEquals(toDoList.getTask("task 4"), task4);
    }

    @Test
    public void testAddDuplicateTasks() {
        toDoList.addTask(task1);
        toDoList.addTask(task1);
        assertEquals(toDoList.getTask("task 1"), task1);
        assertEquals(toDoList.getAllTasks().size(), 1);
    }

    @Test
    public void testGetInitialisedStatus() {
        toDoList.addTask(task1);
        assertEquals(toDoList.getStatus("task 1"), false);
    }

    @Test
    public void testGetCompletedStatus() {
        toDoList.addTask(task1);
        toDoList.completeTask("task 1");
        assertEquals(toDoList.getStatus("task 1"), true);
    }

    @Test
    public void testGetIncompletedStatus() {
        toDoList.addTask(task1);
        assertFalse(toDoList.getStatus("task 1"));
    }

    @Test
    public void testGetMultipleTasksStatus() {
        toDoList.addTask(task1);
        toDoList.addTask(task2);
        toDoList.completeTask("task 1");
        assertEquals(toDoList.getStatus("task 1"), true);
        assertEquals(toDoList.getStatus("task 2"), false);
    }

    @Test
    public void testRemoveTask_SingleTask() {
        toDoList.addTask(task1);
        Task removedTask = toDoList.removeTask("task 1");
        assertEquals(removedTask, task1);
        assertEquals(toDoList.getAllTasks().size(), 0);
    }

    @Test
    public void testRemoveTask_MultipleTasks() {
        toDoList.addTask(task1);
        toDoList.addTask(task2);
        toDoList.addTask(task3);
        Task removedTask1 = toDoList.removeTask("task 1");
        Task removedTask3 = toDoList.removeTask("task 3");
        assertEquals(removedTask1, task1);
        assertEquals(removedTask3, task3);
        assertEquals(toDoList.getAllTasks().size(), 1);
    }

    @Test
    public void testRemoveTask_EmptyList() {
        Task removedTask = toDoList.removeTask("test task");
        assertEquals(removedTask, null);
        assertEquals(toDoList.getAllTasks().size(), 0);
    }

    @Test
    public void testGetCompletedTasks() {
        fail("Not implemented yet");
    }
}