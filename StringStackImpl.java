
import java.io.PrintStream;
import java.util.NoSuchElementException;

/**
 * Single-link Stack. Uses {@link Node} for Stack nodes.
 *
 */
public class StringStackImpl<T> implements StringStack<T>{
	
	private Node<T> bottom = null;
	private Node<T> top = null;
	private int t = 0;
	
	/**
	 * Default constructor
	 */
	public StringStackImpl() {
	}
	
	/**
	 * @return true if the stack is empty
	 */
	@Override
	public boolean isEmpty() {
		return top == null;
	}
	
	/**
	 * insert an item to the stack
	 */
	@Override
	public void push(T data) {
		Node <T> n = new Node<>(data);
		
		if (isEmpty()) {
			top = n;
			bottom = n;
		}else {
			top.setNext(n);
			top = n;
		}
		t++;
	}
	
	/**
	 * remove and return the item on the top of the stack
	 * @return the item on the top of the stack
	 * @throws a NoSuchElementException if the stack is empty
	 */
	@Override
	public T pop() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		
		T data = top.getData();
		
		if (top == bottom ) {
			top = bottom = null;
			t = 0;
		}else {
			Node <T> iterator = bottom;
			while (iterator.getNext() != top) {
				iterator = iterator.getNext();
			}
			
			iterator.setNext(null);
			top = iterator;
			t--;
		}
		
		return data;
	}
	
	/**
	 * return without removing the item on the top of the stack
     * @return the item on the top of the stack
	 * @throws a NoSuchElementException if the stack is empty
   	 */
	@Override
	public T peek() throws NoSuchElementException{
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		
		T data = top.getData();
		
		return data;
	}
	
	/**
	 * print the elements of the stack, starting from the item
         * on the top,
	 * to the stream given as argument. For example, 
	 * to print to the standard output you need to pass System.out as
	 * an argument. E.g., 
	 * printStack(System.out); 
	 */
	@Override
	public void printStack(PrintStream stream) {
		
		if (isEmpty()) {
			return;
		}
		T n = pop();
		stream.println(n);
		printStack(stream);
		push(n);
		
	}
	
	/**
     * return the size of the stack, 0 if it is empty
	 * @return the number of items currently in the stack
	 */
	@Override
	public int size() {
		if (isEmpty()) {
			return 0;
		}
		
		return t;
	}
}