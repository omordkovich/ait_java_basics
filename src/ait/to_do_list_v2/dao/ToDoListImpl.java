package ait.to_do_list_v2.dao;

import ait.to_do_list_v2.model.Task;

import java.time.LocalDate;
import java.util.*;

public class ToDoListImpl implements ToDoList {
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
    public Task[] findByDate(LocalDate from, LocalDate till) {
        return new Task[0];
    }

    @Override
    public Task updateTask(Task task) {
        return tasks.stream()
                .filter(t -> t.getId().equals(task.getId()))
                .findFirst()
                .map(t1 -> {
                    t1.setTask(task.getTask());
                    t1.setDateOfCreation(task.getDateOfCreation());
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
        tasks.stream()
                .forEach(task -> System.out.println(task));
    }
}
