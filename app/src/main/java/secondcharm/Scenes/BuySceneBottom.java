package secondcharm.Scenes;


import java.util.Optional;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import secondcharm.Models.Bottom;

public class BuySceneBottom extends MyScene {
    private Bottom selectedBottom;

    public BuySceneBottom(Stage stage) {
        super(stage);
    }

    public void show()  {
        VBox root = new VBox();
        Scene scene = new Scene(root, 450, 600);

        // Informasi Produk
        Label nameLabel = new Label(selectedBottom.getName());
        Label priceLabel = new Label("Rp" + selectedBottom.getPrice());
        Label sizeLabel = new Label("Size: " + selectedBottom.getSize());
        Label descriptionLabel = new Label("Description: " + selectedBottom.getDescribe());

        // Membuat tampilan untuk memasukkan alamat pengiriman
        Label addressLabel = new Label("Alamat Pengiriman:");
        TextField addressTextField = new TextField();

        // Tombol untuk melakukan pembayaran
        Button payButton = new Button("Buy");
        payButton.setOnAction(e -> {
            boolean confirmed = showConfirmationDialog("Confirmation", "Are you sure you want to buy this product?");
            if (confirmed) {
                showInformationDialog("Success", "Product purchased successfully!");

                // Setelah pembayaran selesai, hapus produk dari database
                deleteBottomFromDatabase(selectedBottom);
                
                // Kembali ke tampilan sebelumnya (Scene2)
                Scene2 scene2 = new Scene2(stage);
                scene2.show();
            }
        });

        root.getChildren().addAll(priceLabel, nameLabel, sizeLabel, descriptionLabel, addressLabel, addressTextField, payButton);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        root.setPadding(new Insets(10));

        stage.setScene(scene);
        stage.show();
    }

    private boolean showConfirmationDialog(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        Optional<ButtonType> result = alert.showAndWait();
        return result.orElse(ButtonType.CANCEL) == ButtonType.OK;
    }

    private void showInformationDialog(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void deleteBottomFromDatabase(Bottom selectedBottom2) {
        
    }

}
