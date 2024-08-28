package ait.consultation_14.currency.model;

import java.util.Scanner;

/*
Выведите список валют и их курсов на экран.
Реализуйте возможность для пользователя выбрать желаемую валюту,
ввести ее количество и узнать, сколько он получит при обмене на евро.
(*) Убедитесь, что в списке нет дублирующихся кодов валют.
 */
public class CurrencyAppl {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Currency[] table = Currency.values();
        boolean flag = true;
        double res = 0;
        int amount = 0;
        Currency c = null;
        System.out.println("Check for duplicates: " + checkForDuplicates(table));
        while (flag) {
            printCurrencyTable(table);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> c = Currency.USD;
                case 2 -> c = Currency.GBP;
                case 3 -> c = Currency.JPY;
                case 4 -> c = Currency.CHF;
                case 5 -> c = Currency.RUB;
                case 6 -> c = Currency.UAH;
                case 7 -> c = Currency.CNY;
                case 8 -> flag = false;
                default -> System.out.println("Wrong choice!");
            }
            if (c != null) {
                System.out.println("Your choice is: " + c.getName());
                System.out.print("Input amount(" + c.getName() + "):");
                amount = scanner.nextInt();
                res = c.convertToEuro(amount);
                System.out.printf("%d %s = %.2f€ \n", amount, c.getName(), res);
            }
        }
    }


    public static void printCurrencyTable(Currency[] currencies) {
        int number = 1;
        System.out.println("---------------Currency Choice--------------");
        for (Currency currency : currencies) {
            System.out.println("(" + (number++) + ") " + currency);
        }
        System.out.println("(8) Exit");
    }

    public static boolean checkForDuplicates(Currency[] currencies) {
        for (int i = 0; i < currencies.length; i++) {
            Currency c = Currency.values()[i];
            for (int j = currencies.length - 1; j > i; j--) {
                if (currencies[j].getName().equals(currencies[i].getName())) {
                    return true;
                }
            }
        }
        return false;
    }
}