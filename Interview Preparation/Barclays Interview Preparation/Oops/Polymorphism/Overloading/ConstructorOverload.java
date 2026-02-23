public class ConstructorOverload {
    public static void main(String[] args) {
        ConstructorOverload obj=new ConstructorOverload(3.3);

    }


    public ConstructorOverload(int x){
        System.out.println("int");
    }

    public ConstructorOverload(float x){
        System.out.println("float");
    }

    public ConstructorOverload(double x){
        System.out.println("double");
    }
}
