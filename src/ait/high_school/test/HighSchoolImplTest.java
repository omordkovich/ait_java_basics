package ait.high_school.test;

import ait.high_school.dao.HighSchool;
import ait.high_school.dao.HighSchoolImpl;
import ait.high_school.model.Aspirant;
import ait.high_school.model.Professor;
import ait.high_school.model.SchoolStaff;
import ait.high_school.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class HighSchoolImplTest {
    HighSchool highSchool;
    SchoolStaff[] schoolStaff;

    @BeforeEach
    void setUp() {
        highSchool = new HighSchoolImpl(6);
        schoolStaff = new SchoolStaff[5];
        schoolStaff[0] = new Student(1829, "Student", "Wasja", "Petrov", LocalDate.of(2002, 3, 12), "Frontend", new int[]{1, 1, 2});
        schoolStaff[1] = new Student(1256, "Student", "Semjon", "Kuzmich", LocalDate.of(1980, 10, 2), "Backend", new int[]{2, 4, 3});
        schoolStaff[2] = new Student(1567, "Student", "Ekaterina", "Ivanova", LocalDate.of(2000, 8, 20), "UI/UX", new int[]{3, 5, 1});
        schoolStaff[3] = new Professor(2025, "Professor", "Wladimer", "Iljich", LocalDate.of(1959, 9, 5), "Fullstack", 2.1, 20);
        schoolStaff[4] = new Aspirant(3012, "Aspirant", "Dmitij", "Uspensky", LocalDate.of(1995, 11, 25), "Backend", "Scalable microservices", 1.2, "under review");
        for (int i = 0; i < schoolStaff.length; i++) {
            highSchool.addStaff(schoolStaff[i]);
        }
    }

    @Test
    void addStaff() {
        assertFalse(highSchool.addStaff(schoolStaff[1]));
        assertFalse(highSchool.addStaff(null));
        SchoolStaff staff = new Professor(3562, "Professor", "Semjon", "Simjunych", LocalDate.of(1975, 2, 10), "UI/UX/Frontend", 0, 1);
        assertTrue(highSchool.addStaff(staff));
        staff = new Professor(2254, "Professor", "Matvej", "Murkin", LocalDate.of(1998, 5, 5), "UI/UX", 0, 0);
        assertFalse(highSchool.addStaff(staff));
    }

    @Test
    void removeStaff() {
        SchoolStaff staff = highSchool.removeStaff(1256);
        assertEquals(staff, schoolStaff[1]);
    }

    @Test
    void findStaff() {
        assertEquals(schoolStaff[1], highSchool.findStaff(1256));
        assertNull(highSchool.findStaff(0000));
    }

    @Test
    void updateStaff() {
        int[] newPoints = {2, 4, 3, 1};
        Student staff = new Student(1256, "Student", "Semjon", "Kuzmich", LocalDate.of(1980, 10, 2), "Backend", newPoints);
        assertEquals(highSchool.updateStaff(staff), schoolStaff[1]);
        assertEquals(staff.getPoints(), ((Student) highSchool.updateStaff(staff)).getPoints());
        staff = new Student(0000, "Student", "Semjon", "Kuzmich", LocalDate.of(1980, 10, 2), "Backend", newPoints);
        assertNull(highSchool.updateStaff(staff));
    }

    @Test
    void globalAveragePoints() {
        assertEquals(7.333, 0.001,highSchool.globalAveragePoints());
    }

    @Test
    void findByGpaRange() {
        SchoolStaff[] expected = {schoolStaff[1], schoolStaff[2]};
        SchoolStaff[] actual = highSchool.findByGpaRange(2, 3);
        assertArrayEquals(expected, actual);
        assertNull(highSchool.findByGpaRange(4, 5));

    }
}