package ait.to_do_list_v2.dao;
import ait.to_do_list_v2.model.Task;


public interface ToDoList {
    //create task
    boolean addTask(Task task);

    //find by ID
    Task findById(Integer id);

    // найти задачу по подстроке в строке
    //update task
    Task updateTask(int id, String task);

    //remove
    Task removeTask(Integer id);

    //sort(*)
    Task[] sortByDate();

    int size();
    //prints to do list
    void printList();
}
