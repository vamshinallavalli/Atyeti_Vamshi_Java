//public class LaunchingApplication {
//    public static void main(String[] args) {
//        System.out.println(args[0]+" "+args[1]);
//    }
//}

public class LaunchingApplication {
    public static void main(String[] args) {
        if (args.length >= 2) {
            System.out.println(args[0] + " " + args[1]);
        } else {
            System.out.println("Please pass two arguments.");
        }
    }
}