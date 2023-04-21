package com.generation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Student extends Person {
    public static final double PASS_MIN_GRADE = 3.0;

    private final HashMap<String, EnrolledCourse> enrolledCourses = new HashMap<>();


    public Student(String id, String name, String email, Date birthDate) {
        super(id, name, email, birthDate);
    }

    public boolean enrollToCourse(Course course) {
        //TODO Check if student has already enrolled to the course, if not add the course to enrolledCourses hashmap
        if (!enrolledCourses.containsKey(course.getCode())) {
            EnrolledCourse enrolledCourse = new EnrolledCourse(course);
            enrolledCourses.put(course.getCode(), enrolledCourse);
            System.out.println("Student " + getId() + " has been enrolled in course " + course.getCode());
            return true;
        } else {
            System.out.println("Student " + getId() + " is already enrolled in course " + course.getCode());
            return false;
        }
    }

    public HashMap<String, EnrolledCourse> getEnrolledCourses() {
        //TODO return a Hashmap of all the enrolledCourses
        return enrolledCourses;
    }

    public void gradeCourse(String courseCode, double grade) {
        //TODO set the grade for the enrolled Course
        if (enrolledCourses.containsKey(courseCode)) {
            enrolledCourses.get(courseCode).setGrade(grade);
            System.out.println("Course " + courseCode + " has been graded for student " + getId());
        } else {
            System.out.println("Course " + courseCode + " not found for student " + getId());
        }
    }

    public Course findCourseById(String courseId) {
        //TODO return a Course from the course Id
        for (Course course : enrolledCourses.values()) {
            if (course.getCode() == courseId) {
                return course;
            }
        }
        return null;
    }

    public HashMap<String, EnrolledCourse> findPassedCourses() {
        //TODO Check the enrolled courses grade and compare to the passing grade
        HashMap<String, EnrolledCourse> passedCourses = new HashMap<>();
        for (EnrolledCourse enrolledCourse : enrolledCourses.values()) {
            if (enrolledCourse.getGrade() >= PASS_MIN_GRADE) {
                passedCourses.put(enrolledCourse.getCode(), enrolledCourse);
            }
        }
        return passedCourses;
    }

    public String toString() {
        return "Student {" + super.toString() + "}";
    }
}
