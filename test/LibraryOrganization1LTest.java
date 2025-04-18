import static org.junit.Assert.assertEquals;

import org.junit.Test;

import LibraryOrganizationJava.LibraryOrganization;
import LibraryOrganizationJava.LibraryOrganization1L;

/**
 * JUnit tests for enhanced methods in LibraryOrganizationSecondary.
 */
public class LibraryOrganization1LTest {

    /**
     * Tests that dequeue removes and returns the first item.
     */

    @Test
    public void testDequeueAfterEnqueue() {
        LibraryOrganization<String> lib = new LibraryOrganization1L<>();
        lib.enqueue("Book A");
        String result = lib.dequeue();
        assertEquals("Book A", result);
    }

    /**
     * Tests that clear removes all elements, resulting in a length of zero.
     */
    @Test
    public void testLengthAfterClear() {
        LibraryOrganization<String> lib = new LibraryOrganization1L<>();
        lib.enqueue("Book A");
        lib.enqueue("Book B");
        lib.clear();
        assertEquals(0, lib.length());
    }

    /**
     * Tests that transferFrom correctly transfers the contents from another
     * instance.
     */
    @Test
    public void testTransferFrom() {
        LibraryOrganization<String> lib1 = new LibraryOrganization1L<>();
        LibraryOrganization<String> lib2 = new LibraryOrganization1L<>();
        lib2.enqueue("Book A");
        lib1.transferFrom(lib2);
        assertEquals(1, lib1.length());
        assertEquals(0, lib2.length());
    }
}
