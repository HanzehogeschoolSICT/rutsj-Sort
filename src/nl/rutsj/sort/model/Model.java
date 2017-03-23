package nl.rutsj.sort.model;

import nl.rutsj.sort.algorithms.SortingAlgorithm;
import nl.rutsj.sort.util.DataPair;

import java.util.Observer;

public interface Model {
    void step();

    void play(int interval);
    DataPair[] getData();

    SortingAlgorithm getCurrentAlgorithm();

    SortingAlgorithm[] getAlgorithms();

    void stop();

    void addObserver(Observer o);

    String getStatus();
}
