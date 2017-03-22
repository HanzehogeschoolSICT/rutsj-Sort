package nl.rutsj.sort;

import nl.rutsj.sort.algorithms.BubbleSort;
import nl.rutsj.sort.algorithms.SortingAlgorithm;
import nl.rutsj.sort.util.DataPair;

public class Main {
    public static void main(String[] args) {
        int[] list = new int[] { 80, 58, 41, 10, 2, 50, 9, 33, 64, 78, 9, 12, 95, 18, 59, 59, 97, 67, 32, 64};
        SortingAlgorithm bubble = new BubbleSort(list);


        System.out.println(
                arrayToString(bubble.getList())
                + " index: " + bubble.getIndex()
                + " step: " + bubble.getStep());

        for (int i = 0; i < 1000 && !bubble.isSorted(); i++) {
            System.out.println(
                    arrayToString(bubble.getList())
                    + " index: " + bubble.getIndex()
                    + " step: " + bubble.getStep());
            bubble.step();
        }

        System.out.println(
                arrayToString(bubble.getList())
                        + " index: " + bubble.getIndex()
                        + " step: " + bubble.getStep());

        System.out.println("Sorted: " + bubble.isSorted());
    }

    private static String arrayToString(DataPair[] list) {
        String str = "[";
        for (int i = 0; i < list.length - 1; i++) {
            str += list[i].getValue() + ", ";
        }
        str += list[list.length - 1].getValue() + "]";

        return str;
    }
}
