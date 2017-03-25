package nl.rutsj.sort.algorithms;

/**
 * Created by rutgerschroder on 22/03/2017.
 */
public class InsertionSort extends SortingAlgorithm {
    private static final String NAME = "InsertionSort";

    private int i = 1;
    private int k = i - 1;
    private int currentElement = list[i].getValue();

    public InsertionSort(int[] list){
        super(list);
    }

    @Override
    public void step(){

        step++;

        if(i < list.length && !this.isSorted()) {

            if (k >= 0 && list[k].getValue() > currentElement) {
                swap(k + 1, k);
                k--;
                return;
            }

            list[k + 1].setValue(currentElement);
            i++;
            index++;
            currentElement = list[i].getValue();
            k = i - 1;

        } else if(this.isSorted()){
            //TODO determine action when list is sorted
            System.out.println("The list is sorted");
        }

    }

    @Override
    protected void resetCounters() {
        step = 0;
        i = 0;
        k = i -1;
        currentElement = list[i].getValue();
    }

    @Override
    protected void updateHighlights() {
        // TODO: implement
    }

     public String getName() { return NAME; }
}
