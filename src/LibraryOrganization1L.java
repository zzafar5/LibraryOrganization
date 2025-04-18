import components.queue.Queue;
import components.queue.Queue1L;

/**
 * Kernel implementation for the LibraryOrganization component.
 *
 * @param <T>
 *            the type of books or entries in the organization
 * @convention entries is never null
 * @correspondence this = entries as a queue of T
 */
public class LibraryOrganization1L<T> extends LibraryOrganizationSecondary<T>
        implements LibraryOrganization<T> {

    private Queue<T> entries;

    /**
     * Constructor for LibraryOrganization1L. Initializes the entries queue.
     */
    public LibraryOrganization1L() {
        this.entries = new Queue1L<>();
    }

    /**
     * Creates and returns a new instance of LibraryOrganization.
     *
     * @return a new empty instance of LibraryOrganization
     */
    @Override
    public LibraryOrganization<T> newInstance() {
        return new LibraryOrganization1L<>();
    }

    /**
     * Adds an entry to the end of this LibraryOrganization.
     *
     * @param x
     *            the item to enqueue
     * @updates this
     * @requires x ≠ null
     * @ensures this = #this * <x>
     */
    @Override
    public void enqueue(T x) {
        this.entries.enqueue(x);
    }

    /**
     * Removes and returns the front entry of this LibraryOrganization.
     *
     * @return the item removed from the front
     * @updates this
     * @requires this ≠ <>
     * @ensures <return> is the first of #this and this = #this[1, |#this| - 1]
     */
    @Override
    public T dequeue() {
        return this.entries.dequeue();
    }

    /**
     * Returns the number of entries in this LibraryOrganization.
     *
     * @return the number of elements
     * @ensures length = |this|
     */
    @Override
    public int length() {
        return this.entries.length();
    }

    /**
     * Clears all entries from this LibraryOrganization.
     *
     * @updates this
     * @ensures this = <>
     */
    @Override
    public void clear() {
        this.entries.clear();
    }

    /**
     * Transfers the contents of source into this LibraryOrganization.
     *
     * @param source
     *            the source to transfer from
     * @updates this
     * @clears source
     * @requires source ≠ null and source ≠ this
     * @ensures this = #source and source = <>
     */
    @Override
    public void transferFrom(LibraryOrganization<T> source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";

        LibraryOrganization1L<T> localSource = (LibraryOrganization1L<T>) source;
        this.entries = localSource.entries;
        localSource.entries = new Queue1L<>();
    }
}
