
// https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Mathematics/problem/quadratic-equation-roots

import java.util.ArrayList;

public class QuadraticEquationRoots {
}

class Solution2 {
    public ArrayList<Integer> quadraticRoots(int a, int b, int c) {
        // code here
        ArrayList<Integer> arr=new ArrayList<>();

        int dis=(b*b)-(4*a*c);

        if(dis<0){
            arr.add(-1);
            return arr;
        }

        double sqrtVal=Math.sqrt(dis);


        double root1=(-b+sqrtVal)/(2*a);

        double root2=(-b-sqrtVal)/(2*a);


        int r1=(int) Math.floor(root1);
        int r2=(int) Math.floor(root2);

        if(r1>=r2){
            arr.add(r1);
            arr.add(r2);
        }else{
            arr.add(r2);
            arr.add(r1);
        }

        return arr;
    }
}