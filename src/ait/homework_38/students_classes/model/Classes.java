package ait.homework_38.students_classes.model;

public enum Classes {
    MATH("Mathematics"),
    INFO("Computer Science" );
    private String name;


    Classes(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
