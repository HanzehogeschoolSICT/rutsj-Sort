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
    private AlgorithmThread algorithmThread;
    private SortingAlgorithm currentAlgorithm;
    private SortingAlgorithm[] algorithms; // Subject to change

    public AlgorithmModel() {
        currentAlgorithm = new BubbleSort(generateRandomList(20));
    }


    @Override
    public void step() {
        currentAlgorithm.step();

        updateObservers();
    }

    @Override
    public void play(int interval) {
        if (algorithmThread != null)
            if (algorithmThread.isRunning())
                return;

        algorithmThread = new AlgorithmThread(this, interval);
        new Thread(algorithmThread).start();
    }

    @Override
    public void pause() {
        if (algorithmThread != null)
            algorithmThread.stop();
    }

    @Override
    public void changeListSize(int size) {
        currentAlgorithm.updateData( generateRandomList(size) );
        updateObservers();
    }

    @Override
    public void reset() {
        changeListSize( currentAlgorithm.getList().length );
    }

    @Override
    public DataPair[] getData() {
        return currentAlgorithm.getList();
    }

    @Override
    public void changeAlgorithm(String algorithmName) {

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

    private void updateObservers() {
        setChanged();
        notifyObservers();
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
