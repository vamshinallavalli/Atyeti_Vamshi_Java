package abstraction;

abstract class UsingAbstract {
    public void hello(){
        System.out.println("Hello....");
    }
}

class Student extends UsingAbstract{
    public static void main(String[] args) {

        Student student=new Student();
        student.hello();
    }
}
