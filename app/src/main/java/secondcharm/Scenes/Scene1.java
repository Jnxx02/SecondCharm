package secondcharm.Scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Scene1 extends MyScene {
    public Scene1(Stage stage) {
        super(stage);
        
    }

    public void show() {
        StackPane spLayout = new StackPane();
        Scene scene = new Scene(spLayout, 450, 600);
        scene.getStylesheets().add(getClass().getResource("/styles/Scene1-style.css").toExternalForm());

        // Setting background
        ImageView ivBackground = new ImageView("/images/4.png");
        ivBackground.setFitWidth(scene.getWidth());
        ivBackground.setFitHeight(scene.getHeight());
        spLayout.getChildren().add(ivBackground);

        // Button Start
        Region space = new Region();
        space.setPrefHeight(12);
        Button btnStart = new Button("Start the Journey");
        btnStart.getStyleClass().add("btn-start");

        // Vbox Layout
        VBox vLayout = new VBox( btnStart);
        vLayout.setSpacing(8);
        spLayout.getChildren().add(vLayout);
        vLayout.setPadding(new Insets(20,20,100,20));
        vLayout.setAlignment(Pos.BOTTOM_RIGHT);

        // Actions
        btnStart.setOnAction(v -> {
            LoginScene loginScene = new LoginScene(stage);
            loginScene.show();
        });
        stage.setScene(scene);
    }
}
