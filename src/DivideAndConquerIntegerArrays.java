import java.util.ArrayList;

public class DivideAndConquerIntegerArrays {

	// Array of numbers
	private ArrayList<Integer> numbers;

	/**
	 * Creates a new object with the given numbers
	 * @param numbers
	 */
	public DivideAndConquerIntegerArrays(ArrayList<Integer> numbers) {
		this.numbers = numbers;
	}
	
	/**
	 * Calculates the maximum value in this list
	 * @return int Maximum value in the list
	 */
	public int max() {
		//Implementar en una linea utilizando el siguiente metodo
		return max(0,numbers.size()-1);
	}
	
	/**
	 * Calculates the maximum value within the given indexes
	 * @param first index
	 * @param last index
	 * @return int maximum value within the given limits
	 */
	private int max (int first, int last) {
		if(first==last) return numbers.get(first);
		int m = (first+last)/2;
		int s1 = max(first, m);
		int s2 = max(m+1, last);
		return Math.max(s1,s2);
	}
	/**
	 * Finds a position in this numbers where the given value is located
	 * @param value to search
	 * @return int position where the given value is located
	 */
	public int searchUnsorted (int value) {
		//TODO: implementar en una linea utilizando el siguiente metodo
		return -1;
	}
	/**
	 * Finds a position in this numbers between the given limits where the given value is located
	 * @param value to search
	 * @param first index
	 * @param last index
	 * @return int position between first and last where the given value is located
	 */
	private int searchUnsorted (int value, int first, int last) {
		//TODO: Implementar utilizando la tecnica de dividir y conquistar
		return -1;
	}
	/**
	 * Finds a position in this numbers where the given value is located
	 * PRE: the numbers are sorted
	 * @param value to search
	 * @return int position where the given value is located
	 */
	public int searchSorted (int value) {
		//TODO: implementar en una linea utilizando el siguiente metodo
		return -1;
	}
	/**
	 * Finds a position in this numbers between the given limits where the given value is located
	 * PRE: the numbers are sorted
	 * @param value to search
	 * @param first index
	 * @param last index
	 * @return int position between first and last where the given value is located
	 */
	private int searchSorted (int value, int first, int last) {
		//TODO: Implementar busqueda binaria
		return -1;
	}
	
	/**
	 * Counts the number of even elements in this list of numbers
	 * @return int Number of values that are even
	 */
	public int countEven() {
		//TODO: implementar en una linea utilizando el siguiente metodo
		return 0;
	}
	
	/**
	 * Counts the number of even elements in this list of numbers between the given limits
	 * @param first index
	 * @param last index
	 * @return int count of even values within the given limits
	 */
	private int countEven (int first, int last) {
		//TODO: Implementar utilizando la tecnica de dividir y conquistar
		return 0;
	}
	/**
	 * Calculates the start and the end index of the segment of maximum length 
	 * in which numbers are increasing
	 * @return int [] Array with two positions. The first position must have the index of the
	 * first position of the segment. The second position must have the index of the last position
	 * of the segment.
	 * For example, if the array is [4,6,1,3,8,9,2,23,12], the answer must be the array [2,5]
	 */
	public int [] maximumIncreasingSegment() {
		//TODO: implementar en una linea utilizando el siguiente metodo
		return null;
	}
	
	/**
	 * Calculates the start and the end index of the segment of maximum length in which numbers are increasing
	 * for the subarray the positions first and last 
	 * @param first index
	 * @param last index
	 * @return int [] Array with two positions. The first position must have the index of the
	 * first position of the segment. The second position must have the index of the last position
	 * of the segment.
	 */
	private int [] maximumIncreasingSegment(int first, int last) {
		//TODO: implementar utilizando la tecnica de dividir y conquistar
		return null;
	}
}
