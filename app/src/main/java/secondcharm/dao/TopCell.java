package secondcharm.dao;

import java.io.ByteArrayInputStream;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import secondcharm.Models.Top;
import javafx.scene.image.Image;

public class TopCell extends ListCell<Top> {
    @Override
    protected void updateItem(Top top, boolean empty) {
        super.updateItem(top, empty);

        if (empty || top == null) {
            setText(null);
            setGraphic(null);
        } else {
            // Tampilkan informasi atasan sesuai kebutuhan, misalnya gambar, nama, dan harga
            ImageView imageView = new ImageView(new Image(new ByteArrayInputStream(top.getImage())));
            imageView.setFitWidth(100);
            imageView.setFitHeight(100);

            Label nameLabel = new Label(top.getName());
            Label priceLabel = new Label("Rp" + Double.toString(top.getPrice()));

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