//package Interview;//package Interview;//package Interview;
////
////
////import java.util.Date;
////
////class Main{
////    public static void main(String[] args) {
////        Employee emp1=new Employee(1,"Vamshi4");
////
////        System.out.println(emp1);
////
////        emp1.getAge().setTime(3);
////
////        System.out.println(emp1);
////    }
////}
////
////final class Employee{
////    private int id;
////    private String name;
////    private Date age;
////
////    public Date getAge() {
////        return new Date();
////    }
////
////    public int getId() {
////        return id;
////    }
////
////
////
////    public String getName() {
////        return name;
////    }
////
////
////    @Override
////    public String toString() {
////        return "Employee{" +
////                "id=" + id +
////                ", name='" + name + '\'' +
////                '}';
////    }
////
////    public Employee(int id, String name) {
////        this.id = id;
////        this.name = name;
////    }
////}
////
////
////
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//public class Main{
//    public static void main(String[] args) {
//
//        Employee emp1=new Employee(1,"Vamshi4",24);
//        Employee emp2=new Employee(2,"Vamshi2",21);
//        Employee emp3=new Employee(3,"Vamshi3",29);
//        Employee emp4=new Employee(4,"Vamshi1",30);
//
//
//        List<Employee> employees= Arrays.asList(emp1,emp2,emp3,emp4);
//
////       List<String> list= (List<String>) employees.stream()
////               .filter(s->!s.getName().equals("Vamshi3") && s.getAge()<25)
////               .map(Employee::getName)
////               .sorted((e1, e2)->e2.compareTo(e1))
////               .collect(Collectors.toList());
//
//       // System.out.println(list);
//
//    }
//}
//
//class Employee{
//    int id;
//    String name;
//    int age;
//
//    public Employee(int id, String name, int age) {
//        this.id = id;
//        this.name = name;
//        this.age = age;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//      this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    @Override
//    public String toString() {
//        return "Employee{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", age=" + age +
//                '}';
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
////
////
////
//////
//////

