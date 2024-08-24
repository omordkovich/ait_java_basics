package ait.high_school.dao;

import ait.high_school.model.SchoolStaff;
import ait.high_school.model.Student;

import java.util.Arrays;

public class HighSchoolImpl implements HighSchool {
    SchoolStaff[] schoolStaff;
    int size;

    public HighSchoolImpl(int capacity) {
        this.schoolStaff = new SchoolStaff[capacity];
    }

    @Override
    public boolean addStaff(SchoolStaff staff) {
        if (staff == null || schoolStaff.length == size || findStaff(staff.getId()) != null) {
            return false;
        }
        schoolStaff[size++] = staff;
        return true;
    }

    @Override
    public SchoolStaff removeStaff(int id) {
        for (int i = 0; i < size; i++) {
            if (schoolStaff[i].getId() == id) {
                SchoolStaff victim = schoolStaff[i];
                System.arraycopy(schoolStaff, i + 1, schoolStaff, i, size - i - 1);
                schoolStaff[--size] = null;
                return victim;
            }
        }
        return null;
    }

    @Override
    public SchoolStaff findStaff(int id) {
        for (int i = 0; i < size; i++) {
            if (schoolStaff[i].getId() == id) {
                return schoolStaff[i];
            }
        }
        return null;
    }

    @Override
    public SchoolStaff updateStaff(SchoolStaff staff) {
        for (int i = 0; i < size; i++) {
            if (schoolStaff[i].getId() == staff.getId()) {
                schoolStaff[i] = staff;
                return staff;
            }
        }
        return null;
    }

    @Override
    public double globalAveragePoints() {
        double res = 0;
        for (SchoolStaff staff : schoolStaff) {
            if (staff instanceof Student student) {
                res += student.getGpa();
            }
        }
        return res;
    }

    @Override
    public SchoolStaff[] findByGpaRange(double from, double till) {
        SchoolStaff[] myStaff = new SchoolStaff[size];
        int count = 0;
        for (SchoolStaff staff : schoolStaff) {
            if (staff instanceof Student student) {
                if (student.getGpa() >= from && student.getGpa() <= till) {
                    myStaff[count++] = staff;
                }
            }
        }
        if (count > 0) {
            return Arrays.copyOf(myStaff, count);
        } else {
            return null;
        }
    }
}
