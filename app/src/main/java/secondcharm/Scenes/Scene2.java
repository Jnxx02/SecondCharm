package secondcharm.Scenes;

import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
import secondcharm.dao.BottomDao;
import secondcharm.dao.TopDao;

public class Scene2 {
    private Stage stage;
    private VBox rightSide;
    private ObservableList<Top> listAtasan;
    private ObservableList<Bottom> listBawahan;
    private TopDao topDao;
    private BottomDao bottomDao;

    public Scene2(Stage stage) {
        this.stage = stage;
        
        // Observable List atasan
        listAtasan = FXCollections.observableArrayList();
        topDao = new TopDao();
        try {
            listAtasan.addAll(topDao.getAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Observable List bawahan
        listBawahan = FXCollections.observableArrayList();
        bottomDao = new BottomDao();
        try {
            listBawahan.addAll(bottomDao.getAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void show() {
        HBox root = new HBox();
        Scene scene = new Scene(root, 640, 480);

        VBox leftSide = generateLeftSide(scene.getWidth() * .36, scene.getHeight());
        rightSide = generateRightSide(scene.getWidth() * .64, scene.getHeight());
        changeMenu(1);

        root.getChildren().addAll(leftSide, rightSide);

        scene.getStylesheets().add(getClass().getResource("/styles/Scene2-style.css").toExternalForm());
        stage.setScene(scene);
    }

    private void showAtasan() {
        rightSide.getChildren().clear();

        // TODO
        /*
        Menampilkan daftar atasan yang isinya berupa gambar, nama, dan harga yang bila di klik
        akan menunjukkan deskripsi produknya seperti nama barang, harga, stock, dan size kemudian
        akan ada opsi untuk membeli yang mengarah ke MainScene untuk transaksi dengan mengisi alamat
        dan melakukan pembayaran.

        Bila dibeli maka stock produk tersebut akan berkurang di database dan bila stock habis maka 
        produk akan terhapus dari list barang (sekalian sinkronkan dengan database).
        
        Untuk databasenya itu buat bisa perbaiki di folder dao yang ada TopDao sama BottomDao. Sudah
        ada mi templatenya yang dari modul tinggal disesuaikan dengan program
        */
    }

    private void showBawahan() {
        rightSide.getChildren().clear();

        //TODO
        /* Lakukan hal yang sama seperti atasan */
    }

    private void changeMenu(int indexMenu) {
        switch (indexMenu) {
            case 1:
                showAtasan();
                break;
            case 2:
                showBawahan();
            default:
                break;
        }
    }

    private VBox generateRightSide(double width, double height) {
        VBox vBoxLayout = new VBox();
        vBoxLayout.setPrefSize(width, height);
        vBoxLayout.setMaxSize(width, height);
        vBoxLayout.setPadding(new Insets(24));
        vBoxLayout.getStyleClass().add("vbox-layout");
        return vBoxLayout;
    }

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
        Label labelMenu = new Label("Back to Home");
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

    private HBox[] generateMenuItem() {
        String[] listTitle = {"Atasan", "Bawahan" };
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

    private void changeMenuStatus(HBox menu, boolean isActive) {
        if (isActive) {
            menu.getStyleClass().add("menu-active");
        } else {
            menu.getStyleClass().clear();
        }
    }
}
