package mediumProblemsforHandsOn;

import java.io.*;

public class UseMultiCatch {
    public static void main(String[] args) {
        try {
            int i = 10 / 0;
            FileReader fr = new FileReader("file.txt"); // This can throw IOException
        } catch (ArithmeticException | IOException e) {
            System.out.println("Caught: " + e);
        }
    }
}
