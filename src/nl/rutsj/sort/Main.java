package nl.rutsj.sort;

import nl.rutsj.sort.algorithms.BubbleSort;
import nl.rutsj.sort.algorithms.SortingAlgorithm;
import nl.rutsj.sort.util.DataPair;

public class Main {
    public static void main(String[] args) {
        int[] list = new int[] { 9, 11, 14, 1, 7, 5, 12, 19, 3, 20, 15, 0, 4, 17, 6, 18, 10, 16, 8, 13};
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

        for (int i = 0; i < 20; i++)
            bubble.step();

        System.out.println("\n" + arrayToString(bubble.getList()));
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
