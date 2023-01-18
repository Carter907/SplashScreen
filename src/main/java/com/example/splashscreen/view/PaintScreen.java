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
import javafx.scene.paint.Color;

public class PaintScreen extends View {

    private MenuBar toolBar;
    private TilePane optionsBar;
    private Canvas canvas;
    private Label paintOption;
    private Slider strokeWidthOption;
    private Label strokeWidthLabel;
    private ColorPicker colorOption;
    private Label clearOption;


    public PaintScreen() {
        setToolbar();
        setPaintOption();
        setStrokeWidthOption();
        setColorOption();
        setClearOption();
        setOptionsBar();

        setCanvas();
        setLayout();

        getChildren().add(root);
    }

    private void setClearOption() {

        ImageView clearImg = new ImageView(ApplicationStart.class.getResource("icons/clear_option.png").toExternalForm());
        clearImg.setFitHeight(30);
        clearImg.setPreserveRatio(true);

        clearOption = new Label("clear canvas", clearImg);

    }

    private void setColorOption() {

        colorOption = new ColorPicker();
        colorOption.setValue(Color.BLACK);
    }

    private void setStrokeWidthOption() {

        strokeWidthOption = new Slider();
        strokeWidthLabel = new Label("stroke width", strokeWidthOption);


    }

    private void setCanvas() {

        canvas = new Canvas();
        canvas.setHeight(PaintUtils.Size.DEFAULT_CANVAS_HEIGHT.get());
        canvas.setWidth(PaintUtils.Size.DEFAULT_CANVAS_WIDTH.get());

        canvas.setTranslateX(0);
    }

    private void setOptionsBar() {
        optionsBar = new TilePane();
        optionsBar.setPrefRows(2);
        optionsBar.setPrefColumns(2);
        optionsBar.setPadding(new Insets(10));


        optionsBar.getChildren().addAll(paintOption, strokeWidthOption, colorOption, clearOption);


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

        top.setPrefWidth(PaintUtils.Size.DEFAULT_WIDTH.get());
    }

    public Label getPaintOption() {
        return paintOption;
    }

    public TilePane getOptionsBar() {
        return optionsBar;
    }

    public Slider getStrokeWidthOption() {
        return strokeWidthOption;
    }

    public Label getStrokeWidthLabel() {
        return strokeWidthLabel;
    }

    public ColorPicker getColorOption() {
        return colorOption;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public MenuBar getToolBar() {
        return toolBar;
    }

    public Label getClearOption() {
        return clearOption;
    }
}
