/** Class that prints the Collatz sequence starting from a given number.
 *  @author YOUR NAME HERE
 */
public class Collatz {

    /** Buggy implementation of nextNumber! */
    public static int nextNumber(int n) {
        if (n==1) return 1;          // if an input int n=1, stop and return 1.
        else if (n%2 == 1) {         // else if the n is an odd number, return 3n+1
            return 3 * n + 1;
        } else {                     // then the n is an even number, return n/2
            return (int) n/2;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.print(n + " ");
        while (n != 1) {
            n = nextNumber(n);
            System.out.print(n + " ");
        }
        System.out.println();
    }
}

