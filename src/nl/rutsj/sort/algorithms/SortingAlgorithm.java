package nl.rutsj.sort.algorithms;

import nl.rutsj.sort.util.DataPair;

/**
 *  This abstract class provides base functionality to be inherited and implemented
 *  by the sorting algorithms.
 */
public abstract class SortingAlgorithm {
    protected int step = 0;
    protected int index = 0;
    protected DataPair[] list;

    public SortingAlgorithm(int[] rawList) {
        list = new DataPair[rawList.length];

        for (int i = 0; i < rawList.length; i++) {
            list[i] = new DataPair(rawList[i], "none");
        }
    }

    public abstract void step();

    /**
     * A simple function to determine if the array is sorted.
     * Only tests for ascending order.
     * @return true if the array is sorted.
     */
    public boolean isSorted() {
        for (int i = 1; i < list.length; i++) {
            if ( !(list[i-1].getValue() <= list[i].getValue()) )
                return false;
        }
        return true;
    }

    /**
     * Return the current list of values in an array.
     * @return the array of values.
     */
    public DataPair[] getList() {
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

    /**
     * @return returns the name of the algorithm as a String.
     */
    public abstract String getName();

    protected void swap(int i, int j) {
        int temp = list[i].getValue();
        list[i].setValue(list[j].getValue());
        list[j].setValue(temp);
    }
}
