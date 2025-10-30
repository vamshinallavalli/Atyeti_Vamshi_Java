
// https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Mathematics/problem/digits-in-factorial

public class DigitsInFactorial {
}
class Solution4 {
    public int digitsInFactorial(int n) {


        if(n<=1)
            return 1;

        double sum=0;

        for(long i=2;i<=n;i++){
            sum+=Math.log10(i);
        }


        return (int)Math.floor(sum)+1;
    }
}
