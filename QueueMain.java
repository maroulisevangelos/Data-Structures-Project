

import java.io.PrintStream;
import java.util.NoSuchElementException;

public class QueueMain {
    public static void main(String[] args) {
        // Create an empty queue
        IntQueueImpl<Video> q = new IntQueueImpl<>(); //Queue is implicitly declared as Video

        try {
            // Print empty Queue
            q.printQueue(System.out);
            
            // isEmpty
            System.out.println("The queue is empty: " + q.isEmpty());
            
            // size
            System.out.println("The size of the queue is: " + q.size());
            
            // Add two elements 
            q.put(new Video("Η οικονομία της προσοχής", "https://www.youtube.com/watch?v=sQXubDsT9zs", 126223));
            q.printQueue(System.out);

            q.put(new Video("\"You do NOT understand weddings. AT ALL.\"", "https://www.youtube.com/watch?v=p6ZojleXMn4", 3995738));
            q.printQueue(System.out);

            // Add two elements
            q.put(new Video("Golden Retriever can't get enough of Australian Open tennis", "https://www.youtube.com/watch?v=kZm6RwukFCc", 1235033));
            q.printQueue(System.out);

            q.put(new Video("Dog on a Roomba - Easter Edition!!!", "https://www.youtube.com/watch?v=MLS0ExHWbiA", 618801));
            q.printQueue(System.out);
            
            // isEmpty
            System.out.println("The queue is empty: " + q.isEmpty());
            
            // size
            System.out.println("The size of the queue is: " + q.size());
            
            // Remove 
            Video removed = q.get();
            System.out.println(removed.getTitle() + " just got removed");
            
            // Peek
            removed = q.peek();
            System.out.println(removed.getTitle() + " just got peeked");

            // Remove 
            removed = q.get();
            System.out.println(removed.getTitle() + " just got removed");

            // Print
            q.printQueue(System.out);

            // keep removing until an exception is thrown
            System.out.println("Keep removing from queue!");
            // 100 in case something goes wrong, to prevent endless loop
            for (int i = 0; i < 100; ++i) {
            	
            	// Remove
                removed = q.get();
                System.out.println(removed.getTitle() + " just got removed");

                // Peek
                removed = q.peek();
                System.out.println(removed.getTitle() + " just got peeked");
            }
        } catch (NoSuchElementException ex) {
            System.out.println("Tried to remove from an empty queue!");
        }
    }
}