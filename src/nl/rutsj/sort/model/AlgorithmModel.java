package nl.rutsj.sort.model;

import nl.rutsj.sort.algorithms.BubbleSort;
import nl.rutsj.sort.algorithms.InsertionSort;
import nl.rutsj.sort.algorithms.QuickSort;
import nl.rutsj.sort.algorithms.SortingAlgorithm;
import nl.rutsj.sort.util.DataPair;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AlgorithmModel extends Observable implements Model {
    private AlgorithmThread algorithmThread;
    private SortingAlgorithm currentAlgorithm;
    private HashMap<String, SortingAlgorithm> algorithms = new HashMap<>();

    public AlgorithmModel() {
        int[] list = generateRandomList(20);
        SortingAlgorithm bubbleSort = new BubbleSort(list);
        SortingAlgorithm insertionSort = new InsertionSort(list);
        SortingAlgorithm quickSort = new QuickSort(list);

        algorithms.put(bubbleSort.getName(), bubbleSort);
        algorithms.put(insertionSort.getName(), insertionSort);
        algorithms.put(quickSort.getName(), quickSort);
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
        if ( !algorithms.keySet().contains(algorithmName) )
            return;
        currentAlgorithm = algorithms.get(algorithmName);
        updateObservers();
    }

    @Override
    public String getCurrentAlgorithm() {
        return currentAlgorithm.getName();
    }

    @Override
    public String[] getAlgorithms() {
        return algorithms.keySet().toArray( new String[algorithms.size()] );
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
