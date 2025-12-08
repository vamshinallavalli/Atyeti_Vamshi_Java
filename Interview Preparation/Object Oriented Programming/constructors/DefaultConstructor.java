package constructors;

public class DefaultConstructor {
    public static void main(String[] args) {
        Student obj=new Student();

        System.out.println(obj.name);
        System.out.println(obj.rollNumber);

    }
}

class Student {
    int rollNumber;
    String name;
}
