public class OutputBased_1 {
    int x = 10;
    public static void main(String[] args) {

        OutputBased_1 obj=new OutputBased_1();


        MyFunc f = () -> System.out.println(obj.x);
        obj.x=20;
        f.test();
    }

    @FunctionalInterface
    interface MyFunc {
        void test();
    }
}
























/*


We cannot reassign x because local variables captured by a lambda must be
final or effectively final.

Sol-

Use a Wrapper / Mutable Object
 */




















