import java.util.ArrayList;
import java.util.List;

/**
 * Implements the merge sort algorithm for number arrays
 */
public class MergeNumbersArraySorter implements NumbersArraySorter {

	@Override
	public void sort(List<Integer> numbers) {
		mergeSort(numbers, 0, numbers.size() - 1);
	}
	
	private void mergeSort(List<Integer> numbers, int first, int last) {
		if (first >= last) return;
		int mid = (first + last) / 2;
		mergeSort(numbers, first, mid);
		mergeSort(numbers, mid + 1, last);
		merge(numbers, first, mid, last);
	}

	private void merge(List<Integer> numbers, int first, int mid, int last) {
		List<Integer> temp = new ArrayList<>();
		int i = first, j = mid + 1;
		while (i <= mid && j <= last) {
			if (numbers.get(i) <= numbers.get(j)) temp.add(numbers.get(i++));
			else temp.add(numbers.get(j++));
		}
		while (i <= mid) temp.add(numbers.get(i++));
		while (j <= last) temp.add(numbers.get(j++));
		for (int k = 0; k < temp.size(); k++) numbers.set(first + k, temp.get(k));
	}
}
