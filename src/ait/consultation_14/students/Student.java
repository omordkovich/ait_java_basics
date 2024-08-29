package ait.consultation_14.students;

import java.util.Objects;

public class Student implements Comparable<Student> {
    private String Lastname;

    public Student(String lastname) {
        Lastname = lastname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("Lastname='").append(Lastname).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return Objects.equals(Lastname, student.Lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(Lastname);
    }

    @Override
    public int compareTo(Student o) {
        return getLastname().compareTo(o.getLastname());
    }
}
