package org.example.ch1_2;

import java.util.List;

public class GradleCalculator {

    private final Courses courses;

    public GradleCalculator(List<Course> courses) {
        this.courses = new Courses(courses);
    }

    public double calculateGrade() {
        //(학점수*교과목 평점)
        double multipliedCreditAndCourseGrade = courses.multiplyCreditAndCourseGrade();
        // 수강신청 총 학점 수
        int totalCompleted = courses.calculateTotalCompletedCredit();

        return multipliedCreditAndCourseGrade / totalCompleted;
    }
}
