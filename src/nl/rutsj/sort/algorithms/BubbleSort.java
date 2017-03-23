package nl.rutsj.sort.algorithms;

/**
 * A step-through implementation of the BubbleSort algorithm.
 * Based on the BubbleSort implementation by Y. Daniel Liang.
 */
public class BubbleSort extends SortingAlgorithm {
    private static final String NAME = "BubbleSort";

    private boolean needNextPass = false;
    private int indexCap = 1;

    public BubbleSort(int[] list) {
        super(list);
    }

    @Override
    public void step() {
        // Re-iterate
        if (index >= list.length - indexCap) {
            if (needNextPass) {
                index = 0;
                indexCap++;
                needNextPass = false;
            } else {
                return;
            }
        }

        // Swap if greater than
        if (list[index].getValue() > list[index + 1].getValue()) {
            swap(index, index + 1);
            needNextPass = true;
        }

        index++;
        step++;
    }

    // Might be reusable for partition sort
    // If so, move to abstract class with protected access
    private void swap(int i, int j) {
        int temp = list[i].getValue();
        list[i].setValue(list[j].getValue());
        list[j].setValue(temp);
    }

    public String getName() { return NAME; }
}
