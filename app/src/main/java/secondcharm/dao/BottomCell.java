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
            Label priceLabel = new Label("Rp" + Double.toString(bottom.getPrice()));

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
    
        alert.showAndWait().ifPresent(buttonType -> {
            if (buttonType == buyButtonType) {
                // Logika pembelian produk
                BuySceneTop buySceneTop = new BuySceneTop(stage);
                buySceneTop.show();
            }
        });
    }
}