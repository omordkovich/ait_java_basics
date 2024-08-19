package ait.to_do_list.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ait.to_do_list.dao.ToDoList;
import ait.to_do_list.dao.ToDoListImpl;
import ait.to_do_list.model.Task;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ToDoListImplTest {
    ToDoList toDoList;
    Task[] tasks;

    @BeforeEach
    void setUp() {
        toDoList = new ToDoListImpl(4);
        tasks = new Task[]{
                new Task(15, "GamesCom", "normal", false, LocalDateTime.of(2024, 8, 19, 23, 11), LocalDate.of(2024, 8, 21)),
                new Task(16, "Code Marathon", "high", false, LocalDateTime.of(2024, 8, 19, 23, 13), LocalDate.of(2024, 8, 24)),
                new Task(14, "Ait Homework", "high", true, LocalDateTime.of(2024, 8, 18, 12, 0), LocalDate.of(2024, 8, 20))
        };
        for (int i = 0; i < tasks.length; i++) {
            toDoList.addTask(tasks[i]);
        }
    }

    @Test
    void addTask() {
        assertFalse(toDoList.addTask(null));
        assertFalse(toDoList.addTask(tasks[0]));
        Task task = new Task(18, "Ait Homework", "high", false, LocalDateTime.of(2024, 8, 19, 23, 20), LocalDate.of(2024, 8, 27));
        assertTrue(toDoList.addTask(task));
        task = new Task(19, "Ait Homework", "high", false, LocalDateTime.of(2024, 8, 19, 23, 20), LocalDate.of(2024, 8, 27));
        assertFalse(toDoList.addTask(task));
    }

    @Test
    void findById() {
        assertEquals(tasks[0], toDoList.findById(15));
        assertNull(toDoList.findById(99));
    }

    @Test
    void findByDate() {
        Task[] expected = {tasks[0], tasks[2]};
        Task[] actual = toDoList.findByDate(LocalDate.of(2024, 8, 20), LocalDate.of(2024, 8, 21));
        assertArrayEquals(expected, actual);
    }

    @Test
    void updateTask() {
        Task updatedTask = new Task(15, "GamesCom", "normal", false, LocalDateTime.of(2024, 8, 19, 23, 11), LocalDate.of(2024, 8, 22));
        assertEquals(tasks[0], toDoList.updateTask(updatedTask));
        updatedTask = new Task(99, "GamesCom", "normal", false, LocalDateTime.of(2024, 8, 19, 23, 11), LocalDate.of(2024, 8, 22));
        assertNull(toDoList.updateTask(updatedTask));
    }

    @Test
    void removeTask() {
        Task victim = toDoList.removeTask(15);
        assertEquals(tasks[0],victim);
        assertNull(toDoList.removeTask(99));
    }

    @Test
    void sortByDate() {
        Task[] expected = {tasks[2], tasks[0], tasks[1], null};
        Task[] actual = toDoList.sortByDate();
        assertArrayEquals(expected, actual);
    }
}