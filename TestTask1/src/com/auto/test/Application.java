package com.auto.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(5);
        students.add(new Student("Ivan", "Ivanov"));
        students.add(new Student("Peter", "Petrov"));
        students.add(new Student("Sidor", "Sidorov"));
        students.add(new Student("Pasha", "Pashev"));
        students.add(new Student("Sasha", "Sashev"));

        int[] results = getResults(students);
        System.out.println("Средняя оценка студентов: " + calculateAverageMark(results));

        System.out.println();

        solveExtraTask1(students);

        System.out.println();

        solveExtraTask2();
    }

    private static float calculateAverageMark(int[] marks) {
        float averageMark = 0f;
        for (int mark : marks) {
            averageMark += mark;
        }
        return averageMark / marks.length;
    }

    private static void solveExtraTask1(List<Student> students) {
        System.out.println("**** Доп задание 1 ****");

        int ticketsCount = 10;
        List<Ticket> tickets = new ArrayList<>(ticketsCount);
        for (int i = 0; i < ticketsCount; i++) {
            tickets.add(new Ticket(i, "Question " + i));
        }

        Ticket[] studentTickets = getTicketForStudents(tickets, students);
        int[] results = getResults(students);

        System.out.println("Средняя оценка по группе - " + calculateAverageMark(results));

        System.out.println();

        int studentsCount = students.size();
        for (int i = 0; i < studentsCount; i++) {
            System.out.println("Студент " + students.get(i) + " получил оценку " + results[i] + " за билет " + studentTickets[i]);
        }
    }

    private static void solveExtraTask2() {
        System.out.println("**** Доп задание 1 ****");

        Group firstGroup = new Group("373901");
        firstGroup.addStudent(new Student("Ul'yana", "Babina"));
        firstGroup.addStudent(new Student("Denis", "Vinagin"));
        firstGroup.addStudent(new Student("Alexey", "Virinskiy"));
        firstGroup.addStudent(new Student("Sasha", "Golubev"));
        firstGroup.addStudent(new Student("Ekaterina", "Dankevich"));

        Group secondGroup = new Group("373902");
        secondGroup.addStudent(new Student("Ekaterina", "Pokladok"));
        secondGroup.addStudent(new Student("Evgeniy", "Kaminskiy"));
        secondGroup.addStudent(new Student("Alexey", "Tsvetkov"));
        secondGroup.addStudent(new Student("Danik", "Mihalyonok"));
        secondGroup.addStudent(new Student("Daniil", "Posoh"));

        List<Student> firstGroupStudents = firstGroup.getStudents();
        List<Student> secondGroupStudents = secondGroup.getStudents();

        int[] firstGroupResults = getResults(firstGroupStudents);
        int[] secondGroupResults = getResults(secondGroupStudents);

        System.out.println("Средняя оценка по группе " + firstGroup.getName() + " - " + calculateAverageMark(firstGroupResults));
        System.out.println("Лучший студенты группы " + firstGroup.getName() + " - " + firstGroup.getBestStudent(firstGroupResults));
        System.out.println("Худший студенты группы " + firstGroup.getName() + " - " + firstGroup.getWorstStudent(firstGroupResults));

        System.out.println();

        System.out.println("Средняя оценка по группе " + secondGroup.getName() + " - " + calculateAverageMark(secondGroupResults));
        System.out.println("Лучший студенты группы " + secondGroup.getName() + " - " + secondGroup.getBestStudent(firstGroupResults));
        System.out.println("Худший студенты группы " + secondGroup.getName() + " - " + secondGroup.getWorstStudent(firstGroupResults));
    }

    private static int[] getResults(List<Student> students) {
        int studentsCount = students.size();
        int[] results = new int[studentsCount];
        for (int i = 0; i < studentsCount; i++) {
            results[i] = getRandomNumberInRange(1, studentsCount);
        }
        return results;
    }

    private static Ticket[] getTicketForStudents(List<Ticket> tickets, List<Student> students) {
        int ticketsCount = tickets.size();
        int studentsCount = students.size();
        Ticket[] studentTickets = new Ticket[studentsCount];
        for (int i = 0; i < studentsCount; i++) {
            int ticketIndex = getRandomNumberInRange(1, ticketsCount);
            studentTickets[i] = tickets.get(ticketIndex);
        }
        return studentTickets;
    }

    private static int getRandomNumberInRange(int min, int max) {

        Random r = new Random();
        return r.ints(min, (max + 1)).limit(1).findFirst().getAsInt();
    }
}