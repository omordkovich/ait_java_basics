package ait.to_do_list_v2.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Task implements Serializable, Comparable<Task> {
    private static int idCounter = 0;
    private int id;
    private String task;
    private LocalDateTime dateOfCreation;

    public Task(String task) {
        this.id = ++idCounter;
        this.task = task;
        this.dateOfCreation = LocalDateTime.now();
    }
    public static void setIdCounter(int idCounter) {
        Task.idCounter = idCounter;
    }
    @Override
    public String toString() {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        String formattedTime = dateOfCreation.format(timeFormatter);
        return String.format("Task: ID - %d, task - %s, created: %s", id, task, formattedTime);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Task task)) return false;
        return Objects.equals(id, task.id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDateTime dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    @Override
    public int compareTo(Task o) {
        return this.getDateOfCreation().compareTo(o.getDateOfCreation());
    }
}
