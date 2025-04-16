
import components.queue.Queue;
import components.queue.Queue1L;

    /**
     * Kernel implementation for the LibraryOrganization component.
     *
     * @convention entries is never null
     * @correspondence this = entries as a queue of T
     */
    public class LibraryOrganization1L<T> extends LibraryOrganizationSecondary<T> {

        private Queue<T> entries; // Internal representation

        /**
         * Constructor for LibraryOrganization1L
         * Initializes the entries queue
         */
        public LibraryOrganization1L() {
            this.entries = new Queue1L<>();  // Initialize with OSU Queue1L
        }

        @Override
        public LibraryOrganization<T> newInstance() {
            return new LibraryOrganization1L<>();  // Create a new instance
        }

        @Override
        public void enqueue(T x) {
            this.entries.enqueue(x);  // Enqueue the item
        }

        @Override
        public T dequeue() {
            return this.entries.dequeue();  // Dequeue an item
        }

        @Override
        public T front() {
            return this.entries.front();  // Peek at the front item
        }

        @Override
        public int length() {
            return this.entries.length();  // Return the size of the queue
        }

        @Override
        public void clear() {
            this.entries.clear();  // Clear the queue
        }
    }

}
