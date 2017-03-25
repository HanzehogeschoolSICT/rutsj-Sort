package nl.rutsj.sort.controller;

import nl.rutsj.sort.model.Model;
import nl.rutsj.sort.view.View;

import java.util.Observable;
import java.util.Observer;

public class AnimationController extends Controller implements Observer {
    private View view;

    public AnimationController(View view) {
        this.view = view;
    }

    @Override
    public void update(Observable o, Object arg) {
        view.update( model.getData() );
        updateViewText();
    }

    @Override
    public void init(Model model) {
        super.init(model);
        model.addObserver(this);

        // First tick
        update(null, null);
    }

    private void updateViewText() {
        view.setStatus(model.getStatus());
        view.setTitle(model.getCurrentAlgorithm());
    }
}
