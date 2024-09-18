package ait.homework_37.currency_convertor;

/*
**Задача 1.**
* Задача 3. Создайте enum с кодами валют и их текущими курсами к евро. Убедитесь, что в списке нет дублирующихся кодов валют.
Выведите список валют и их курсов на экран. Реализуйте возможность для пользователя выбрать желаемую валюту, ввести ее количество и узнать,
сколько он получит при обмене на евро.
 */
public enum Currency {
    EUR(1, "Euro", 1),
    USD(2, "US Dollar", 1.11),
    CHF(3, "Swiss Franc", 1.05),
    GBP(4, "British Pound", 0.85);
    private int number;
    private String name;
    private double rate;

    Currency(int number, String name, double rate) {
        this.number = number;
        this.name = name;
        this.rate = rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public double getRate() {
        return rate;
    }

    public String toString() {
        return String.format("%d. %s, rate: %.2f", number, name, rate);
    }
}
