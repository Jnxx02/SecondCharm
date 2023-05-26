package secondcharm.Scenes;

import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import secondcharm.Models.Bottom;
import secondcharm.Models.Top;

public class MainScene {
    private Stage stage;
    private VBox rightSide;
    private ObservableList<Top> listAtasan;
    private ObservableList<Bottom> listBawahan;
    // private ObatDao obatDao;

    public MainScene(Stage stage) {
        this.stage = stage;
        listAtasan = FXCollections.observableArrayList();
        // Observable List Menampung nama apotker
        // listPharmas.addAll("John Doe", "John Wijck", "Abdul Mansur", "Masloman", "Enoch");
        // listObat = FXCollections.observableArrayList();
        // obatDao = new ObatDao();
        // try {
        //     listObat.addAll(obatDao.getAll());
        // } catch (SQLException e) {
        //     e.printStackTrace();
        // }
    }

    public void show() {
        HBox root = new HBox();
        Scene scene = new Scene(root, 640, 480);

        // VBox leftSide = generateLeftSide(scene.getWidth() * .36, scene.getHeight());
        // rightSide = generateRightSide(scene.getWidth() * .64, scene.getHeight());
        // changeMenu(1);

        root.getChildren().addAll(rightSide);

        // scene.getStylesheets().add(getClass().getResource("/styles/main_style.css").toExternalForm());
        stage.setScene(scene);
    }
}
