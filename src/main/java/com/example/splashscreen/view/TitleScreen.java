package com.example.splashscreen.view;

import com.example.splashscreen.model.PaintUtils;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class TitleScreen extends View {

    private Label title;
    private Button button;



    public TitleScreen() {
        setTitle();
        setButton();
        setLayout();


        getChildren().addAll(root);
    }
    @Override
    protected void setLayout() {

        root = new BorderPane();

        root.setBottom(new StackPane(button));
        root.setCenter(title);
        root.setPadding(new Insets(40));



        root.setMinHeight(PaintUtils.Size.DEFAULT_HEIGHT.get());
        root.setMinWidth(PaintUtils.Size.DEFAULT_WIDTH.get());



    }

    private void setTitle() {
        title = new Label("SplashScreen");
        title.setFont(Font.font("Times new Roman", FontWeight.BOLD, FontPosture.ITALIC, 40));

    }
    private void setButton() {
        button = new Button("continue");
    }

    public Label getTitle() {
        return title;
    }

    public Button getButton() {
        return button;
    }

}
