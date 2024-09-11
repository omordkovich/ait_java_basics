package ait.homework_35.athletes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RunStatistic {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //Creating ArrayList and adding elements
        List<Athlete> athletes = new ArrayList<>();
        athletes.add(new Athlete("Ivanov", "Ivan", "001", "Dynamo"));
        athletes.add(new Athlete("Fedotov", "Oleg", "002", "Zenit"));
        athletes.add(new Athlete("Sidorov", "Alexey", "003", "CSKA"));
        athletes.add(new Athlete("Kuznetsov", "Nikolay", "004", "Lokomotiv"));
        athletes.add(new Athlete("Smirnov", "Mikhail", "005", "Zenit"));
        athletes.add(new Athlete("Fedorov", "Dmitry", "006", "Torpedo"));
        athletes.add(new Athlete("Volkov", "Sergey", "007", "Rubin"));
        athletes.add(new Athlete("Kovalev", "Roman", "008", "Khimki"));
        athletes.add(new Athlete("Orlov", "Andrey", "009", "Dynamo"));
        athletes.add(new Athlete("Lebedev", "Igor", "010", "Spartak"));
        //menu
        boolean flag = true;
        while (flag) {
            for (int i = 0; i < Menu.values().length; i++) {
                System.out.println((i + 1) + ". " + Menu.values()[i].getDescription());
            }
            Athlete selectedAthlete;
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> {
                    boolean flagAthlete = true;
                    while (flagAthlete) {
                        selectedAthlete = selectAthlete(scanner, athletes);
                        if (selectedAthlete == null) {
                            System.out.println("No athlete was found");
                            break;
                        }
                        System.out.println("Set result of " + selectedAthlete.getSurname() + ", " + selectedAthlete.getName() + " (in seconds/milliseconds):");
                        selectedAthlete.setResult(newResult(scanner));
                        System.out.println(selectedAthlete);
                        flagAthlete = false;
                    }

                }
                case "2" -> {
                    //sorts by result (unready first)
                    athletes.sort(Athlete::compareTo);
                    printStatistic(athletes);
                }
                case "3" -> flag = false;
                default -> System.out.println("Wrong input!");
            }
        }
    }

    //checks user input of double being correct
    private static double newResult(Scanner scanner) {
        double result = -1;
        String input = scanner.nextLine();
        try {
            result = Double.parseDouble(input);
            if (result >= 0) {
                return result;
            } else {
                System.out.println("Wrong input.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Wrong input.");
        }
        return result;
    }

    //search for Athlete by regNum over user input
    public static Athlete selectAthlete(Scanner scanner, List<Athlete> athletes) {
        System.out.print("Choose athletes registration number(001-010): ");
        String choice = scanner.nextLine();
        for (Athlete athlete : athletes) {
            if (athlete.getRegNum().equals(choice)) {
                return athlete;
            }
        }
        return null;   //returns null if not found
    }

    //prints statistic list of all athletes
    public static void printStatistic(List<Athlete> athletes) {
        for (Athlete athlete : athletes) {
            System.out.println(athlete);
        }
    }
}
