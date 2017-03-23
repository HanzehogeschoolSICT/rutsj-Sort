package nl.rutsj.sort.model;

import nl.rutsj.sort.algorithms.BubbleSort;
import nl.rutsj.sort.algorithms.SortingAlgorithm;
import nl.rutsj.sort.util.DataPair;

import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// TODO: support multiple algorithms
public class AlgorithmModel extends Observable implements Model {
    private DataPair[] data;

    private SortingAlgorithm currentAlgorithm;
    private SortingAlgorithm[] algorithms; // Subject to change

    public AlgorithmModel() {
        currentAlgorithm = new BubbleSort(generateRandomList(20));
        data = currentAlgorithm.getList();
    }


    @Override
    public void step() {
        currentAlgorithm.step();

        data = currentAlgorithm.getList();

        setChanged();
        notifyObservers();
    }

    @Override
    public void play(int interval) {

    }

    @Override
    public DataPair[] getData() {
        return data;
    }

    @Override
    public SortingAlgorithm getCurrentAlgorithm() {
        return currentAlgorithm;
    }

    @Override
    public SortingAlgorithm[] getAlgorithms() {
        return new SortingAlgorithm[0];
    }

    @Override
    public String getStatus() {
        return "Step: " + currentAlgorithm.getStep();
    }

    @Override
    public void stop() {
        // TODO: stop thread
    }

    private static int[] generateRandomList(int size) {
        // Credit: http://stackoverflow.com/a/22829036
        List<Integer> list = IntStream.rangeClosed(1, size)
                                .boxed().collect(Collectors.toList());

        Collections.shuffle(list);

        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = list.get(i);
        }

        return array;
    }
}
