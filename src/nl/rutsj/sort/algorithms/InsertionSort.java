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

        if(i < list.length) {

            if (k >= 0 && list[k].getValue() > currentElement) {
                swap(k + 1, k);
                k--;
                return;
            }

            list[k + 1].setValue(currentElement);
            i++;
            currentElement = list[i].getValue();
            k = i - 1;
        }
    }

     public String getName() { return NAME; }
}
