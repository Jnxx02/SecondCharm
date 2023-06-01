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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import secondcharm.Models.Top;
import secondcharm.dao.TopDao;

public class BuySceneTop extends MyScene {
    private Top selectedTop;

    public BuySceneTop(Stage stage) {
        super(stage);
    }

    public void show() {
        VBox root = new VBox();
        Scene scene = new Scene(root, 640, 480);

        // Mengisi Alamat
        Label addressLabel = new Label("Enter Your Address");
        TextField addressTextField = new TextField();
        Label errorLabel = new Label();
        errorLabel.setTextFill(Color.RED);

        // Tombol untuk melakukan pembayaran
        Button payButton = new Button("Buy");
        payButton.setOnAction(e -> {
            String address = addressTextField.getText();
            if (address.isEmpty()) {
                errorLabel.setText("Please enter your address.");
            } else {
                boolean confirmed = showConfirmationDialog("Confirmation", "Are you sure you want to buy this product?");
                if (confirmed) {
                    showInformationDialog("Success", "Product purchased successfully!");
    
                    // Menghapus produk dari database setelah pembelian berhasil
                    TopDao topDao = new TopDao();
                    topDao.deleteFromDatabase(selectedTop);
    
                    // Kembali ke tampilan sebelumnya (Scene2)
                    Scene2 scene2 = new Scene2(stage);
                    scene2.show();
                }
            }
        });

        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(e -> {
            Scene2 scene2 = new Scene2(stage);
            scene2.show();
        });

        HBox hButton = new HBox(cancelButton, payButton);
        hButton.setSpacing(10);
        hButton.setAlignment(Pos.CENTER);

        root.getChildren().addAll(addressLabel, addressTextField, errorLabel, hButton);
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

}
