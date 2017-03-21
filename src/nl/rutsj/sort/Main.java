package nl.rutsj.sort;

import nl.rutsj.sort.Algorithms.BubbleSort;
import nl.rutsj.sort.Algorithms.SortingAlgorithm;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] list = new int[] { 80, 58, 41, 10, 2, 50, 9, 33, 64, 78, 9, 12, 95, 18, 59, 59, 97, 67, 32, 64};
        SortingAlgorithm bubble = new BubbleSort(list);

        System.out.println(Arrays.toString(bubble.getList()));

        for (int i = 0; i < 1000 && !bubble.isSorted(); i++) {
            System.out.println(Arrays.toString(bubble.getList()) + " step: " + i);
            bubble.step();
        }

        System.out.println("Sorted: " + bubble.isSorted());
    }
}
