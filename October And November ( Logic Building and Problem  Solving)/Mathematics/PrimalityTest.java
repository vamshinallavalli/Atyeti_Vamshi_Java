
// https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Mathematics/problem/primality-test
public class PrimalityTest {
}

class Solution5 {
    public boolean isPrime(int n) {

        if(n<2)
            return false;
        // code here
        for(int i=2;i<=n/2;i++){
            if(n%i==0)
                return false;
        }

        return true;
    }
}
