package nl.rutsj.sort.algorithms;

/**
 * Created by rutgerschroder on 22/03/2017.
 */
public class InsertionSort extends SortingAlgorithm {
    private static final String NAME = "InsertionSort";

    private int currentElement = index;
    private int previousIndex = 0;

    public InsertionSort(int[] list){
        super(list);
        index = 1;
    }

    @Override
    public void step() {
        if (index < list.length) {
            step++;

            if (currentElement > 0 && list[currentElement - 1].getValue() > list[currentElement].getValue()) {
                swap(currentElement, currentElement - 1);
                currentElement--;
                return;
            }

            previousIndex = index;
            index++;

            currentElement = index;

            if (index < list.length)
                updateHighlights();
        }
    }

    @Override
    protected void resetCounters() {
        step = 0;
        index = 1;
        currentElement = index;
    }

    @Override
    protected void updateHighlights() {
        list[previousIndex].setHighlight("none");
        list[index].setHighlight("blue");
    }

     public String getName() { return NAME; }
}
