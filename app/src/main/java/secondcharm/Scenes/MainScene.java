package secondcharm.Scenes;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import secondcharm.Models.Top;

public class MainScene {
    private Stage stage;
    private Top selectedTop;

    public MainScene(Stage stage, Top selectedTop) {
        this.stage = stage;
        this.selectedTop = selectedTop;
    }

    public void show()  {
        VBox root = new VBox();
        Scene scene = new Scene(root, 640, 480);

        // Membuat tampilan untuk memasukkan alamat pengiriman
        Label addressLabel = new Label("Alamat Pengiriman:");
        TextField addressTextField = new TextField();

        // Tombol untuk melakukan pembayaran
        Button payButton = new Button("Bayar");
        payButton.setOnAction(e -> {
            // Melakukan logika pembayaran
            // ...
            // Setelah pembayaran selesai, hapus produk dari database
            deleteTopFromDatabase(selectedTop);
            // Kembali ke tampilan sebelumnya (Scene2)
            Scene2 scene2 = new Scene2(stage);
            scene2.show();
        });

        root.getChildren().addAll(addressLabel, addressTextField, payButton);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        root.setPadding(new Insets(10));

        stage.setScene(scene);
    }

    private void deleteTopFromDatabase(Top top) {
        // TODO: Menghapus top dari database
        // Implementasikan logika untuk menghapus top dari database
    }
}
