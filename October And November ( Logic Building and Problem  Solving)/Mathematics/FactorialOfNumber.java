
// https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Mathematics/problem/factorial-of-number

public class FactorialOfNumber {
}

class Solution3 {
    public int factorial(int n) {
        // code here
        int fact=1;

        for(int i=1;i<=n;i++){
            fact=fact*i;
        }

        return fact;
    }
}
