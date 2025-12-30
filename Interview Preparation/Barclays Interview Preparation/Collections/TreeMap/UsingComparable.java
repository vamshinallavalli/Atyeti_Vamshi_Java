package TreeMap;

import java.util.TreeSet;

class Student implements Comparable<Student> {

    int rollNo;
    String name;
    int marks;

    Student(int rollNo, String name, int marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    // Natural ordering → Roll No
    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.rollNo, o.rollNo);
    }

    @Override
    public String toString() {
        return rollNo + " " + name + " " + marks;
    }
}

public class UsingComparable {
    public static void main(String[] args) {

        TreeSet<Student> set = new TreeSet<>();

        set.add(new Student(3, "Vamshi", 85));
        set.add(new Student(1, "Kumar", 90));
        set.add(new Student(2, "Vijay", 75));

        System.out.println("Sorted using Comparable (RollNo):");
        System.out.println(set);
    }
}
