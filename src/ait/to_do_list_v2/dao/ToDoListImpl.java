package ait.to_do_list_v2.dao;

import ait.to_do_list_v2.model.Task;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

public class ToDoListImpl implements ToDoList, Serializable {
    List<Task> tasks;

    public ToDoListImpl() {
        this.tasks = new ArrayList<>();
    }

    public ToDoListImpl(List<Task> tasks) {
        this();
        tasks.forEach(this::addTask);
    }

    @Override
    public boolean addTask(Task task) {
        if (task == null || tasks.contains(task))
            return false;
        tasks.add(task);
        return true;
    }

    @Override
    public Task findById(Integer id) {
        return tasks.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Task updateTask(int id, String task) {
        return tasks.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .map(t1 -> {
                    t1.setTask(task);
                    t1.setDateOfCreation(LocalDateTime.now());
                    return t1;
                })
                .orElse(null);
    }

    @Override
    public Task removeTask(Integer id) {
        Task victim = findById(id);
        if (tasks.contains(victim) && victim != null) {
            tasks.remove(victim);
            return victim;
        } else {
            return null;
        }
    }

    @Override
    public Task[] sortByDate() {
        return tasks.stream()
                .sorted(Task::compareTo)
                .toArray(Task[]::new);
    }

    @Override
    public int size() {
        return tasks.size();
    }

    @Override
    public void printList() {
        tasks.forEach(task -> System.out.println(task));
    }
}
