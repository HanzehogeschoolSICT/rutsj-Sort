package nl.rutsj.sort.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import nl.rutsj.sort.model.Model;

public class SettingsController extends Controller{

    @FXML
    private ComboBox<?> algorithmComboBox;

    @FXML
    private TextField listSizeField;

    @FXML
    private Button genListButton;

    @FXML
    void changeAlgorithm(ActionEvent event) {
        System.out.println("SettingsController.changeAlgorithm");
        System.out.println("event = " + event);
    }

    @FXML
    void generateList(ActionEvent event) {
        int size = Integer.parseInt( listSizeField.getText() );
        model.changeListSize(size);
    }

    @Override
    public void init(Model model) {
        super.init(model);
        setupDigitFieldListener(listSizeField);
    }
}
