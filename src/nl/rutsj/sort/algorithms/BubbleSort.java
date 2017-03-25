package nl.rutsj.sort.algorithms;

/**
 * A step-through implementation of the BubbleSort algorithm.
 * Based on the BubbleSort implementation by Y. Daniel Liang.
 */
public class BubbleSort extends SortingAlgorithm {
    private static final String NAME = "BubbleSort";

    private boolean needNextPass = false;
    private int indexCap = 1;
    private int previousIndex = 0;

    public BubbleSort(int[] list) {
        super(list);
    }

    @Override
    public void step() {
        previousIndex = index;
        // Re-iterate
        if (index >= list.length - indexCap) {
            if (needNextPass) {
                index = 0;
                indexCap++;
                needNextPass = false;
            } else
                return;
        }

        // Swap if greater than
        if (list[index].getValue() > list[index + 1].getValue()) {
            swap(index, index + 1);
            needNextPass = true;
        }

        index++;
        step++;
        updateHighlights();
    }

    @Override
    protected void resetCounters() {
        step = 0;
        indexCap = 1;
        index = 0;
        needNextPass = false;
    }

    @Override
    protected void updateHighlights() {
        list[previousIndex].setHighlight("none");
        list[index].setHighlight("blue");
    }

    public String getName() { return NAME; }
}
