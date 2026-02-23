import java.rmi.AccessException;

public class AccessModifier {
    public static void main(String[] args) {
        AccessModifier obj=new AccessModifier();

        obj.hello(3);
    }

    public void hello( int i){
        System.out.println("Hello : int");
    }

    public void hello(long l){
        System.out.println("Hello : long");
    }
}
