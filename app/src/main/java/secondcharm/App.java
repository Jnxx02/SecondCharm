package secondcharm;

import javafx.application.Application;
import javafx.stage.Stage;
import secondcharm.Scenes.HomeScene;


public class App extends Application {
    protected Stage stage;

    @Override
    public void start(Stage stage) {
        HomeScene scene1 = new HomeScene(stage);
        scene1.show();
        stage.setTitle("SecondCharm");
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
