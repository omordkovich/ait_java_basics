package ait.consultation_14.students;
//Задача 2. Распределить группу студентов на две примерно равных группы (+/- 1 человек)
// случайным образом. Определить массив студентов в программе. Получить на выходе 2 списка студентов (2 массива).

import java.util.Arrays;

public class StudentAppl {
    public static void main(String[] args) {
        Student[] students = new Student[10];
        students[0] = new Student("Student0");
        students[1] = new Student("Student1");
        students[2] = new Student("Student2");
        students[3] = new Student("Student3");
        students[4] = new Student("Student4");
        students[5] = new Student("Student5");
        students[6] = new Student("Student6");
        students[7] = new Student("Student7");
        students[8] = new Student("Student8");
        students[9] = new Student("Student9");

        Student[] studentsGroupA = new Student[5];
        Student[] studentsGroupB = new Student[5];
        int count = 0;
        int index = 0;
        while (count != 5) {
            index = (int) (Math.random() * (0 - 10 + 1) + 10);
            if (students[index] != null) {
                studentsGroupA[count] = students[index];
                students[index] = null;
                count++;
            }
        }
        for (int i = 0, j = 0; i < students.length; i++) {
            if (students[i] != null) {
                studentsGroupB[j] = students[i];
                students[i] = null;
                j++;
            }
        }
        Arrays.sort(studentsGroupA);
        Arrays.sort(studentsGroupB);
        printArray(studentsGroupA);
        printArray(studentsGroupB);
    }

    public static void printArray(Object[] objects) {
        System.out.println("--------------------Students list-------------------");
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }
        System.out.println("-----------------------------------------------------");
    }
}
