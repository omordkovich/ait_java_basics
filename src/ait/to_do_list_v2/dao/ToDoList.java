package ait.to_do_list_v2.dao;

import ait.to_do_list_v2.model.Task;

import java.time.LocalDate;

public interface ToDoList {
    //create task
    boolean addTask(Task task);

    //find by ID
    Task findById(Integer id);

    //find by date from ... till...
    Task[] findByDate(LocalDate from, LocalDate till);

    // найти задачу по подстроке в строке
    //update task
    Task updateTask(Task task);

    //remove
    Task removeTask(Integer id);

    //sort(*)
    Task[] sortByDate();

    int size();
    //prints to do list
    void printList();
}
