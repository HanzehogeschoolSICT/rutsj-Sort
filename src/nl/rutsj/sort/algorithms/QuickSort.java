package nl.rutsj.sort.algorithms;

import java.util.Stack;

/**
 * A step-through implementation of the QuickSort algorithm.
 */
public class QuickSort extends SortingAlgorithm {
    private static final String NAME = "QuickSort";

    private int pivot = 0;
    private int low = 1;
    private int high = list.length - 1;
    private int minIndex = 0;
    private int maxIndex = list.length - 1;
    private boolean isSorting = true;
    private Stack<ListIndexPair> toSort = new Stack<>();

    private int previousPivot = pivot;
    private int previousLow = low;
    private int previousHigh = high;

    public QuickSort(int[] list) {
        super(list);
    }

    @Override
    public void step() {
        saveCounters();

        if (!isSorting && !toSort.empty()) {
            ListIndexPair pair = toSort.pop();
            pivot = pair.getLow();
            low = pivot + 1;
            high = pair.getHigh();
            minIndex = pivot;
            maxIndex = high;

            isSorting = true;
        } else if (!isSorting && toSort.empty()) return;

        stepPartition();
        updateHighlights();
        step++;
    }

    private void stepPartition() {
        // while (high > low)
        if (high > low) {
            // while (low <= high && list[low] <= pivot)
            if (low <= high && list[low].getValue() <= list[pivot].getValue()) {
                low++;
                return;
            }

            // while (low <= high && list[high] > pivot)
            if (high >= low && list[high].getValue() > list[pivot].getValue()) {
                high--;
                return;
            }

            if (high > low) {
                swap(low, high);
                return;
            }
        }

        if (high > pivot && list[high].getValue() >= list[pivot].getValue()) {
            high--;
            return;
        }

        if (list[pivot].getValue() > list[high].getValue()) {
            swap(pivot, high);

            // right
            if (high + 1 < maxIndex)
                toSort.push(new ListIndexPair(high + 1, maxIndex));

            // left
            if (minIndex < high - 1)
                toSort.push(new ListIndexPair(minIndex, high - 1));
        } else {
            if (minIndex + 1 < maxIndex)
                toSort.push(new ListIndexPair(minIndex + 1, maxIndex));
        }
        isSorting = false;
    }

    private void saveCounters() {
        previousHigh = high;
        previousLow = low;
        previousPivot = pivot;
    }

    @Override
    protected void resetCounters() {
        step = 0;
        pivot = 0;
        low = 1;
        high = list.length - 1;
        minIndex = 0;
        maxIndex = list.length - 1;
        isSorting = true;

        toSort = new Stack<>(); // toSort.clear() throws a NullPointerException for no reason

        previousHigh = high;
        previousLow = low;
        previousPivot = pivot;
    }

    @Override
    protected void updateHighlights() {
        list[previousPivot].setHighlight("none");
        list[previousLow].setHighlight("none");
        list[previousHigh].setHighlight("none");

        list[pivot].setHighlight("blue");
        list[low].setHighlight("red");
        list[high].setHighlight("green");
    }

    @Override
    public String getName() {
        return NAME;
    }

    private class ListIndexPair {
        private int low;
        private int high;

        ListIndexPair(int low, int high) {
            this.low = low < high ? low : high;
            this.high = high > low ? high : low;
        }

        int getLow() {
            return low;
        }

        void setLow(int low) {
            this.low = low;
        }

        int getHigh() {
            return high;
        }

        void setHigh(int high) {
            this.high = high;
        }
    }
}
