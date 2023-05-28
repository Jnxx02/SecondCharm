package secondcharm.Scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;
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
        StackPane spLayout = new StackPane();
        Scene scene = new Scene(spLayout, 600, 480);
        scene.getStylesheets().add(getClass().getResource("/styles/Scene1-style.css").toExternalForm());

        // Setting background
        ImageView ivBackground = new ImageView("/images/bg5.png");
        ivBackground.setFitWidth(scene.getWidth());
        ivBackground.setFitHeight(scene.getHeight());
        spLayout.getChildren().add(ivBackground);

        // Text Desc
        Label lblDesc = new Label(
                "Level Up Your Style Game with SecondCharm.");
        lblDesc.getStyleClass().add("desc-text");
        lblDesc.setWrapText(true);
        lblDesc.setMaxWidth(250);

        // Button Start
        Region space = new Region();
        space.setPrefHeight(12);
        Button btnStart = new Button("Start the Journey");
        btnStart.getStyleClass().add("btn-start");

        // Vbox Layout
        VBox vLayout = new VBox(lblDesc, btnStart);
        vLayout.setSpacing(8);
        spLayout.getChildren().add(vLayout);
        vLayout.setPadding(new Insets(20));
        vLayout.setAlignment(Pos.BOTTOM_LEFT);

        // Actions
        btnStart.setOnAction(v -> {
            LoginScene loginScene = new LoginScene(stage);
            loginScene.show();
        });
        stage.setScene(scene);
    }
}
