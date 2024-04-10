package deque;

import org.junit.Test;

import static org.junit.Assert.*;


/** Performs some basic linked list tests. */
public class ArrayDequeTest {

    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<String> arrayD = new ArrayDeque<String>();

		assertTrue("A newly initialized LLDeque should be empty", arrayD.isEmpty());
		arrayD.addFirst("front");

		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, arrayD.size());
        assertFalse("arrayD should now contain 1 item", arrayD.isEmpty());

		arrayD.addLast("middle");
		assertEquals(2, arrayD.size());

		arrayD.addLast("back");
		assertEquals(3, arrayD.size());

		System.out.println("Printing out deque: ");
		arrayD.printDeque();

    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<Integer> arrayD = new ArrayDeque<Integer>();
		// should be empty
		assertTrue("arrayD should be empty upon initialization", arrayD.isEmpty());

		arrayD.addFirst(10);
		// should not be empty
		assertFalse("arrayD should contain 1 item", arrayD.isEmpty());

		arrayD.removeFirst();
		// should be empty
		assertTrue("arrayD should be empty after removal", arrayD.isEmpty());

    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<Integer> arrayD = new ArrayDeque<>();
        arrayD.addFirst(3);

        arrayD.removeLast();
        arrayD.removeFirst();
        arrayD.removeLast();
        arrayD.removeFirst();

        int size = arrayD.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);

    }

    @Test
    /* Check if you can create LinkedListDeques with different parameterized types*/
    public void multipleParamTest() {


        ArrayDeque<String>  arrayD1 = new ArrayDeque<String>();
        ArrayDeque<Double>  arrayD2 = new ArrayDeque<Double>();
        ArrayDeque<Boolean> arrayD3 = new ArrayDeque<Boolean>();

        arrayD1.addFirst("string");
        arrayD2.addFirst(3.14159);
        arrayD3.addFirst(true);

        String s = arrayD1.removeFirst();
        double d = arrayD2.removeFirst();
        boolean b = arrayD3.removeFirst();

    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void emptyNullReturnTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<Integer> arrayD = new ArrayDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, arrayD.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, arrayD.removeLast());


    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<Integer> arrayD = new ArrayDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            arrayD.addLast(i);
//            arrayD.printDeque();
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) arrayD.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) arrayD.removeLast(), 0.0);
        }

    }

}
