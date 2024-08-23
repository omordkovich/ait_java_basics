package ait.pet_hotel.model;

import java.util.Objects;

/*Задача 1. Задача 1. В классе Pet имеются поля:
-id
-вид
-возраст
-кличка
Создайте дочерние от класса Pet классы Cat и Dog c дополнительными полями:
-порода
-рост
-вес
Создайте метод voice, который выдает "Мяу!" для класса Cat и и "Гав-гав!" для класса Dog. Создайте HouseAppl,
в котором есть метод main. Поселите в доме 2 собаки и 3 кошки. Смоделируйте жизнь в этом доме в течение дня. */
public abstract class Pet {
    private final double DOGPIRCE = 29.99;
    private final double CATPRICE = 19.99;
    private int id;
    private String kind;
    private int age;
    private String name;

    public Pet(int id, String kind, int age, String name) {
        this.id = id;
        this.kind = kind;
        this.age = age;
        this.name = name;
    }

    public double getDOGPIRCE() {
        return DOGPIRCE;
    }

    public double getCATPRICE() {
        return CATPRICE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " is a " + kind + " with ID: " + id + ", is " + age + " years old";
    }

    public String sleeping() {
        return name + " is sleeping.";
    }

    public String eating() {
        return name + " is eating.";
    }

    public String playing() {
        return name + " is playing.";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Pet pet)) return false;
        return id == pet.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
