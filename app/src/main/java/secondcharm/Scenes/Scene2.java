package secondcharm.Scenes;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import secondcharm.Models.Bottom;
import secondcharm.Models.Top;
import secondcharm.dao.BottomCell;
import secondcharm.dao.BottomDao;
import secondcharm.dao.TopCell;
import secondcharm.dao.TopDao;

public class Scene2 extends MyScene{
    private VBox rightSide;
    private ListView<Top> topListView = new ListView<>();
    private ListView<Bottom> bottomListView = new ListView<>();
    
    public Scene2(Stage stage) {
        super(stage);
    
    }

    // Menampilkan scene
    @Override
    public void show() {
        HBox root = new HBox();
        Scene scene = new Scene(root, 450, 600);

        VBox leftSide = generateLeftSide(scene.getWidth() * .36, scene.getHeight());
        rightSide = generateRightSide(scene.getWidth() * .64, scene.getHeight());
        topListView.setMinHeight(600 - 24 *2);
        bottomListView.setMinHeight(600 - 24 *2);

        root.getChildren().addAll(leftSide, rightSide);

        scene.getStylesheets().add(getClass().getResource("/styles/Scene2-style.css").toExternalForm());
        changeMenu(1);

        stage.setScene(scene);
    }

    // Menampilkan list produk atasan
    private void showTop() {
        rightSide.getChildren().clear();
    
        // Mengambil data atasan dari database
        TopDao topDao = new TopDao();
        ObservableList<Top> tops = topDao.getToplList();
    
        // Menampilkan daftar atasan menggunakan ListView
        topListView.setItems(tops);
        // topListView.setPrefWidth(rightSide.getWidth());
        topListView.setCellFactory(param -> new TopCell());

        topListView.setOnMouseClicked(v -> {
            BuyScene buySceneTop = new BuyScene(stage, topListView.getSelectionModel().getSelectedItem(), null);
            buySceneTop.show();
        });
    
        rightSide.getChildren().add(topListView);
    }
    
    // Menampilkan list produk bawahan
    private void showBottom() {
        rightSide.getChildren().clear();
    
        // Mengambil data atasan dari database
        BottomDao bottomDao = new BottomDao();
        ObservableList<Bottom> bots = bottomDao.getBottomList();
    
        // Menampilkan daftar atasan menggunakan ListView
        bottomListView.setItems(bots);
        bottomListView.setCellFactory(param -> new BottomCell());

        bottomListView.setOnMouseClicked(v -> {
            BuyScene buySceneTop = new BuyScene(stage, null, bottomListView.getSelectionModel().getSelectedItem());
            buySceneTop.show();
        });
    
        rightSide.getChildren().add(bottomListView);
    }

    //Pergantian menu
    private void changeMenu(int indexMenu) {
        switch (indexMenu) {
            case 1:
                showTop();
                break;
            case 2:
                showBottom();
            default:
                break;
        }
    }

    // Sisi kanan scene
    private VBox generateRightSide(double width, double height) {
        VBox vBoxLayout = new VBox();
        vBoxLayout.setPrefSize(width, height);
        vBoxLayout.setMaxSize(width, height);
        vBoxLayout.setPadding(new Insets(24));
        vBoxLayout.getStyleClass().add("vbox-layout");
        return vBoxLayout;
    }

    // Sisi kiri scene
    private VBox generateLeftSide(double width, double height) {
        // Left Side (MENU)
        VBox vboxMenu = new VBox();
        vboxMenu.setPrefSize(width, height);
        vboxMenu.setMaxSize(width, height);
        vboxMenu.getStyleClass().add("vbox-menu");

        Text tLeft = new Text("Second");
        tLeft.getStyleClass().add("title-text-left");
        Text tRight = new Text("Charm");
        tRight.getStyleClass().add("title-text-right");
        TextFlow tfTitle = new TextFlow(tLeft, tRight);
        HBox hboxTitle = new HBox(tfTitle);
        hboxTitle.setPadding(new Insets(20));
        hboxTitle.setSpacing(12);
        Region space = new Region();
        space.setPrefHeight(12);

        // Separator
        Region spaceBetween = new Region();
        VBox.setVgrow(spaceBetween, Priority.ALWAYS);

        // Button
        ImageView ivIcon = new ImageView("/images/icon_home.png");
        Label labelMenu = new Label("Log Out");
        labelMenu.getStyleClass().add("label-menu");
        HBox hboxHome = new HBox(ivIcon, labelMenu);
        hboxHome.setPadding(new Insets(12, 20, 24, 20));
        hboxHome.setSpacing(8);
        hboxHome.getStyleClass().add("hbox-home");
        hboxHome.setOnMouseClicked(v -> {
            Scene1 Scene1 = new Scene1(stage);
            Scene1.show();
        });

        vboxMenu.getChildren().addAll(hboxTitle, space);
        vboxMenu.getChildren().addAll(generateMenuItem());
        vboxMenu.getChildren().addAll(spaceBetween, hboxHome);

        return vboxMenu;
    }

    // Menu Item
    private HBox[] generateMenuItem() {
        String[] listTitle = {"Top", "Bottom"};
        HBox[] listHboxMenu = new HBox[2];

        for (int i = 0; i < listHboxMenu.length; i++) {
            Label labelMenu = new Label(listTitle[i]);
            labelMenu.getStyleClass().add("label-menu");
            listHboxMenu[i] = new HBox(labelMenu);
            listHboxMenu[i].setPadding(new Insets(12, 20, 12, 20));
            listHboxMenu[i].setSpacing(4);
            changeMenuStatus(listHboxMenu[i], i == 0 ? true : false);
        }

        for (int i = 0; i < listHboxMenu.length; i++) {
            int index = i;
            listHboxMenu[i].setOnMouseClicked(v -> {

                changeMenuStatus(listHboxMenu[index], true);
                changeMenu(index + 1);

                for (int j = 0; j < listHboxMenu.length; j++) {
                    if (index != j) {
                        changeMenuStatus(listHboxMenu[j], false);
                    }
                }
            });
        }
        return listHboxMenu;
    }

    // Status menu aktif
    private void changeMenuStatus(HBox menu, boolean isActive) {
        if (isActive) {
            menu.getStyleClass().add("menu-active");
        } else {
            menu.getStyleClass().clear();
        }
    }
}
