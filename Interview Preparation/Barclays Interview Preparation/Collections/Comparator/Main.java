import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person p1=new Person("vamshi",24);
        Person p2=new Person("vijay",35);
        Person p3=new Person("kumar",56);
        Person p4=new Person("shoheb",25);
        Person p5=new Person("ramesh",40);


        List<Person> list=new ArrayList<>(Arrays.asList(p1,p2,p3,p4,p5));

//Q1)Write a Comparator to sort Person objects by age in descending order.


      //  list.stream().sorted(Comparator.comparing(Person::getAge)).forEach(System.out::println);

//Q2)This comparator has a subtle bug. What is it and how to fix?

//Comparator<Person> byAge = (p1, p2) -> p1.age - p2.age;
//p1.age is Integer.Max and P2.age = -2


  // Q3)Sort employees by: Department (asc), then Salary (desc), then Name (asc)\


        Employee emp1=new Employee("vamshi",50000,"Delivery");

//  list.stream().sorted(Comparator.comparing(Employee))

    }
}
