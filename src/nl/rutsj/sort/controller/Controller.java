package nl.rutsj.sort.controller;

import javafx.scene.control.TextField;

import nl.rutsj.sort.model.Model;

public abstract class Controller {
    protected Model model;

    public void init(Model model) {
        this.model = model;
    }

    /**
     * A listener that removes all non-digit characters based on this StackOverflow answer:
     * http://stackoverflow.com/a/30796829
     */
    protected static void setupDigitFieldListener(TextField textField) {
        textField.textProperty().addListener(
                (observable, oldValue, newValue) ->
                        textField.setText(newValue.replaceAll("[^\\d]", ""))
        );
    }
}
