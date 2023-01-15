package com.example.splashscreen.controllers;

import com.example.splashscreen.view.PaintScreen;
import com.example.splashscreen.view.TitleScreen;
import javafx.event.ActionEvent;

public class TitleScreenController extends Controller {

    public TitleScreenController(TitleScreen view) {
        super(view);

        view.getButton().setOnAction(this::toPaintScreen);
    }

    private void toPaintScreen(ActionEvent actionEvent) {
        view.getScene().setRoot(new PaintController(new PaintScreen()).getView());
    }
}
