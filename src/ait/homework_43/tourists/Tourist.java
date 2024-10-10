package ait.homework_43.tourists;

public class Tourist {
    private String name;
    private String[] countries;

    public Tourist(String name, String... countries) {
        this.name = name;
        this.countries = countries;
    }

    public String getName() {
        return name;
    }

    public String[] getCountries() {
        return countries;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name).append("| Countries: ").append(String.join(" ", countries));
        return sb.toString();
    }
}
