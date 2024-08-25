package ait.homework_30.code.todo_list.model;

public enum TodoMenu {
    ADD(1, "add a task"),
    VIEW(2, "view all tasks"),
    DEL(3, "delete a task"),
    EXIT(4, "exit the menu");

    private int number;
    private String action;

    TodoMenu(int number, String action) {
        this.number = number;
        this.action = action;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return String.format("(%d) %s", number, action);

    }
}
