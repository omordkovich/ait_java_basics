package ait.homework_35.athletes;

import java.util.Objects;

/*
Задача 3.(*) Имеется протокол результатов забега 10 спортсменов на дистанции 100 метров, в котором зафиксированы
фамилия, имя, регистрационный номер спортсмена, клуб и результат в секундах и десятых долях секунды.
Создайте приложение, которое позволит ввести в компьютер результаты спортсменов и получить итоговый протокол соревнования.
 */
public class Athlete implements Comparable<Athlete> {
    private String surname;
    private String name;
    private String regNum;
    private String club;
    private double result = -1;

    public Athlete(String surname, String name, String regNum, String club) {
        this.surname = surname;
        this.name = name;
        this.regNum = regNum;
        this.club = club;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegNum() {
        return regNum;
    }

    public void setRegNum(String regNum) {
        this.regNum = regNum;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    @Override
    public String toString() {
        String res = "no result";
        if (result >= 0) {
            res = String.format("%.1f", result);
        }
        return String.format("%s, %s; Nr: %s; Club: %s; Result of run: %s", surname, name, regNum, club, res);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Athlete athlete)) return false;
        return Objects.equals(regNum, athlete.regNum);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(regNum);
    }

    @Override
    public int compareTo(Athlete o) {
        //sorts first filled results
        if (this.result >= 0 && o.result < 0) {
            return -1;
        }
        if (this.result < 0 && o.result >= 0) {
            return 1;
        }
        return Double.compare(this.result, o.result);
    }
}
