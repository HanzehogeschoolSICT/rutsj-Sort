package nl.rutsj.sort.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.TextField;
import nl.rutsj.sort.model.Model;

public class ControlsController implements Controller{

    @FXML
    private ButtonBar controlBar;

    @FXML
    private TextField intervalField;

    @FXML
    private Button playButton;

    @FXML
    private Button pauseButton;

    @FXML
    private Button stepButton;

    private Model model;

    @Override
    public void initModel(Model model) {
        this.model = model;
    }

    @FXML
    void pause(ActionEvent event) {
        System.out.println("ControlsController.pause");
        System.out.println("event = " + event);
    }

    @FXML
    void play(ActionEvent event) {
        System.out.println("ControlsController.play");
        System.out.println("event = " + event);
    }

    @FXML
    void step(ActionEvent event) {
        System.out.println("ControlsController.step");
        System.out.println("event = " + event);

        model.step();
    }

}
