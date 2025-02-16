

import java.io.PrintStream;
import java.util.NoSuchElementException;

public class StackMain {
    public static void main(String[] args) {
        // Create an empty stack
        StringStackImpl<Video> st = new StringStackImpl<>(); //Stack is implicitly declared as Video

        try {
            // Print empty Stack
            st.printStack(System.out);
            
            // isEmpty
            System.out.println("The queue is empty: " + st.isEmpty());
            
            // size
            System.out.println("The size of the queue is: " + st.size());
            
            // Add two elements 
            st.push(new Video("Η οικονομία της προσοχής", "https://www.youtube.com/watch?v=sQXubDsT9zs", 126223));
            st.printStack(System.out);

            st.push(new Video("\"You do NOT understand weddings. AT ALL.\"", "https://www.youtube.com/watch?v=p6ZojleXMn4", 3995738));
            st.printStack(System.out);

            // Add two elements
            st.push(new Video("Golden Retriever can't get enough of Australian Open tennis", "https://www.youtube.com/watch?v=kZm6RwukFCc", 1235033));
            st.printStack(System.out);

            st.push(new Video("Dog on a Roomba - Easter Edition!!!", "https://www.youtube.com/watch?v=MLS0ExHWbiA", 618801));
            st.printStack(System.out);
            
            // isEmpty
            System.out.println("The queue is empty: " + st.isEmpty());
            
            // size
            System.out.println("The size of the queue is: " + st.size());
            
            // Remove 
            Video removed = st.pop();
            System.out.println(removed.getTitle() + " just got removed");
            
            // Peek
            removed = st.peek();
            System.out.println(removed.getTitle() + " just got peeked");

            // Remove 
            removed = st.pop();
            System.out.println(removed.getTitle() + " just got removed");

            // Print
            st.printStack(System.out);

            // keep removing until an exception is thrown
            System.out.println("Keep removing from stack!");
            // 100 in case something goes wrong, to prevent endless loop
            for (int i = 0; i < 100; ++i) {
            	
            	// Remove
                removed = st.pop();
                System.out.println(removed.getTitle() + " just got removed");

                // Peek
                removed = st.peek();
                System.out.println(removed.getTitle() + " just got peeked");
            }
        } catch (NoSuchElementException ex) {
            System.out.println("Tried to remove from an empty queue!");
        }
    }
}