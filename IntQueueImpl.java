

import java.io.PrintStream;
import java.util.NoSuchElementException;

/**
 * Single-link Queue. Uses {@link Node} for Queue nodes.
 *
 */
public class IntQueueImpl<T> implements IntQueue<T>{
	
	private Node<T> front = null;
	private Node<T> rear = null;
	private int f = 0;
	private int r = 0;
	
	/**
	 * Default constructor
	 */
	public IntQueueImpl() {
	}
	
	/**
	 * @return true if the queue is empty
	 */
	@Override
	public boolean isEmpty() {
		return front == null;
	}
	
	/**
	 * insert an item to the queue
	 */
	@Override
	public void put (T data) {
		Node <T> n = new Node<>(data);
		
		if (isEmpty()) {
			front = n;
			rear = n;
		} else {
			rear.setNext(n);
			rear = n;
		}
		r++;
	}
	
	/**
 	 * remove and return the oldest item of the queue
 	 * @return oldest item of the queue
	 * @throws NoSuchElementException if the queue is empty
	 */
	@Override
	public T get() throws NoSuchElementException{
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		
		T data = front.getData();
		
		if (front == rear) {
			front = rear = null;
			f = 0;
			r = 0;
		}else {
			front =front.getNext();
			f++;
		}
		
		return data;
	}
	
	/**
	 * return without removing the oldest item of the queue
 	 * @return oldest item of the queue
	 * @throws NoSuchElementException if the queue is empty
	 */
	@Override
	public T peek() throws NoSuchElementException{
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		
		T data = front.getData();
		
		return data;
		
	}
	
	/**
	 * print the elements of the queue, starting from the oldest 
         * item, to the print stream given as argument. For example, to 
         * print the elements to the
	 * standard output, pass System.out as parameter. E.g.,
	 * printQueue(System.out);
	 */
	@Override
	public void printQueue(PrintStream stream) {
		
		Node <T> n = front;
		
		while(n != null) {
			stream.println(n.getData());
			n = n.getNext();
		}
	}
	
	/**
	 * return the size of the queue, 0 if it is empty
	 * @return number of elements in the queue
	 */
	@Override
	public int size() {
		if (isEmpty()) {
			return 0;
		}
		
		int s = r - f;
		
		return s;
	}
	
}