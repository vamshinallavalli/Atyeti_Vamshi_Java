package TreeMap;

import java.util.Comparator;
import java.util.TreeSet;

public class UsingComparator {
    public static void main(String[] args) {

        Comparator<Student> byMarksDesc =
                (s1, s2) -> Integer.compare(s2.marks, s1.marks);

        TreeSet<Student> set = new TreeSet<>(byMarksDesc);

        set.add(new Student(3, "Vamshi", 85));
        set.add(new Student(1, "Kumar", 90));
        set.add(new Student(2, "Vijay", 75));

        System.out.println("Sorted using Comparator (Marks Desc):");
        System.out.println(set);
    }
}
