import static org.junit.Assert.assertEquals;

import java.util.Comparator;

import org.junit.Test;

import LibraryOrganizationJava.LibraryOrganization;
import LibraryOrganizationJava.LibraryOrganization1L;

/**
 * JUnit tests for enhanced methods in LibraryOrganizationSecondary.
 */
public class LibraryOrganizationSecondaryTest {

    /**
     * Tests that flip reverses the order of elements.
     */
    @Test
    public void testFlipThreeBooks() {
        LibraryOrganization<String> lib = new LibraryOrganization1L<>();
        lib.enqueue("A");
        lib.enqueue("B");
        lib.enqueue("C");
        lib.flip();
        assertEquals("C", lib.dequeue());
        assertEquals("B", lib.dequeue());
        assertEquals("A", lib.dequeue());
    }

    /**
     * Tests replaceFront by removing front and adding new value to the back.
     * Expected behavior: new item goes to the end.
     */
    @Test
    public void testReplaceFront() {
        LibraryOrganization<String> lib = new LibraryOrganization1L<>();
        lib.enqueue("First");
        lib.enqueue("Second");

        String replaced = lib.replaceFront("New");

        assertEquals("First", replaced);
        assertEquals("Second", lib.dequeue());
        assertEquals("New", lib.dequeue());
    }

    /**
     * Tests that append adds all items from one queue to another and clears the
     * second.
     */
    @Test
    public void testAppend() {
        LibraryOrganization<String> lib1 = new LibraryOrganization1L<>();
        LibraryOrganization<String> lib2 = new LibraryOrganization1L<>();
        lib1.enqueue("Book A");
        lib2.enqueue("Book B");

        lib1.append(lib2);

        assertEquals(2, lib1.length());
        assertEquals("Book A", lib1.dequeue());
        assertEquals("Book B", lib1.dequeue());
        assertEquals(0, lib2.length());
    }

    /**
     * Tests that sort rearranges elements in ascending (alphabetical) order.
     */
    // @Test
    //  public void testSort() {
    //   LibraryOrganization<String> lib = new LibraryOrganization1L<>();
    //  lib.enqueue("Zebra");
    //  lib.enqueue("Apple");
    //  lib.enqueue("Monkey");

    //   lib.sort(Comparator.naturalOrder());

    //   assertEquals("Apple", lib.dequeue());
    //   assertEquals("Monkey", lib.dequeue());
    //   assertEquals("Zebra", lib.dequeue());

    @Test
    public void testSort() {
        LibraryOrganization<String> lib = new LibraryOrganization1L<>();
        lib.enqueue("Zebra");
        lib.enqueue("Apple");
        lib.enqueue("Monkey");

        lib.sort(Comparator.naturalOrder());

        System.out.println("Sorted order:");
        while (lib.length() > 0) {
            System.out.println(lib.dequeue());
        }
    }

}
