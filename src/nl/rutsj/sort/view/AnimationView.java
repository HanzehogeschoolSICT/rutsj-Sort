package nl.rutsj.sort.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import nl.rutsj.sort.util.DataPair;

// TODO: kijk naar http://stackoverflow.com/questions/27302875/set-bar-chart-column-width-size

public class AnimationView extends BorderPane implements View {
    private Label lblStatus;
    private BarChart<String, Number> chart;
    private CategoryAxis xAxis;
    private NumberAxis yAxis;
    private XYChart.Series<String, Number> series;

    private DataPair[] data;
    private ObservableList<String> categories = FXCollections.observableArrayList();

    public AnimationView() {
        lblStatus = new Label();

        initChart();

        this.setCenter(chart);
        this.setBottom(lblStatus);
        BorderPane.setAlignment(lblStatus, Pos.CENTER);
    }

    private void initChart() {
        xAxis = new CategoryAxis();
        yAxis = new NumberAxis();
        chart = new BarChart<>(xAxis, yAxis);
        series = new XYChart.Series<>();

        chart.getData().add(series);

        initChartProperties();
    }

    private void initChartProperties() {
        chart.setAnimated(false);
        chart.setLegendVisible(false);
        chart.setBarGap(0);
        chart.setCategoryGap(0);
        chart.setHorizontalGridLinesVisible(false);
        chart.setVerticalGridLinesVisible(false);
        xAxis.setTickLabelsVisible(false);
        xAxis.setTickMarkVisible(false);
        yAxis.setTickLabelsVisible(false);
        yAxis.setOpacity(0);
    }


    @Override
    public void update(DataPair[] data) {
        this.data = data;

        if (data.length != categories.size())
            updateCategories();

        updateData();
        updateHighlights();
    }

    private void updateCategories() {
        categories.clear();

        for (int i = 0; i < data.length; i++)
            categories.add(i, Integer.toString(i));
    }

    private void updateData() {
        series.getData().clear();

        for (int i = 0; i < data.length; i++) {
            series.getData().add(
                    new XYChart.Data<>(Integer.toString(i), data[i].getValue())
            );
        }
    }

    private void updateHighlights() {

    }

    @Override
    public void setTitle(String title) {
        chart.setTitle(title);
    }

    @Override
    public void setStatus(String status) {
        lblStatus.setText(status);
    }
}
