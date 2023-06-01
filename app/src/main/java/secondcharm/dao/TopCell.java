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
import secondcharm.Scenes.BuySceneTop;
import javafx.scene.image.Image;

public class TopCell extends ListCell<Top> {
    private Stage stage;


    @Override
    protected void updateItem(Top top, boolean empty) {
        super.updateItem(top, empty);

        if (empty || top == null) {
            setText(null);
            setGraphic(null);
        } else {
            // Tampilkan informasi singkat atasan
            ImageView imageView = new ImageView(new Image(new ByteArrayInputStream(top.getImage())));
            imageView.setFitWidth(100);
            imageView.setFitHeight(100);

            Label nameLabel = new Label(top.getName());
            Label priceLabel = new Label("Rp" + Double.toString(top.getPrice()));

            VBox vbox = new VBox(priceLabel, nameLabel);
            vbox.setSpacing(5);
            vbox.setAlignment(Pos.CENTER);

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