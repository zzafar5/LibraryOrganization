import java.util.Comparator;

/**
 * Secondary (abstract) implementation of LibraryOrganization. Implements
 * enhanced interface methods using kernel operations.
 *
 * @param <T>
 *            the type of elements stored in this LibraryOrganization
 */
public abstract class LibraryOrganizationSecondary<T>
        implements LibraryOrganization<T> {

    /**
     * Reverses the order of the entries in this LibraryOrganization.
     *
     * @updates this
     * @ensures this = reverse(#this)
     */
    @Override
    public void flip() {
        if (this.length() > 0) {
            T first = this.dequeue();
            this.flip();
            this.enqueue(first);
        }
    }

    /**
     * Replaces the front entry with a new one and returns the original front
     * entry.
     *
     * @param x
     *            the new entry to place at the front
     * @return the original front entry
     * @updates this
     * @requires this ≠ <> and x ≠ null
     * @ensures this = <x> * #this[1, |#this| - 1] and replaceFront = #this[0]
     */
    @Override
    public T replaceFront(T x) {
        T old = this.dequeue();
        this.enqueue(x);
        return old;
    }

    /**
     * Appends all entries from the given LibraryOrganization to the end of this
     * one.
     *
     * @param q
     *            the LibraryOrganization to append from
     * @updates this, q
     * @requires q ≠ null
     * @ensures this = #this * #q and q = <>
     */
    @Override
    public void append(LibraryOrganization<T> q) {
        while (q.length() > 0) {
            this.enqueue(q.dequeue());
        }
    }

    /**
     * Sorts the entries in this LibraryOrganization using the given comparator.
     *
     * @param comp
     *            the comparator used to determine sort order
     * @updates this
     * @requires comp ≠ null
     * @ensures this is sorted according to comp
     */
    @Override
    public void sort(Comparator<T> comp) {
        int size = this.length();
        for (int i = 0; i < size; i++) {
            T smallest = this.dequeue();
            for (int j = 1; j < size - i; j++) {
                T current = this.dequeue();
                if (comp.compare(current, smallest) < 0) {
                    this.enqueue(smallest);
                    smallest = current;
                } else {
                    this.enqueue(current);
                }
            }
            this.enqueue(smallest);
        }
    }

    /**
     * Returns a comma-separated string of the entries in this
     * LibraryOrganization.
     *
     * @return a string representation of the entries
     */
    @Override
    public String toString() {
        String result = "";
        LibraryOrganization<T> temp = this.newInstance();
        int size = this.length();

        for (int i = 0; i < size; i++) {
            T item = this.dequeue();
            result += item;
            if (i < size - 1) {
                result += ", ";
            }
            temp.enqueue(item);
        }

        while (temp.length() > 0) {
            this.enqueue(temp.dequeue());
        }

        return result;
    }

    /**
     * Compares this LibraryOrganization to another for equality.
     *
     * @param obj
     *            the object to compare
     * @return true if both contain the same entries in the same order, false
     *         otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof LibraryOrganization)) {
            return false;
        }

        LibraryOrganization<T> other = (LibraryOrganization<T>) obj;

        if (this.length() != other.length()) {
            return false;
        }

        LibraryOrganization<T> tempThis = this.newInstance();
        LibraryOrganization<T> tempOther = this.newInstance();

        while (this.length() > 0) {
            T a = this.dequeue();
            T b = other.dequeue();

            if (!a.equals(b)) {
                tempThis.enqueue(a);
                tempOther.enqueue(b);

                while (this.length() > 0) {
                    tempThis.enqueue(this.dequeue());
                }
                while (other.length() > 0) {
                    tempOther.enqueue(other.dequeue());
                }
                while (tempThis.length() > 0) {
                    this.enqueue(tempThis.dequeue());
                    other.enqueue(tempOther.dequeue());
                }

                return false;
            }

            tempThis.enqueue(a);
            tempOther.enqueue(b);
        }

        while (tempThis.length() > 0) {
            this.enqueue(tempThis.dequeue());
            other.enqueue(tempOther.dequeue());
        }

        return true;
    }
}
