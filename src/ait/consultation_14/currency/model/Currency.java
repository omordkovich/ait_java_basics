package ait.consultation_14.currency.model;

/*
Создайте enum с кодами валют и их текущими курсами к евро.
 */
public enum Currency {
    USD(1.08, "US Dollar"),
    GBP(0.86, "British Pound"),
    JPY(158.50, "Japanese Yen"),
    CHF(0.96, "Swiss Frank"),
    RUB(99.0, "Russian Rubel"),
    UAH(45.82, "Ukrainian Hrywnja"),
    CNY(7.92, "Renminbi Yuan");

    private double valueOfEuro;
    private String name;

    Currency(double valueOfEuro, String name) {
        this.valueOfEuro = valueOfEuro;
        this.name = name;
    }

    public double getValueOfEuro() {
        return valueOfEuro;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s : %.2f€", name, valueOfEuro);
    }

    public double convertToEuro(double amount) {
        return amount / valueOfEuro;
    }
}
