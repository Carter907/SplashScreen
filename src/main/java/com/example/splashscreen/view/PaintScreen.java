package com.example.splashscreen.view;

import com.example.splashscreen.ApplicationStart;
import com.example.splashscreen.model.PaintUtils;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

public class PaintScreen extends View {

    private MenuBar toolBar;
    private TilePane optionsBar;
    private Canvas canvas;
    private Label paintOption;


    public PaintScreen() {
        setToolbar();
        setPaintOption();
        setOptionsBar();

        setCanvas();
        setLayout();

        getChildren().add(root);
    }

    private void setCanvas() {

        canvas = new Canvas();
        canvas.setHeight(PaintUtils.Size.DEFAULT_CANVAS_HEIGHT.get());
        canvas.setWidth(PaintUtils.Size.DEFAULT_CANVAS_WIDTH.get());


    }

    private void setOptionsBar() {
        optionsBar = new TilePane();
        optionsBar.setPrefRows(2);
        optionsBar.setPadding(new Insets(10));


        optionsBar.getChildren().addAll(paintOption);

    }

    private void setPaintOption() {
        ImageView paintOptionImg = new ImageView(
                ApplicationStart.class.getResource("icons/paint_option.png").toExternalForm());
        paintOptionImg.setFitHeight(30);
        paintOptionImg.setPreserveRatio(true);
        paintOption = new Label("paint", paintOptionImg);

    }

    private void setToolbar() {

        this.toolBar = new MenuBar();

        Menu file = new Menu("file");

        MenuItem importPainting = new Menu("import painting");

        file.getItems().add(importPainting);


        toolBar.getMenus().addAll(file);
    }

    @Override
    protected void setLayout() {

        root = new BorderPane();


        VBox top = new VBox();

        top.getChildren().addAll(toolBar, optionsBar);

        root.setTop(top);

        root.setCenter(canvas);

        root.setMinWidth(PaintUtils.Size.DEFAULT_WIDTH.get());
        root.setMinHeight(PaintUtils.Size.DEFAULT_HEIGHT.get());


    }

    public Label getPaintOption() {
        return paintOption;
    }

    public TilePane getOptionsBar() {
        return optionsBar;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public MenuBar getToolBar() {
        return toolBar;
    }
}