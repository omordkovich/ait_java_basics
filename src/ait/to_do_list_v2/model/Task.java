package ait.to_do_list_v2.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/*
- id - порядковый номер задачи
- task - содержание задачи
- priority - приоритет задачи
- status (done/undone)
- date
- deadline - контрольный срок выполнения задачи
Спроектируйте и реализуйте интерфейс ToDoList
Реализуйте тесты ToDoListTest и имплементацию ToDoListImpl.
 */
public class Task implements Comparable<Task> {
    private Integer id;
    private String task;
    private String priority;
    private Boolean status; //true/false/null
    private LocalDateTime dateOfCreation;
    private LocalDate deadLine;

    public Task(Integer id, String task, String priority, Boolean status, LocalDateTime dateOfCreation, LocalDate deadLine) {
        this.id = id;
        this.task = task;
        this.priority = priority;
        this.status = status;
        this.dateOfCreation = dateOfCreation;
        this.deadLine = deadLine;
    }

    @Override
    public String toString() {
        return String.format("Task: ID - %d, task - %s, priority %s, status - %s, created: %s, deadline: %s", id, task, priority, status, dateOfCreation, deadLine);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Task task)) return false;
        return Objects.equals(id, task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
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

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDateTime dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        this.deadLine = deadLine;
    }


    @Override
    public int compareTo(Task o) {
            return this.getDeadLine().compareTo(o.getDeadLine());
    }
}
