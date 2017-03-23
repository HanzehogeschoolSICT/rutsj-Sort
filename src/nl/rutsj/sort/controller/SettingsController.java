package nl.rutsj.sort.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import nl.rutsj.sort.model.Model;

public class SettingsController implements Controller{

    @FXML
    private ComboBox<?> algorithmComboBox;

    @FXML
    private TextField listSizeField;

    @FXML
    private Button genListButton;

    private Model model;

    @FXML
    void changeAlgorithm(ActionEvent event) {
        System.out.println("SettingsController.changeAlgorithm");
        System.out.println("event = " + event);
    }

    @FXML
    void generateList(ActionEvent event) {
        System.out.println("SettingsController.generateList");
        System.out.println("event = " + event);
    }

    @Override
    public void initModel(Model model) {
        this.model = model;
    }
}
