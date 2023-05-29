package secondcharm.Scenes;

import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import secondcharm.Models.Top;

public class MainScene {
    private Stage stage;
    private ObservableList<Top> listAtasan;

    public MainScene(Stage stage) {
        this.stage = stage;
    }
    
    public void show() {
        // Top top = new Top(top.getName(), top.getPrice(), top.getStock(), top.getSize());

        // Tampilkan deskripsi produk
        Label descriptionLabel = new Label("Description: ");
        Label sizeLabel = new Label("Size: ");
    
        VBox descriptionBox = new VBox(descriptionLabel, sizeLabel);
        descriptionBox.getStyleClass().add("description-box");
    
        // Opsi pembelian
        // TextField addressField = new TextField();
        Button buyButton = new Button("Buy");
        VBox purchaseBox = new VBox(buyButton);
        purchaseBox.getStyleClass().add("purchase-box");

        // Success Message
        Text successMessage = new Text();
        successMessage.getStyleClass().add("success-text");
        successMessage.setTextAlignment(TextAlignment.CENTER);

        buyButton.setOnMouseClicked (e -> {
            // int currentStock = top.getStock();
            //     if (currentStock - 1 == 0) {
            //         // Hapus produk dari daftar barang jika stok habis
            //         listAtasan.remove(top);
            //         // Hapus produk dari database
            //         // topDao.delete(top.getStock());
            //     }
            successMessage.setText("Pembelian berhasil");
            Scene2 scene2 = new Scene2(stage);
            scene2.show();
    
        });
    
        VBox productDetailsBox = new VBox(descriptionBox, purchaseBox, successMessage);
        productDetailsBox.getStyleClass().add("product-details-box");
        Scene scene = new Scene(productDetailsBox, 640, 480);
        scene.getStylesheets().add(getClass().getResource("/styles/Scene2-style.css").toExternalForm());
        stage.setScene(scene);
    }
}