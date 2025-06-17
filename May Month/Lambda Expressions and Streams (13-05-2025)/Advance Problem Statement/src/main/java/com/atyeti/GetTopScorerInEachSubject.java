package com.atyeti;

import java.util.*;
import java.util.stream.Collectors;

public class GetTopScorerInEachSubject {
    public static void main(String[] args) {
        List<Student> students= Arrays.asList(
                new Student("Vamshi","Maths",98),
                new Student("Arjun","Social",83),
                new Student("Vijay","Maths",87),
                new Student("Prabhas","Hindi",81),
                new Student("Karthi","Maths",74),
                new Student("Gowtham","English",99),
                new Student("Althaf","Hindi",77),
                new Student("Subani","Social",78),
                new Student("Sai","Maths",88),
                new Student("Shoheb","English",94),
                new Student("Raja","Biology",92)

        );

        Map<String,Student> map=students.stream()
                        .collect(Collectors.groupingBy(
                                Student::getSubject,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(Comparator.comparingInt(Student::getMarks)),
                                        Optional::get
                                )
                        ));

        //map.forEach((subject,marks)-> System.out.println(subject+" "+marks));
        map.forEach((subject, student) ->
                System.out.println(subject + " -> " + student));
    }
}

class Student {
    String name;
    String subject;
    int marks;

//    @Override
//    public String toString() {
//        return "Student{" +
//                "name='" + name + '\'' +
//                ", subject='" + subject + '\'' +
//                ", marks=" + marks +
//                '}';
//    }

    @Override
    public String toString() {
        return name + " (" + marks + ")";
    }


    public Student(String name, String subject, int marks) {
        this.name = name;
        this.subject = subject;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}