public class AssociationDemo {
    public static void main(String[] args) {

        Teacher t = new Teacher();      // Independent object
        Student s = new Student(t);     // Association created

        s.study();
    }
}

class Teacher {
    void teach() {
        System.out.println("Teaching");
    }
}

class Student {
    Teacher teacher; // Association

    Student(Teacher teacher) {
        this.teacher = teacher;
    }

    void study() {
        System.out.println("Student studying...");
        teacher.teach();   // Using Teacher object
    }
}
