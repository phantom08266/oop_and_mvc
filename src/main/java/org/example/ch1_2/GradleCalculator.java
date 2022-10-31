package org.example.ch1_2;

import java.util.List;

public class GradleCalculator {

    private final List<Course> courses;


    public GradleCalculator(List<Course> courses) {
        this.courses = courses;
    }

    public double calculateGrade() {
        double multipliedCreditAndCourseGrade = 0;
        for (Course course : courses) {
            multipliedCreditAndCourseGrade += course.getCredit() * course.getGradeToNumber();
        }

        // 수강신청 총 학점 수
        int totalCompleted = courses.stream()
                .mapToInt(Course::getCredit)
                .sum();

        return multipliedCreditAndCourseGrade / totalCompleted;
    }
}
