package secondcharm.dao;

import java.io.ByteArrayInputStream;

import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import secondcharm.Models.Top;
import secondcharm.Scenes.BuyScene;
import javafx.scene.image.Image;

public class TopCell extends ListCell<Top> {
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
    protected void updateItem(Top top, boolean empty) {
        super.updateItem(top, empty);

        if (empty || top == null) {
            setText(null);
            setGraphic(null);
        } else {
            // Tampilkan informasi singkat atasan
            ImageView imageView = new ImageView(new Image(new ByteArrayInputStream(top.getImage())));
            imageView.setFitWidth(75);
            imageView.setFitHeight(75);

            Label nameLabel = new Label(top.getName() + " - " + top.getSize());
            nameLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: white;");
            Label priceLabel = new Label("Rp" + Double.toString(top.getPrice()));
            priceLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 18px; -fx-text-fill: white;");

            VBox vbox = new VBox(priceLabel, nameLabel);
            vbox.setSpacing(5);
            vbox.setAlignment(Pos.CENTER_LEFT);

            HBox hBox = new HBox(imageView, vbox);
            hBox.setSpacing(8);

            setText(null);
            setGraphic(hBox);

            setOnMouseClicked(v -> {
                showProductDescription(top);
            });
        }
    }
    

    private void showProductDescription(Top top) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Product Description");
        alert.setHeaderText(top.getName() + " - " + top.getSize());
        alert.setContentText(top.getDescribe());
        ButtonType buyButtonType = ButtonType.CANCEL;
        ButtonType cancelButtonType = ButtonType.OK;
    
        alert.getDialogPane().getButtonTypes().setAll(buyButtonType, cancelButtonType);
    
        Button buyButton = (Button) alert.getDialogPane().lookupButton(cancelButtonType);
        buyButton.setDefaultButton(false);
        buyButton.setText("Buy");
        buyButton.setStyle("-fx-background-color: white; -fx-text-fill: #cea627; -fx-font-weight: bold;");

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
                BuyScene buySceneTop = new BuyScene(stage);
                buySceneTop.show();
            }
        });
    }
}