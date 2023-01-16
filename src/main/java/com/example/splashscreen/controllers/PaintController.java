package com.example.splashscreen.controllers;

import com.example.splashscreen.model.PaintUtils;
import com.example.splashscreen.view.PaintScreen;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

import java.util.HashMap;
import java.util.Map;


public class PaintController extends Controller {

    private GraphicsContext context;
    private volatile PaintUtils.PaintOptions selected;
    private HashMap<PaintUtils.PaintOptions, Label> optionsMap;
    private PaintScreen paintView;
    private double x,y;
    

    public PaintController(PaintScreen view) {
        super(view);
        paintView = view;
        context = view.getCanvas().getGraphicsContext2D();
        optionsMap = new HashMap<>(Map.of(
                PaintUtils.PaintOptions.getOption(view.getPaintOption().getText()), view.getPaintOption()

        ));
        view.getPaintOption().setOnMouseClicked(this::optionClicked);
        view.getCanvas().setOnMouseClicked(this::canvasClicked);
        view.getCanvas().setOnMouseDragged(this::canvasDragged);
        view.getCanvas().setOnMousePressed(this::canvasPressed);
        view.getCanvas().setOnMouseReleased(this::canvasReleased);
        view.getColorOption().setOnAction(this::pickedColor);
        view.getStrokeWidthOption().valueProperty().addListener(this::strokeWidthChanged);
        view.getToolBar().getMenus().get(0).getItems().get(0).setOnAction(this::importImageOnAction);
    }

    private void strokeWidthChanged(Observable observable) {
        context.setLineWidth(paintView.getStrokeWidthOption().getValue());
    }

    private void pickedColor(ActionEvent actionEvent) {
        context.setStroke(paintView.getColorOption().getValue());
    }

    private void optionClicked(MouseEvent event) {
        if (!(event.getSource() instanceof Label))
            return;
        Label option = (Label) event.getSource();

        if (selected != null && option.equals(optionsMap.get(selected))) {
            selected = null;
            option.setBackground(null);

        } else {
            option.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(5), null)));
            selected = PaintUtils.PaintOptions.getOption(option.getText());
        }

    }

    private void canvasClicked(MouseEvent event) {
        if (selected == null)
            return;
        switch (selected) {

            case PAINT_BRUSH -> clickCanvasPaintBrush(event);

        }


    }
    private void canvasPressed(MouseEvent event) {
        if (selected == null)
            return;
        switch (selected) {

            case PAINT_BRUSH -> pressCanvasPaintBrush(event);
        }
    }
    private void canvasReleased(MouseEvent event) {
        if (selected == null)
            return;
        switch (selected) {

            case PAINT_BRUSH -> releaseCanvasPaintBrush(event);
        }
    }

    private void releaseCanvasPaintBrush(MouseEvent event) {
        context.beginPath();
    }
    private void pressCanvasPaintBrush(MouseEvent event) {
        x = event.getX();
        y = event.getY();
        context.moveTo(x, y);
    }

    private void canvasDragged(MouseEvent event) {
        if (selected == null)
            return;
        switch (selected) {

            case PAINT_BRUSH -> dragCanvasPaintBrush(event);
        }

    }
    
    

    private void dragCanvasPaintBrush(MouseEvent event) {

        double x = event.getX(), y = event.getY();
        context.lineTo(x, y);
        context.stroke();

    }

    private void clickCanvasPaintBrush(MouseEvent event) {

        double x = event.getX(), y = event.getY();
        context.lineTo(x, y);
        context.stroke();
        context.beginPath();

    }

    private void importImageOnAction(ActionEvent actionEvent) {

        FileChooser fileChooser = new FileChooser();

        fileChooser.showOpenDialog(view.getWindow());
    }


}
