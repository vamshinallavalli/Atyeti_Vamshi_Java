package Learning_HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashCodeAndEquals {
    public static void main(String[] args) {

        Student s1=new Student("Raja",1);
        Student s2=new Student("Arjun",2);
        Student s3=new Student("Raja",1);

        HashMap<Student,String> map=new HashMap<>();

        map.put(s1,"Engineer"); // hashcode --> index
        map.put(s2,"Designer");
        map.put(s3,"Manager");

        System.out.println("HashMap Size: "+map.size());
        System.out.println("Value for s1: "+map.get(s1));
        System.out.println("Value for s3: "+map.get(s3));



        Map<String,Integer> map1=new HashMap<>();
        map1.put("Shubham",90);
        map1.put("Neha",91);
        map1.put("Shubham",99);

        System.out.println("HashMap Size: "+map1.size());
        System.out.println("Value for s1: "+map1.get("Neha"));
        System.out.println("Value for s3: "+map1.get("Shubham"));

    }
}

class Student{
    private String name;

    private int id;

    public Student(String name,int id) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Student student = (Student) object;
        return id == student.id && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    //    @Override
//    public boolean equals(Object object) {
//        if (this == object) return true;
//        if (object == null || getClass() != object.getClass()) return false;
//        Student student = (Student) object;
//        return id == student.getId(); // only id
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id); // only id
//    }

}