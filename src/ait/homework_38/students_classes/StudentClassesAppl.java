package ait.homework_38.students_classes;
/*
Задача 2.(*) Напишите программу, которая: Создает список студентов, зарегистрированных на два разных курса: "Математика" и "Информатика". Выводит: Список студентов, которые записаны на оба курса. Список студентов, которые записаны только на один из курсов. Условия: Используйте два HashSet для хранения студентов каждого курса. Программа должна использовать операции пересечения и разности множеств для вывода нужных списков.
 */

import ait.homework_38.students_classes.model.Classes;
import ait.homework_38.students_classes.model.Student;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudentClassesAppl {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();
        List<Classes> classes101 = new ArrayList<>();
        classes101.add(Classes.MATH);
        classes101.add(Classes.INFO);
        students.add(new Student(101, "John", "Smith", 2001, classes101));
        List<Classes> classes102 = new ArrayList<>();
        classes102.add(Classes.MATH);
        students.add(new Student(102, "Emily", "Johnson", 2002, classes102));
        List<Classes> classes103 = new ArrayList<>();
        classes103.add(Classes.INFO);
        students.add(new Student(103, "Michael", "Williams", 2000, classes103));
        List<Classes> classes104 = new ArrayList<>();
        classes104.add(Classes.INFO);
        students.add(new Student(104, "Alice", "White", 1998, classes104));
        List<Classes> classes105 = new ArrayList<>();
        classes105.add(Classes.MATH);
        classes105.add(Classes.INFO);
        students.add(new Student(105, "Bob", "Green", 1997, classes105));
        List<Classes> classes106 = new ArrayList<>();
        classes106.add(Classes.MATH);
        students.add(new Student(106, "Charlie", "Black", 1999, classes106));
        Set<Student> mathematics = new HashSet<>();
        Set<Student> computerScience = new HashSet<>();

        //add mathematics students to mathematics student list
        for (Student s : students) {
            if (s.getClasses().contains(Classes.MATH)) {
                mathematics.add(s);
            }
        }
        //add computer science students to computer science student list
        for (Student s : students) {
            if (s.getClasses().contains(Classes.INFO)) {
                computerScience.add(s);
            }
        }
        System.out.println("Students of mathematics class: ");
        printSet(mathematics);
        System.out.println("Students of computer science class: ");
        printSet(computerScience);
        System.out.println("Students of both classes: ");
        Set<Student> intersection = intersectedClasses(mathematics, computerScience);
        printSet(intersection);
        System.out.println("Students of only mathematics class: ");
        Set<Student> differenceMath = differenceClass(mathematics, computerScience);
        printSet(differenceMath);
        System.out.println("Students of only computer science class: ");
        Set<Student> differenceInfo = differenceClass(computerScience, mathematics);
        printSet(differenceInfo);
    }

    private static Set<Student> differenceClass(Set<Student> first, Set<Student> second) {
        HashSet<Student> res = new HashSet<>(first);
        res.removeAll(second);
        return res;
    }

    private static Set<Student> intersectedClasses(Set<Student> first, Set<Student> second) {
        HashSet<Student> res = new HashSet<>(first);
        res.retainAll(second);
        return res;
    }

    private static void printSet(Set<Student> set) {
        for (Student s : set) {
            System.out.println(s);
        }
        System.out.println("--------------------------------");
    }
}
