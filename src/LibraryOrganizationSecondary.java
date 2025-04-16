import java.util.Comparator;


public abstract class LibraryOrganizationSecondary<T> {
    //  Implement each method from your enhanced interface
    //    (using only kernel + standard methods)

    @Override
    public void flip() {
        if (this.length() > 0) {
            T first = this.dequeue();
            this.flip();
            this.enqueue(first);
        }
    }

    @Override
    public T replaceFront(T x) {
        T old = this.dequeue();
        this.enqueue(x);
        return old;
    }

    @Override
    public void append(LibraryOrganization<T> q) {
        while (q.length() > 0) {
            this.enqueue(q.dequeue());
        }
    }

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

}
