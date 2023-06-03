package secondcharm.Scenes;

import java.util.Optional;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import secondcharm.Models.Bottom;
import secondcharm.Models.Top;
import secondcharm.dao.BottomDao;
import secondcharm.dao.TopDao;

public class BuyScene extends MyScene {
    private Top selectedTop;
    private Bottom selectedBottom;

    public BuyScene(Stage stage, Top selectedTop, Bottom selectedBottom) {
        super(stage);
        this.selectedTop = selectedTop;
        this.selectedBottom = selectedBottom;
    }

    @Override
    public void show() {
        StackPane spLayout = new StackPane();
        Scene scene = new Scene(spLayout, 450, 600);
        scene.getStylesheets().add(getClass().getResource("/styles/BuyScene-style.css").toExternalForm());
        
        VBox root = new VBox();

        // Setting background
        ImageView ivBackground = new ImageView("/images/10.png");
        ivBackground.setFitWidth(scene.getWidth());
        ivBackground.setFitHeight(scene.getHeight());
        spLayout.getChildren().add(ivBackground);

        // Mengisi Alamat
        Label addressLabel = new Label("Enter Your Address");
        TextField addressTextField = new TextField();
        Text errorMessage = new Text();

        // Error Message
        errorMessage.getStyleClass().add("error-text");
        errorMessage.setTextAlignment(TextAlignment.CENTER);

        // Payment Method
        Label paymentLabel = new Label("Select Payment Method:");
        ChoiceBox<String> paymentChoiceBox = new ChoiceBox<>();
        paymentChoiceBox.getItems().addAll("Bank Transfer", "Cash on Delivery", "Credit Card");
        paymentChoiceBox.setValue("Bank Transfer");

        // Tombol untuk melakukan pembayaran
        Button payButton = new Button("Buy");
        payButton.setOnAction(e -> {
            String address = addressTextField.getText();
            if (address.isEmpty()) {
                errorMessage.setText("Please enter your address.");
            } else {
                boolean confirmed = showConfirmationDialog("Confirmation", "Are you sure you want to buy this product?");
                if (confirmed) {
                    showInformationDialog("Success", "Product purchased successfully!");
    
                    // Menghapus produk dari database setelah pembelian berhasil
                    if(selectedTop!=null){
                        TopDao topDao = new TopDao();
                        topDao.deleteFromDatabase(selectedTop);
                        
                        try {
                            Thread.sleep(300);
                            ProductScene scene2 = new ProductScene(super.stage);
                            scene2.show();
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }
                        
                    }
                    if(selectedBottom!=null){
                        BottomDao bottomDao = new BottomDao();
                        bottomDao.deleteFromDatabase(selectedBottom);

                        try {
                            Thread.sleep(300);
                            ProductScene scene2 = new ProductScene(super.stage);
                            scene2.show();
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }
                    }
                    
    
                   
                }
            }
        });

        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(e -> {
            ProductScene scene2 = new ProductScene(stage);
            scene2.show();
        });

        HBox hButton = new HBox(cancelButton, payButton);
        hButton.setSpacing(10);
        hButton.setAlignment(Pos.CENTER);

        root.getChildren().addAll(addressLabel, addressTextField, errorMessage, paymentLabel, paymentChoiceBox, hButton);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        root.setPadding(new Insets(10));

        spLayout.getChildren().add(root);
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
        ButtonType cancelButtonType = ButtonType.OK;
        alert.getDialogPane().getButtonTypes().setAll(cancelButtonType);

        Button buyButton = (Button) alert.getDialogPane().lookupButton(cancelButtonType);
        buyButton.setDefaultButton(false);
        buyButton.setText("OK");
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
