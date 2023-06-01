package secondcharm.dao;

import java.io.ByteArrayInputStream;

import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import secondcharm.Models.Bottom;
import secondcharm.Scenes.BuySceneTop;

public class BottomCell extends ListCell<Bottom> {
    private Stage stage;

    {
        // CSS styling
        setStyle("-fx-background-color: #cea267;"); /* Warna latar belakang sel */

        setOnMouseEntered(e -> {
            setStyle("-fx-background-color: #555555;"); /* Warna latar belakang saat dihover */
        });

        setOnMouseExited(e -> {
            setStyle("-fx-background-color: #cea267;"); /* Kembalikan warna latar belakang awal */
        });
    }

    @Override
    protected void updateItem(Bottom bottom, boolean empty) {
        super.updateItem(bottom, empty);

        if (empty || bottom == null) {
            setText(null);
            setGraphic(null);
        } else {
            // Tampilkan informasi atasan sesuai kebutuhan, misalnya gambar, nama, dan harga
            ImageView imageView = new ImageView(new Image(new ByteArrayInputStream(bottom.getImage())));
            imageView.setFitWidth(100);
            imageView.setFitHeight(100);

            Label nameLabel = new Label(bottom.getName());
            nameLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: white;");
            Label priceLabel = new Label("Rp" + Double.toString(bottom.getPrice()));
            priceLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 24px; -fx-text-fill: white;");

            VBox vbox = new VBox(nameLabel, priceLabel);
            vbox.setSpacing(5);
            vbox.setAlignment(Pos.CENTER);

            HBox hBox = new HBox(imageView, vbox);
            hBox.setSpacing(8);

            setText(null);
            setGraphic(hBox);

            setOnMouseClicked(v -> {
                showProductDescription(bottom);
            });
        }
    }
    private void showProductDescription(Bottom bottom) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Product Description");
        alert.setHeaderText(bottom.getName() + " - " + bottom.getSize());
        alert.setContentText(bottom.getDescribe());
        ButtonType buyButtonType = ButtonType.OK;
        ButtonType cancelButtonType = ButtonType.CANCEL;
    
        alert.getDialogPane().getButtonTypes().setAll(buyButtonType, cancelButtonType);
    
        Button buyButton = (Button) alert.getDialogPane().lookupButton(cancelButtonType);
        buyButton.setDefaultButton(false);
        buyButton.setText("Buy");
        buyButton.setStyle("-fx-background-color: #white; -fx-text-fill: #cea627; -fx-font-weight: bold;");

        buyButton.setOnMouseEntered(e -> {
            buyButton.setStyle("-fx-background-color: #555555;");
        });
        
        buyButton.setOnMouseExited(e -> {
            buyButton.setStyle("-fx-background-color: #00bfff;");
        });
        
        buyButton.setOnMousePressed(e -> {
            buyButton.setStyle("-fx-background-color: #222222");
        });
        
        buyButton.setOnMouseReleased(e -> {
            buyButton.setStyle("-fx-background-color: #555555;");
        });
    
        alert.showAndWait().ifPresent(buttonType -> {
            if (buttonType == buyButtonType) {
                // Logika pembelian produk
                BuySceneTop buySceneTop = new BuySceneTop(stage);
                buySceneTop.show();
            }
        });
    }
}