package ait.high_school.dao;

import ait.high_school.model.SchoolStaff;

public interface HighSchool {

    boolean addStaff(SchoolStaff staff);

    SchoolStaff removeStaff(int id);

    SchoolStaff findStaff(int id);

    SchoolStaff updateStaff(SchoolStaff staff);

    double globalAveragePoints();

    SchoolStaff[] findByGpaRange(double from, double till);
}
