package nl.rutsj.sort.model;

import nl.rutsj.sort.algorithms.SortingAlgorithm;
import nl.rutsj.sort.util.DataPair;

import java.util.Observer;

public interface Model {
    void step();

    void play(int interval);

    void pause();

    void changeListSize(int size);

    void reset();

    DataPair[] getData();

    void changeAlgorithm(String algorithmName);

    SortingAlgorithm getCurrentAlgorithm();

    SortingAlgorithm[] getAlgorithms();

    void addObserver(Observer o);

    String getStatus();
}
