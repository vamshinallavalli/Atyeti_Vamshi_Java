public class OutputBased_12 {
    public static void change(int x) {
        x = 100;
    }
    public static void main(String[] args) {
        int a = 50;
        change(a);
        System.out.println(a);
    }
}





























    //    In Java, all arguments are passed by value,  even primitives like int.
// So, when change(a) is called, a copy of a's value (50) is passed to x.
// Inside change() method, x = 100 modifies the copy, only local variable will be change,  not the
//original variable.
// The original ‘a’ in main() remains unchanged, so the output is 50.