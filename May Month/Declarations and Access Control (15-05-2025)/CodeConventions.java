public class CodeConventions implements Runnable{
    private int i;
    public synchronized void run() {
        if(i%5 !=0){i++; }
        for(int x=0;x<5;x++,i++)
        {                          
            if(x>1) Thread.yield();
        }
        System.out.println(i+" ");
    }

    public static void main(String[] args) {
        CodeConventions n=new CodeConventions();
        for(int x=100;x>0;--x) {
            new Thread(n).start();
        }
    }
}

/*

NoBody wants you to your code like this!

Code like this was created only so that complex concepts could be tested within a universal testing tool.
  ---------------------------------------------------------------------
Classes and interfaces The first letter should be capitalized, and if several
words are linked together to form the name, the first letter of the inner
words should be uppercase (a format that’s sometimes called “CamelCase”). For classes, the names should typically be nouns.

Here are some examples:
Dog
Account
PrintWriter

For interfaces, the names should typically be adjectives, like these:
Runnable
Serializable


Methods The first letter should be lowercase, and then normal CamelCase
rules should be used. In addition, the names should typically be verb-noun pairs.

For example:

getBalance
doCalculation
setCustomerName

Variables Like methods, the CamelCase format should be used, but
starting with a lowercase letter. Oracle recommends short, meaningful
names, which sounds good to us. Some examples:

buttonWidth
accountBalance
myString


Constants Java constants are created by marking variables static and final.
They should be named using uppercase letters with underscore characters
as separators:

MIN_HEIGHT

*/