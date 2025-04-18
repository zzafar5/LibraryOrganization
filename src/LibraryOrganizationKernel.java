import components.standard.Standard;

/**
 * Kernel interface for LibraryOrganization.
 *
 * @param <T>
 *            the type of book or entry in the organization
 */
public interface LibraryOrganizationKernel<T>
        extends Standard<LibraryOrganization<T>> {

    /**
     * Adds a book to the end of this library organization.
     *
     * @param x
     *            the book to add
     * @updates this
     * @requires x ≠ null
     * @ensures this = #this * <x>
     */
    void enqueue(T x);

    /**
     * Removes and returns the first book in this library organization.
     *
     * @return the book at the front
     * @updates this
     * @requires this ≠ <>
     * @ensures <return> is the first entry of #this and this = #this[1, |#this|
     *          - 1]
     */
    T dequeue();

    /**
     * Reports the number of books in this library organization.
     *
     * @return the number of entries
     * @ensures length = |this|
     */
    int length();
}

/**
 * Reports the front entry in this LibraryOrganization.
 *
 * @return the front entry
 * @requires this ≠ <>
 * @ensures front = #this[0]
 */
