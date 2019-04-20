package com.auto.test;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private final String name;
    private final List<Student> students = new ArrayList<>();

    public Group(String name) {
        this.name = name;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public String getName() {
        return name;
    }

    public Student getBestStudent(int[] results) {
        int bestStudentIndex = 0;
        for (int i = 1; i < results.length; i++) {
            if (results[i] > results[bestStudentIndex]) {
                bestStudentIndex = i;
            }
        }
        return students.get(bestStudentIndex);
    }

    public Student getWorstStudent(int[] results) {
        int worstStudentIndex = 0;
        for (int i = 1; i < results.length; i++) {
            if (results[i] < results[worstStudentIndex]) {
                worstStudentIndex = i;
            }
        }
        return students.get(worstStudentIndex);
    }
}
