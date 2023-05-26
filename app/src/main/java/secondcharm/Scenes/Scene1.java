package secondcharm.Scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class Scene1 {
    private Stage stage;

    public Scene1(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        //TODO
        //Buatkan desain dan isi scenenya
        StackPane spLayout = new StackPane();
        Scene scene = new Scene(spLayout, 640, 480);
        // scene.getStylesheets().add(getClass().getResource("/styles/home_style.css").toExternalForm());

        //Setting background

        //Text title
        Text tLeft = new Text("Second");
        tLeft.getStyleClass().add("title-text-left");
        Text tRight = new Text("Charm");
        tRight.getStyleClass().add("title-text-right");
        TextFlow tfTitle = new TextFlow(tLeft, tRight);

        //Top Logo

        //Text Desc
        Label lblDesc = new Label(
                "Dapatkan pakaian dengan kualitas pejabat dan harga merakyat hanya di toko kami! Temukan beragam pilihan atasan dan bawahan yang modis dan berkualitas.");
        lblDesc.getStyleClass().add("desc-text");
        lblDesc.setWrapText(true);
        lblDesc.setMaxWidth(355);

        //Button Start
        Region space = new Region();
        space.setPrefHeight(12);
        Button btnStart = new Button("Start");
        btnStart.getStyleClass().add("btn-start");

        //Vbox Layout
        VBox vLayout = new VBox(tfTitle, lblDesc, space, btnStart);
        vLayout.setSpacing(8);
        spLayout.getChildren().add(vLayout);
        vLayout.setPadding(new Insets(53));
        vLayout.setAlignment(Pos.CENTER_LEFT);

        //actions
        btnStart.setOnAction(v -> {
            MainScene mainScene = new MainScene(stage);
            mainScene.show();
        });

        stage.setScene(scene);
    }
}

