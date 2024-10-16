package ait.to_do_list_v1.dao;

import ait.to_do_list_v1.model.Task;

import java.time.LocalDate;
import java.util.Arrays;

public class ToDoListImpl implements ToDoList {
    Task[] tasks;
    int size;

    public ToDoListImpl(int capacity) {
        this.tasks = new Task[capacity];
    }

    @Override
    public boolean addTask(Task task) {
        if (task == null || size == tasks.length || findById(task.getId()) != null) {
            return false;
        }
        tasks[size++] = task;
        return true;
    }

    @Override
    public Task findById(Integer id) {
        for (int i = 0; i < size; i++) {
            if (tasks[i].getId() == id) {
                return tasks[i];
            }
        }
        return null;
    }

    @Override
    public Task[] findByDate(LocalDate from, LocalDate till) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if ((tasks[i].getDeadLine().isAfter(from) || tasks[i].getDeadLine().isEqual(from)) && (tasks[i].getDeadLine().isBefore(till) || tasks[i].getDeadLine().isEqual(till))) {
                count++;
            }
        }
        Task[] myTasks = new Task[count];
        for (int i = 0, j = 0; i < size; i++) {
            if ((tasks[i].getDeadLine().isAfter(from) || tasks[i].getDeadLine().isEqual(from)) && (tasks[i].getDeadLine().isBefore(till) || tasks[i].getDeadLine().isEqual(till))) {
                myTasks[j++] = tasks[i];
            }
        }
        return myTasks;
    }

    @Override
    public Task updateTask(Task task) {
        for (int i = 0; i < size; i++) {
            if (tasks[i].getId() == task.getId()) {
                tasks[i] = task;
                return task;
            }
        }
        return null;
    }

    @Override
    public Task removeTask(Integer id) {
        Task victim = null;
        for (int i = 0; i < size; i++) {
            if (tasks[i].getId() == id) {
                victim = tasks[i];
                tasks[size - 1] = null;
                size--;
                break;
            }
        }
        return victim;
    }


    @Override
    public Task[] sortByDate() {
        Arrays.sort(tasks, 0, size);
        return tasks;
    }
}
