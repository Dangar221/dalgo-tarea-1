import java.util.List;

public class CountNumbersArraySorter implements NumbersArraySorter {

    @Override
    public void sort(List<Integer> numbers) {
        if (numbers.size() == 0) return;

        int max = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) > max) max = numbers.get(i);
        }

        int[] count = new int[max + 1];
        for (int i = 0; i < numbers.size(); i++) {
            count[numbers.get(i)]++;
        }

        int idx = 0;
        for (int i = 0; i <= max; i++) {
            for (int j = 0; j < count[i]; j++) {
                numbers.set(idx++, i);
            }
        }
    }
}