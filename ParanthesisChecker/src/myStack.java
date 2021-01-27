/**
 * The {@code myStack} class makes stack operations pop,push and peek
 * @author Berk Gokberk
 * @version 1.0
 * @since 29.10.2017
 */
import java.util.Iterator;
import java.util.NoSuchElementException;

public class myStack<Item> implements Iterable<Item> {
	private Item[] a; // array of items
	private int n; // number of elements on stack
	public myStack() {
		a = (Item[]) new Object[2];
		n = 0;
	}
	/**
	 * 
	 * @return empty stack size
	 */
	public boolean isEmpty() { return n == 0; }
	/**
	 * 
	 * @return n(size of stack)
	 */
	public int size() { return n; }
	/**
	 * 
	 * @param capacity calue for change size of stack 
	 */
	private void resize(int capacity) {
		assert capacity >= n;
		Item[] temp = (Item[]) new Object[capacity];
		for (int i = 0; i < n; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}
	/**
	 * 
	 * @param item for add new element to stack
	 */
	public void push(Item item) {
		if (n == a.length) {
			resize(2 * a.length); // double size of array if necessary
			System.out.print("\n\n << stack doubled >> \n\n");
		}
		a[n++] = item; // add item
	}
	/**
	 * @throws java.util.NoSuchElementException 
	 * if stack is empty
	 * @return item that element get out from the stack
	 */
	public Item pop() {
		if (isEmpty())
			throw new NoSuchElementException("Stack underflow");
		Item item = a[n - 1];
		a[n - 1] = null; // to avoid loitering
		n--;
		// shrink size of array if necessary
		if (n > 0 && n == a.length / 4)
			resize(a.length / 2);
		return item;
	}
	/**
	 * throws java.util.NoSuchElementException 
	 * if stack is empty
	 * @return a[n-1] that represents last element of the stack 
	 */
	public Item peek() {
		if (isEmpty())
			throw new NoSuchElementException("Stack underflow");
		return a[n - 1];
	}
	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}
	private class ReverseArrayIterator implements Iterator<Item> {
		private int i;
		public ReverseArrayIterator() { i = n - 1; }
		public boolean hasNext() { return i >= 0; }
		public void remove() { throw new UnsupportedOperationException(); }
		public Item next() {
			if (!hasNext())
				throw new NoSuchElementException();
			return a[i--];
		}
	}

}