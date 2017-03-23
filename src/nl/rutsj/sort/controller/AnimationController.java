package nl.rutsj.sort.controller;

import nl.rutsj.sort.model.Model;
import nl.rutsj.sort.util.DataPair;
import nl.rutsj.sort.view.View;

import java.util.Observable;
import java.util.Observer;

public class AnimationController implements Observer, Controller {
    private View view;
    private Model model;

    private DataPair[] data; // Temporary

    public AnimationController(View view) {
        this.view = view;
    }

    @Override
    public void update(Observable o, Object arg) {
        data = model.getData();
        view.update(data);
        updateViewText();
    }

    @Override
    public void initModel(Model model) {
        this.model = model;
        model.addObserver(this);

        // First tick
        update(null, null);
    }

    private void updateViewText() {
        view.setStatus(model.getStatus());
        view.setTitle(model.getCurrentAlgorithm().getName());
    }
}
