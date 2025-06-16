package mediumProblemsforHandsOn;

import java.io.*;

public class ResourceHandling {
    public static void main(String[] args) throws IOException {
        try(BufferedReader reader=new BufferedReader(new FileReader("C:\\Users\\VamshiNallavalli\\Downloads\\transactions.txt"));
            BufferedWriter writer=new BufferedWriter(new FileWriter("C:\\Users\\VamshiNallavalli\\Downloads\\newTransactions.txt"))){

            String str="";

            while((str=reader.readLine())!=null){
                writer.write(str);
            }

        }finally {
            System.out.println("Done Successfully!");
        }
    }
}
