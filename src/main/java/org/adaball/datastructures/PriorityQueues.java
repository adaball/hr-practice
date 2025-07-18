package org.adaball.datastructures;

import org.adaball.Util;

import java.io.InputStream;
import java.util.*;

public class PriorityQueues {


    public static void main(String[] args) {
        InputStream inputStream;

        try {
            inputStream = Util.loadResourceAsStream("datastructures/priority-queues.txt");
        } catch (MissingResourceException e) {
            throw new RuntimeException(e);
        }

        Scanner scanner = new Scanner(inputStream);

        int numEvents = scanner.nextInt();
        scanner.nextLine();
        List<String> events = new ArrayList<>();
        for (int i = 0; i < numEvents; i++) {
            events.add(scanner.nextLine());
        }

        Priorities priorities = new Priorities();
        List<Student> students = priorities.getStudents(events);

        for (Student student : students) {
            System.out.println(student.firstName);
        }

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        }

    }

    /**
     * 1. The student having the highest Cumulative Grade Point Average (CGPA) is served first.
     * 2. Any students having the same CGPA will be served by name in ascending case-sensitive alphabetical order.
     * 3. Any students having the same CGPA and name will be served in ascending order of the id.
     */
    private static class StudentComparator implements Comparator<Student> {

        @Override
        public int compare(Student s1, Student s2) {
            // different gpas
            if (s1.gpa > s2.gpa) {
                return -1;
            } else if (s1.gpa < s2.gpa) {
                return 1;
            }

            // same gpa
            // same name
            if (s1.firstName.equals(s2.firstName)) {
                return s1.id.compareTo(s2.id);
            }

            // different name
            return s1.firstName.compareTo(s2.firstName);
        }
    }

    private static class Priorities {
        PriorityQueue<Student> priorityQueue;

        public Priorities() {
            priorityQueue = new PriorityQueue<>(new StudentComparator());
        }

        /**
         * process all the given events and return all the students yet to be served in the priority order.
         */
        public List<Student> getStudents(List<String> events) {
            List<Student> prioritizedStudents = new ArrayList<>();

            for (String event : events) {
                String[] tokens = event.split(" ");

                // SERVED
                if (tokens.length == 1) {
                    priorityQueue.poll();
                    continue;
                }

                // ENTER
                String firstName = tokens[1];
                double gpa = Double.parseDouble(tokens[2]);
                int id = Integer.parseInt(tokens[3]);

                priorityQueue.add(new Student(
                        firstName,
                        gpa,
                        id
                ));
            }

            // The locked stub code prints the names of the students yet to be
            // served in the priority order. If there are no such student, then
            // the code prints EMPTY
            while (!priorityQueue.isEmpty()) {
                prioritizedStudents.add(priorityQueue.poll());
            }


            return prioritizedStudents;
        }
    }

    private static class Student {
        String firstName;
        double gpa;
        Integer id;

        public Student(String firstName, double gpa, int id) {
            this.firstName = firstName;
            this.gpa = gpa;
            this.id = id;
        }
    }
}
