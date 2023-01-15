package com.example.splashscreen.view;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public abstract class View extends Pane {
    protected Stage window;
    protected BorderPane root;

    protected View () {
        this.window = null;
    }
    protected View(Stage window) {
        this.window = window;
    }
    protected abstract void setLayout();
    public Stage getWindow() {
        return window;
    }

    public BorderPane getRoot() {
        return root;
    }

    public void setWindow(Stage window) {
        this.window = window;
    }
}
