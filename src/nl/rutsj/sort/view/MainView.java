package nl.rutsj.sort.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import nl.rutsj.sort.controller.AnimationController;
import nl.rutsj.sort.controller.Controller;
import nl.rutsj.sort.model.AlgorithmModel;
import nl.rutsj.sort.model.Model;

import java.io.IOException;

public class MainView extends Application {

    // TODO: refactor
    @Override
    public void start(Stage stage) throws IOException {
        GridPane root = new GridPane();

        FXMLLoader settingsLoader = new FXMLLoader();
        settingsLoader.setLocation(getClass().getResource("settingsview.fxml"));
        SplitPane settingsView = settingsLoader.load();
        Controller settingsController = settingsLoader.getController();

        FXMLLoader controlsLoader = new FXMLLoader();
        controlsLoader.setLocation(getClass().getResource("controlsview.fxml"));
        ButtonBar controlsView = controlsLoader.load();
        Controller controlsController = controlsLoader.getController();

        AnimationView animationView = new AnimationView();
        Controller animationController = new AnimationController(animationView);

        BorderPane centerPane = new BorderPane(animationView);
        centerPane.setBottom(controlsView);

        root.add(centerPane, 0, 0, 2, 2);
        root.add(settingsView, 2, 0, 1, 2);

        setConstrains(root);

        // Pass the model to the controllers
        Model model = new AlgorithmModel();
        settingsController.init(model);
        controlsController.init(model);
        animationController.init(model);

        // Stop the AlgorithmThread if the applications closes
        stage.setOnCloseRequest( (event) -> model.pause() );

        stage.setTitle("Sort");
        stage.setScene(new Scene(root));
        stage.show();
    }

    // TODO: Improve this function (preferably get rid of it)
    private static void setConstrains(GridPane pane) {
        pane.setPrefSize(800, 400);
        pane.setMinSize(400, 300);

        // Columns
        for (int i = 0; i < 2; i++) {
            ColumnConstraints constraints = new ColumnConstraints(10.0, 100.0, -1);
            constraints.setHgrow(Priority.ALWAYS);
            pane.getColumnConstraints().add(constraints);
        }
        ColumnConstraints constraint3 = new ColumnConstraints(150.0);
        constraint3.setHgrow(Priority.ALWAYS);
        pane.getColumnConstraints().add(constraint3);

        // Rows
        for (int i = 0; i < 2; i++) {
            RowConstraints constraints = new RowConstraints(100.0, 200.0, -1);
            constraints.setVgrow(Priority.ALWAYS);
            pane.getRowConstraints().add(constraints);
        }
    }
}
