package ait.homework_30.code.week_day;

public enum WeekDay {
    MON("Monday", 1, false),
    TUE("Tuesday", 2, false),
    WED("Wednesday", 3, false),
    THU("Thursday", 4, false),
    FRI("Friday", 5, false),
    SAT("Saturday", 6, true),
    SUN("Sunday", 7, true);

    private String name;
    private int number;
    private boolean weekend;

    WeekDay(String name, int number, boolean weekend) {
        this.name = name;
        this.number = number;
        this.weekend = weekend;
    }

    public boolean isWeekend() {
        return weekend;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return String.format("Day Nr. %d, %s. Weekend: %s", number, name, weekend);
    }

    public WeekDay plusDays(WeekDay weekDay, int quantity) {
        int index = weekDay.ordinal();
        index += quantity;
        WeekDay[] weekDays = values();
        int res = index % weekDays.length;
        return weekDays[res];
    }

}