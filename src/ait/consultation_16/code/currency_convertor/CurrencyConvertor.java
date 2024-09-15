package ait.consultation_16.code.currency_convertor;

import java.util.Scanner;

public class CurrencyConvertor {
    public static void main(String[] args) {
        Currency[] currencies = Currency.values();
        printCurrencies(currencies);
        Scanner scanner = new Scanner(System.in);
        double quantity = 0;
        double rate = 0;
        boolean flag;
        do {
            flag = false;
            System.out.print("Input number of currency: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> rate = Currency.EUR.getRate();
                case "2" -> rate = Currency.USD.getRate();
                case "3" -> rate = Currency.CHF.getRate();
                case "4" -> rate = Currency.GBP.getRate();
                default -> {
                    System.out.println("Wrong input!");
                    flag = true;
                }
            }
        } while (flag);
        do {
            System.out.print("Input amount of money: ");
            String amount = scanner.nextLine();
            try {
                quantity = Double.parseDouble(amount);
                flag = true;
            } catch (NumberFormatException n) {
                System.out.println("Wrong Input!");
            }
        } while (!flag);
        double res = quantity / rate;
        System.out.printf("You get: %.2f", res);
        System.out.println(" euro");
    }

    private static void printCurrencies(Currency[] currencies) {
        for (Currency c : currencies) {
            System.out.println(c);
        }
        System.out.println("-----------------------------");
    }
}
