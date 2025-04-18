package LibraryOrganizationJava;

import java.util.Comparator;

/**
 * Enhanced interface for LibraryOrganization.
 *
 * @param <T>
 *            the type of book or entry in the organization
 */
public interface LibraryOrganization<T> extends LibraryOrganizationKernel<T> {

    /**
     * Reverses the order of books in this library organization.
     *
     * @updates this
     * @ensures this = reverse(#this)
     */
    void flip();

    /**
     * Replaces the first book in this library organization with the given book,
     * and returns the old front book.
     *
     * @param x
     *            the new book to place at the front
     * @return the book that was previously at the front
     * @updates this
     * @requires this ≠ <> and x ≠ null
     * @ensures this = <x> * #this[1, |#this| - 1] and replaceFront = #this[0]
     */
    T replaceFront(T x);

    /**
     * Appends all books from the given library organization to the end of this
     * one.
     *
     * @param q
     *            the library organization to append from
     * @updates this, q
     * @requires q ≠ null
     * @ensures this = #this * #q and q = <>
     */
    void append(LibraryOrganization<T> q);

    /**
     * Sorts the books in this library organization using the given comparator.
     *
     * @param comparator
     *            the comparator used to determine order
     * @updates this
     * @requires comparator ≠ null
     * @ensures this is sorted according to comparator
     */
    void sort(Comparator<T> comparator);
}
