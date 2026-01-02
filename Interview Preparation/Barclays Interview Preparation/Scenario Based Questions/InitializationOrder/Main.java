package InitializationOrder;

public class Main {
    public static void main(String[] args) {
        Numbers obj1=new Numbers();
        Numbers obj2=new Numbers();
    }
}


class Numbers{
    static {
        System.out.println("1");
    }
    {
        System.out.println("2");
    }
    Numbers(){
        System.out.println("3");
    }
}