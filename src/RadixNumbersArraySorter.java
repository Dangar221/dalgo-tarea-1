import java.util.List;

public class RadixNumbersArraySorter implements NumbersArraySorter {

    @Override
    public void sort(List<Integer> numbers) {
        if (numbers.size() == 0) return;

        int max = numbers.get(0);

        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) > max) {
                max = numbers.get(i);
            }
        }

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(numbers, exp);
        }
    }

    private void countingSort(List<Integer> numbers, int exp) {
        int n = numbers.size();
        int[] output = new int[n];
        int[] count = new int[10];

        for (int i = 0; i < n; i++) {
            int digit = (numbers.get(i) / exp) % 10;
            count[digit]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int digit = (numbers.get(i) / exp) % 10;
            output[count[digit] - 1] = numbers.get(i);
            count[digit]--;
        }

        for (int i = 0; i < n; i++) {
            numbers.set(i, output[i]);
        }
    }
}