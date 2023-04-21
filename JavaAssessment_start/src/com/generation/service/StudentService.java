package com.generation.service;

import com.generation.model.Course;
import com.generation.model.EnrolledCourse;
import com.generation.model.Student;

import java.util.HashMap;

public class StudentService {
    private final HashMap<String, Student> students = new HashMap<>();

    public void registerStudent(Student student) {
        //TODO Add new student to the students hashmap
        students.put(student.getId(), student);
    }

    public Student findStudent(String studentId) {
        //TODO Find the student from the Hashmap with the student id
        return students.get(studentId);
    }

    public void enrollToCourse(String studentId, Course course) {
        //TODO check if students hashmap contains the studentsId, if have add the course to the student enrolledCourse
        if (students.containsKey(studentId)) {
            Student student = students.get(studentId);
            EnrolledCourse enrollCourse = new EnrolledCourse(course);
            student.enrollToCourse(enrollCourse);
        }
    }

    public void showSummary() {
        //TODO Loop through students hashmap and print out students' details including the enrolled courses
        for (Student printStudent : students.values()) {
            System.out.println(printStudent);
            System.out.println("Enrolled Courses: " + printStudent.getEnrolledCourses());
        }
    }

    public HashMap<String, EnrolledCourse> enrolledCourses(Student student) {
        //TODO return a HashMap of all the enrolledCourses
        return student.getEnrolledCourses();
    }

    public Course findEnrolledCourse(Student student, String courseId) {
        //TODO return the course enrolled by the student from the course Id
        if (student.getEnrolledCourses().containsKey(courseId)) {
            return student.getEnrolledCourses().get(courseId);
        }
        return null;
    }

    public void gradeStudent(Student student, Course course, double grade) {
        student.gradeCourse(course.getCode(), grade);
    }


    public HashMap<String, EnrolledCourse> getPassedCourses(Student student) {

        return student.findPassedCourses();
    }
}
