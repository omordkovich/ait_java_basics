package ait.to_do_list_v2.model;

public enum Menu {
    ADD("(1) Add Task | "),
    DEL("(2) Remove Task | "),
    EDIT("(3) Edit Task | "),
    PRINT("(4) Print All Tasks | "),
    EXIT("(5) Quit Application\n");

    private String name;

    Menu(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
