

package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove(){
        AListNoResizing<Integer> noBug = new AListNoResizing<>();
        BuggyAList<Integer> yesBug = new BuggyAList<Integer>();

        for (int i=1; i < 4; i++) {     //1, 2, 3 추가
            noBug.addLast(i);
            yesBug.addLast(i);
        }

        for (int j=0; j < 3; j++) {  // 3번 실행
            assertEquals(noBug.removeLast(), yesBug.removeLast());
        }
    }

    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> noBug = new AListNoResizing<>();
        BuggyAList<Integer> yesBug = new BuggyAList<Integer>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);

            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                noBug.addLast(randVal);
                yesBug.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int sizeN = noBug.size();
                int sizeY = yesBug.size();
                assertEquals(sizeN, sizeY);
                System.out.println("size: " + sizeN + ", " + sizeY);
            } else if (operationNumber == 2) {
                //getLast
                if ((yesBug.size() > 0) && (noBug.size()> 0)){
                    int getLastY = yesBug.getLast();
                    int getLastN = noBug.getLast();
                    assertEquals(noBug.getLast(), yesBug.getLast());
                    System.out.println("getLast = " + noBug.getLast() + ", " + yesBug.getLast());
                }
            } else if (operationNumber == 3) {
                //removeLast
                if ((yesBug.size() > 0) && (noBug.size()> 0)){
                    int removeLastY = yesBug.removeLast();
                    int removeLastN = noBug.removeLast();
                    if (removeLastN == removeLastY) assertEquals(removeLastN, removeLastY);
                    System.out.println("removeLast = " + removeLastN + ", " + removeLastY);
                }
            }
        }
    }
}