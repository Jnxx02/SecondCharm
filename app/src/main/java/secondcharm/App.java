package secondcharm;

import javafx.application.Application;
import javafx.stage.Stage;
import secondcharm.Scenes.Scene1;


public class App extends Application {

    @Override
    public void start(Stage stage) {
        Scene1 scene1 = new Scene1(stage);
        scene1.show();
        stage.setTitle("SecondCharm");
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
