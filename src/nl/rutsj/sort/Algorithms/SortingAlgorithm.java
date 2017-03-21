package nl.rutsj.sort.Algorithms;

/**
 *  This abstract class provides base functionality to be inherited and implemented
 *  by the sorting algorithms.
 */
public abstract class SortingAlgorithm {
    protected int step = 0;
    protected int index = 0;
    protected int[] list;

    public SortingAlgorithm(int[] list) {
        this.list = list;
    }

    public abstract void step();

    /**
     * A simple function to determine if the array is sorted.
     * Only tests for ascending order.
     * @return true if the array is sorted.
     */
    public boolean isSorted() {
        for (int i = 1; i < list.length; i++) {
            if ( !(list[i-1] <= list[i]) )
                return false;
        }
        return true;
    }

    /**
     * Return the current list of values in an array.
     * @return the array of values.
     */
    public int[] getList() {
        return list;
    }

    /**
     * @return the current sorting index.
     */
    public int getIndex() {
        return index;
    }

    /**
     * @return returns the steps passed.
     */
    public int getStep() {
        return step;
    }
}
