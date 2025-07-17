package org.adaball.datastructures;

import org.adaball.Util;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.MissingResourceException;
import java.util.Scanner;

public class Sort {
    public static void main(String[] args) {
        InputStream inputStream;

        try {
            inputStream = Util.loadResourceAsStream("datastructures/sort.txt");
        } catch (MissingResourceException e) {
            throw new RuntimeException(e);
        }

        Scanner scanner = new Scanner(inputStream);
        int numStudents = scanner.nextInt();
        Student[] students = new Student[numStudents];

        for (int i = 0; i < numStudents; i++) {
            Student student = new Student();
            student.id = scanner.nextInt();
            student.fname = scanner.next();
            student.cgpa = scanner.nextDouble();

            students[i] = student;
        }

        Arrays.sort(students, new Comparer());
        for (Student student : students) {
            System.out.println(student.fname);
        }
    }
}

// Your task is to rearrange them according to their
// CGPA in decreasing order. If two student have the same CGPA,
// then arrange them according to their first name in alphabetical order.
// If those two students also have the same first name, then order them
// according to their ID. No two students have the same ID.

class Comparer implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        if (o1.cgpa > o2.cgpa) {
            return -1;
        } else if (o1.cgpa < o2.cgpa) {
            return 1;
        }

        // gpa same and name same
        if (o1.fname.equals(o2.fname)) {
            if (o1.id < o2.id) {
                return -1;
            } else if (o1.id > o2.id) {
                return 1;
            }

            return 0;
        }

        // gpa same but name different
        return o1.fname.compareTo(o2.fname);
    }
}

class Student {
    int id;
    String fname;
    double cgpa;
//    public Student(int id, String fname, double cgpa) {
//        super();
//        this.id = id;
//        this.fname = fname;
//        this.cgpa = cgpa;
//    }
//    public int getId() {
//        return id;
//    }
//    public String getFname() {
//        return fname;
//    }
//    public double getCgpa() {
//        return cgpa;
//    }
}

