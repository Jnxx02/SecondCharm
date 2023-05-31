package secondcharm.dao;

import java.io.ByteArrayInputStream;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import secondcharm.Models.Bottom;

public class BottomCell extends ListCell<Bottom> {
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
            Label priceLabel = new Label(Double.toString(bottom.getPrice()));

            VBox vbox = new VBox(nameLabel, priceLabel);
            vbox.setSpacing(5);
            vbox.setAlignment(Pos.CENTER);

            HBox hBox = new HBox(imageView, vbox);
            hBox.setSpacing(8);

            setText(null);
            setGraphic(hBox);
        }
    }
}