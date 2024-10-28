package ait.to_do_list_v2;

import ait.to_do_list_v2.dao.ToDoList;
import ait.to_do_list_v2.dao.ToDoListImpl;
import ait.to_do_list_v2.model.Menu;
import ait.to_do_list_v2.model.Task;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoAppl implements Serializable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Menu> menus = new ArrayList<>(List.of(Menu.values()));
        List<Task> toDo = new ArrayList<>();
        ToDoList list = new ToDoListImpl(toDo);
        boolean flag = true;
        do {
            menus.forEach(menu -> System.out.print(menu.getName()));

            String input = scanner.next();
            switch (input) {
                case "1" -> {
                    System.out.print("New Task: ");
                    input = scanner.next();
                    Task newTask = new Task(input);
                    list.addTask(newTask);
                }
                case "2" -> {
                    System.out.print("Enter task ID to remove: ");
                    input = scanner.next();
                    try {
                        if (list.findById(Integer.parseInt(input)) != null) {
                            System.out.println(list.removeTask(Integer.parseInt(input)) + " was found!");
                        } else {
                            System.out.println("No task with ID: " + input + " was found!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Try again!");
                    }
                }
                case "3" -> {
                    System.out.print("Enter task ID of task you want to edit: ");
                    input = scanner.next();
                    try {
                        if (list.findById(Integer.parseInt(input)) != null) {
                            System.out.println("Enter new task: ");
                            scanner.nextLine();
                            String newTask = scanner.nextLine();
                            list.updateTask(Integer.parseInt(input), newTask);
                        } else {
                            System.out.println("No task with ID: " + input + " was found!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Try again!");
                    }
                }
                case "4" -> {
                    System.out.println("Your TO DO list:");
                    list.printList();
                }
                case "5" -> {
                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/ait/to_do_list_v2/saveData/todo.dat"))) {
                        list = (ToDoListImpl) ois.readObject();
                        Task.setIdCounter(list.findMaxID());
                        System.out.println("List Loaded!");
                    } catch (EOFException e) {
                        System.out.println("The file is empty!");
                    } catch (IOException | ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }

                }
                case "6" -> {
                    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/ait/to_do_list_v2/saveData/todo.dat"))) {
                        oos.writeObject(list);
                        System.out.println("Saved!");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "7" -> {
                    list = new ToDoListImpl();
                    System.out.println("List is clean!");
                }
                case "8" -> {
                    System.out.println("Quit TODO List!");
                    flag = false;
                }
                default -> System.out.println("Wrong input!");
            }
        } while (flag);
    }
}
