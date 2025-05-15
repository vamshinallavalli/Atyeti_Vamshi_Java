import java.util.*;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

public class CustomComparatorWithLambda {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Charlie", 30));
        people.add(new Person("Dave", 20));

        people.sort((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));
        System.out.println("Sorted by age:");
        people.forEach(System.out::println);

        people.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
        System.out.println("\nSorted by name:");
        people.forEach(System.out::println);
    }
}
