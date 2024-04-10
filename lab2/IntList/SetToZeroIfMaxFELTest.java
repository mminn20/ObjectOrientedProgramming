package IntList;

import static org.junit.Assert.*;
import org.junit.Test;

public class SetToZeroIfMaxFELTest {

    @Test
    public void testZeroOutFELMaxes1() {
        IntList L = IntList.of(1, 22, 15);
        IntListExercises.setToZeroIfMaxFEL(L);
        assertEquals("0 -> 0 -> 15", L.toString());
    }

    @Test
    public void testZeroOutFELMaxes2() {
        IntList L = IntList.of(55, 22, 45, 44, 5);
        IntListExercises.setToZeroIfMaxFEL(L);
        assertEquals("0 -> 22 -> 45 -> 0 -> 0", L.toString());
    }

    @Test
    public void testZeroOutFELMaxes3() {
        IntList L = IntList.of(5, 535, 35, 11, 10, 0);
        IntListExercises.setToZeroIfMaxFEL(L);
        assertEquals("0 -> 0 -> 35 -> 0 -> 10 -> 0", L.toString());
        // wrongActual : 0 -> 0 - > 35 -> 0 -> 0 -> 0

        /* 1. IntList 에서 자신과 나머지 원소 중 가장 큰지 확인
        * 1 -1. 자신이 가장 클 때, 좌우 숫자가 동일하면 0 반환
        * 1 -2. 자신이 가장 클 때, 좌우 숫자가 다르면 '자신'을 반환
        * 2 -1. 다른 수가 더 클 때,
        * 1) 그 수의 좌우가 다르면 '자신'을 반환
        * 2) 그 수의 좌우가 동일하면 0 반환
         */
    }
}
