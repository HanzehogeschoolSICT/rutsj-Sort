package nl.rutsj.sort.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.TextField;

import nl.rutsj.sort.model.Model;

public class ControlsController extends Controller{

    @FXML
    private ButtonBar controlBar;

    @FXML
    private TextField intervalField;

    @FXML
    private Button playButton;

    @FXML
    private Button pauseButton;

    @FXML
    private Button resetButton;

    @FXML
    private Button stepButton;

    @Override
    public void init(Model model) {
        super.init(model);
        setupDigitFieldListener(intervalField);
    }

    @FXML
    void play(ActionEvent event) {
        String textValue = intervalField.getText();
        int interval = textValue.equals("") ? 100 : Integer.parseInt(textValue);
        model.play(interval);
    }

    @FXML
    void pause(ActionEvent event) {
        model.pause();
    }

    @FXML
    void reset(ActionEvent event) {
        model.reset();
    }

    @FXML
    void step(ActionEvent event) {
        model.step();
    }

}
