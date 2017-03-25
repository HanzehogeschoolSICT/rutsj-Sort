package nl.rutsj.sort.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import nl.rutsj.sort.model.Model;

public class SettingsController extends Controller{

    private ObservableList<String> algorithms;

    @FXML
    private ComboBox<String> algorithmComboBox;

    @FXML
    private TextField listSizeField;

    @FXML
    private Button genListButton;

    @FXML
    void changeAlgorithm(ActionEvent event) {
        model.changeAlgorithm(algorithmComboBox.getValue());
    }

    @FXML
    void generateList(ActionEvent event) {
        String textValue = listSizeField.getText();
        int size = textValue.equals("") ? 20 : Integer.parseInt(textValue);
        model.changeListSize(size);
    }

    @Override
    public void init(Model model) {
        super.init(model);
        setupDigitFieldListener(listSizeField);
        setupComboBox(model.getAlgorithms());
    }

    private void setupComboBox(String[] algorithmList) {
        algorithms = FXCollections.observableArrayList(algorithmList);
        algorithmComboBox.getItems().addAll(algorithms);
        algorithmComboBox.getSelectionModel().selectFirst();
        changeAlgorithm(null);
    }
}
