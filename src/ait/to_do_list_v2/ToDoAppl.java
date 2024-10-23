package ait.to_do_list_v2;

import ait.to_do_list_v2.dao.ToDoList;
import ait.to_do_list_v2.dao.ToDoListImpl;
import ait.to_do_list_v2.model.Menu;
import ait.to_do_list_v2.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoAppl {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Menu> menus = new ArrayList<>(List.of(Menu.values()));
        menus.forEach(menu -> System.out.print(menu.getName()));
        List<Task> toDo = new ArrayList<>();
        ToDoList list = new ToDoListImpl(toDo);
        String input = scanner.next();
        switch (input) {
            case "1" -> {
                System.out.print("New Task: ");
                input = scanner.next();
                Task newTask = new Task(input);
                list.addTask(newTask);
                break;
            }
            case "2" -> {
                System.out.print("Enter task ID to remove: ");
                input = scanner.next();
                if (list.findById(Integer.parseInt(input)) != null) {
                    System.out.println(list.removeTask(Integer.parseInt(input)) + " was found!");
                } else {
                    System.out.println("No task with ID: " + input + " was found!");
                }
            }
            default -> System.out.println("ups");
        }
        list.printList();
    }
}
