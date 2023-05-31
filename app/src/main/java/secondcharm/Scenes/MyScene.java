package secondcharm.Scenes;

import javafx.stage.Stage;

public abstract class MyScene {
    protected Stage stage;

    public MyScene(Stage stage) {
        this.stage = stage;
    };

    public abstract void show();

}
