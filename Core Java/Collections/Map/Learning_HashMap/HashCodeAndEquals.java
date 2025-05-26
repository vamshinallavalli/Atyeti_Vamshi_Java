package Learning_HashMap;

import java.util.HashMap;
import java.util.Objects;

public class HashCodeAndEquals {
    public static void main(String[] args) {
        HashMap<Student,String> map=new HashMap<>();
        Student s1=new Student("Raja",1);
        Student s2=new Student("Arjun",2);
        Student s3=new Student("Raja",1);

        map.put(s1,"Engineer"); // hashcode --> index
        map.put(s2,"Designer");
        map.put(s3,"Manager");

        System.out.println(map.size());
        System.out.println(map);



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