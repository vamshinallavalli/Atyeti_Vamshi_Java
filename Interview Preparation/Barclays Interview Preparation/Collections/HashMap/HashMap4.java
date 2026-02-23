package HashMap;

import java.util.ArrayList;
import java.util.Arrays;

public class HashMap4 {

    public static void main(String[] args) {

        Employee4 emp1=new Employee4(3,"vamshi3",30000);
        Employee4 emp2=new Employee4(1,"vamshi9",23000);
        Employee4 emp3=new Employee4(2,"vamshi5",12000);
        Employee4 emp4=new Employee4(9,"vamshi1",50000);

        ArrayList<Employee4> list =
                new ArrayList<>(Arrays.asList(emp1, emp2, emp3, emp4));



    }
}
