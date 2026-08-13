/**
 * Implementation of a linked list with recursive methods
 */
public class RecursiveIntegerLinkedList {

	//Number in this position of the list
	private int number;
	//Tells if this object represents an empty list
	private boolean empty;
	//Next element of the list. null if this is the last element of a list
	private RecursiveIntegerLinkedList next;
	//Last element of the list. It should only be used by the head of a list in the add method
	private RecursiveIntegerLinkedList last;
	
	/**
	 * Creates an empty list
	 */
	public RecursiveIntegerLinkedList () {
		next = last = null;
		empty = true;
	}
	/**
	 * Creates a list with the given value
	 * @param value to be added to the list
	 */
	public RecursiveIntegerLinkedList (int value) {
		number = value;
		next = null;
		last = this;
		empty = false;
	}
	/**
	 * Adds the value at the end of the current list
	 * @param value to be added at the end
	 */
	public void add (int value) {
		if(empty) {
			number = value;
			last = this;
			empty= false;
		} else {
			RecursiveIntegerLinkedList newLast = new RecursiveIntegerLinkedList(value);
			last.next = newLast;
			last = newLast;
		}
	}
	
	/**
	 * Returns the element in the current position of the list
	 * @param pos position in the list
	 * @return int the value present at the given position.
	 * @throws ArrayIndexOutOfBoundsException if the given position is invalid
	 */
	public int get (int pos) {
		if(empty) throw new ArrayIndexOutOfBoundsException("Get can not be used on an empty list");
		if(pos ==0) return number;
		if(next == null) throw new ArrayIndexOutOfBoundsException("Invalid argument for get: "+pos);
		int pos2 = pos-1;
		return next.get(pos2);
	}
	/**
	 * Calculates the size of the list
	 * @return int Size of the list
	 */
	public int size () {
		if(empty) return 0;
		if(next == null) return 1;
		int sizeSublist = next.size();
		return sizeSublist+1;
	}
	/**
	 * Calculates the maximum value in the list
	 * @return int Maximum value
	 */
	public int max () {
		if(empty) return Integer.MIN_VALUE;
		if(next == null) return number;
		int maxSublist = next.max();
		return Math.max(number, maxSublist);

	}
	
	/**
	 * Returns the index of the first appearance of the given value
	 * @param value to be searched
	 * @return int position of the list whare the value is located
	 */
	public int indexOf(int value) {
		if (empty) return -1;
		if (number == value) return 0;
		if (next == null) return -1;
		int posSublist = next.indexOf(value);
		if (posSublist == -1) return -1;
		return posSublist + 1;
	}
	
	/**
	 * Returns the index of the last appearance of the given value
	 * @param value to be searched
	 * @return int position of the list whare the value is located
	 */
	public int lastIndexOf(int value) {
		if (empty) return -1;
		int posSublist = -1;
		if (next != null) posSublist = next.lastIndexOf(value);
		if (posSublist >= 0) return posSublist + 1;
		if (number == value) return 0;
		return -1;
	}
	/**
	 * Counts the number of even elements in the list
	 * @return int Number of values that are even
	 */
	public int countEven () {
		if (empty) return 0;
		int countSublist = (next != null) ? next.countEven() : 0;
		int countCurrent = (number % 2 == 0) ? 1 : 0;
		return countCurrent + countSublist;

	}
	
	/**
	 * Tells if the list is sorted
	 * @return boolean if the list is sorted by value. False otherwise
	 */
	public boolean isSorted () {
		if (empty) return true;
		if (next == null) return true;
		if (number > next.number) return false;
		return next.isSorted();
	}
}
