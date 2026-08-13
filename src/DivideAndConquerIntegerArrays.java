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
	
	public int searchUnsorted(int value) {
		return searchUnsorted(value, 0, numbers.size()-1);
}
	/**
	 * Finds a position in this numbers between the given limits where the given value is located
	 * @param value to search
	 * @param first index
	 * @param last index
	 * @return int position between first and last where the given value is located
	 */
	
	private int searchUnsorted(int value, int first, int last) {
		if(first == last) return (numbers.get(first)==value)?first:-1;
		int mid=(first+last)/2;
		int s1=searchUnsorted(value,first,mid);
		if(s1>=0) return s1;
		return searchUnsorted(value,mid+1,last);
}

	/**
	 * Finds a position in this numbers where the given value is located
	 * PRE: the numbers are sorted
	 * @param value to search
	 * @return int position where the given value is located
	 */
	
	public int searchSorted(int value) {
				return searchSorted(value, 0, numbers.size()-1);
}
	/**
	 * Finds a position in this numbers between the given limits where the given value is located
	 * PRE: the numbers are sorted
	 * @param value to search
	 * @param first index
	 * @param last index
	 * @return int position between first and last where the given value is located
	 */
	
	private int searchSorted(int value, int first, int last) {
		if(first>last) return -1;
		int mid=(first+last)/2;
		if(numbers.get(mid)==value) return mid;
		if(value<numbers.get(mid)) return searchSorted(value,first,mid-1);
		return searchSorted(value,mid+1,last);
}
	
	/**
	 * Counts the number of even elements in this list of numbers
	 * @return int Number of values that are even
	 */
	public int countEven() {
        return countEven(0, numbers.size()-1);
}
	
	
	/**
	 * Counts the number of even elements in this list of numbers between the given limits
	 * @param first index
	 * @param last index
	 * @return int count of even values within the given limits
	 */
	
	private int countEven (int first, int last) {
        if (first == last) {
                return (numbers.get(first) % 2 == 0) ? 1 : 0;
        }
        int mid = (first + last) / 2;
        return countEven(first, mid) + countEven(mid + 1, last);
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
        return maximumIncreasingSegment(0, numbers.size()-1);
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
        if (first == last) return new int[]{first, last};
        int mid = (first + last) / 2;
        int[] left = maximumIncreasingSegment(first, mid);
        int[] right = maximumIncreasingSegment(mid + 1, last);
        int[] best = (left[1]-left[0] >= right[1]-right[0]) ? left : right;
        if (numbers.get(mid) < numbers.get(mid + 1)) {
                int leftStart = mid;
                while (leftStart > first && numbers.get(leftStart-1) < numbers.get(leftStart)) leftStart--;
                int rightEnd = mid + 1;
                while (rightEnd < last && numbers.get(rightEnd) < numbers.get(rightEnd+1)) rightEnd++;
                int[] combined = new int[]{leftStart, rightEnd};
                if (combined[1]-combined[0] > best[1]-best[0]) best = combined;
        }
        
		return best;
}
}
