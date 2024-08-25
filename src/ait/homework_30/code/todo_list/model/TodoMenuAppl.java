package ait.homework_30.code.todo_list.model;

import java.util.Scanner;

public class TodoMenuAppl {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TodoMenu[] todos = TodoMenu.values();
        boolean flag = true;
        while (flag) {
            printMenu(todos);
            System.out.print("Input your choice:");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1, 2 -> System.out.println("Your choice is: " + todos[choice - 1].getAction());
                case 3 -> {
                    System.out.println("Your choice is: " + todos[2].getAction() + "\nEnter the number of task:");
                    int taskNr = scanner.nextInt();
                    System.out.println("task number "+ taskNr + " is deleted!");
                }
                case 4 -> {
                    System.out.println("Your choice is: " + todos[3].getAction());
                    flag = false;
                }
                default -> System.out.println("Wrong choice!");
            }
        }
    }

    private static void printMenu(TodoMenu[] todos) {
        for (TodoMenu todo : todos) {
            System.out.println(todo);
        }
    }
}
