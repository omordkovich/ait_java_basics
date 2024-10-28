package ait.to_do_list_v2.model;
import java.io.Serializable;

public enum Menu implements Serializable {
    ADD("(1) Add Task | "),
    DEL("(2) Remove Task | "),
    EDIT("(3) Edit Task | "),
    PRINT("(4) Print All Tasks | "),
    LOAD("(5) Load list | "),
    SAVE("(6) Save list | "),
    CLEAN("(7) Clear list | "),
    EXIT("(8) Quit Application\n");

    private String name;

    Menu(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
