package nl.rutsj.sort.model;

import javafx.application.Platform;

public class AlgorithmThread implements Runnable {
    private Model model;
    private boolean running = true;
    private int delay = 10;

    public AlgorithmThread(Model model, int delay) {
        this.model = model;

        // The minimum this delay is set to 10ms
        // Any faster and JavaFX can't keep up with lists larger than 50
        if (delay >= 10)
            this.delay = delay;
    }

    @Override
    public void run() {
        while (running) {
            try {
                Platform.runLater( () -> model.step() );
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                System.out.println("The AlgorithmThread was interrupted");
            }
        }
    }

    public void stop() {
        running = false;
    }

    public boolean isRunning() {
        return running;
    }
}
