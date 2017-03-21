package nl.rutsj.sort.Algorithms;

public class BubbleSort extends SortingAlgorithm {

    public BubbleSort(int[] list) {
        super(list);
    }

    @Override
    public void step() {
        if(!this.isSorted()) {
            // Re-iterate
            if (index >= list.length - 1)
                index = 0;

            // Swap if greater than
            if (list[index] > list[index + 1])
                swap(index, index + 1);

            index++;
            step++;
        }

    }

    // Might be reusable for partition sort
    // If so, move to abstract class with protected access
    private void swap(int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
}
