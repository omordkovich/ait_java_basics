package ait.homework_35.athletes;

public enum Menu {
    ADD("Add results of run"),
    VIEW("Show statistics of run"),
    END("Exit");
    private final String description;

    Menu(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static Menu getByIndex(int index) {
        return Menu.values()[index];
    }
}
