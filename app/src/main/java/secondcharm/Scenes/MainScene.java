package secondcharm.Scenes;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import secondcharm.Models.Top;

public class MainScene extends MyScene {
    private Top selectedTop;

    public MainScene(Stage stage) {
        super(stage);
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
        stage.show();
    }

    private void deleteTopFromDatabase(Top top) {
        // TODO: Menghapus top dari database
        // Implementasikan logika untuk menghapus top dari database
    }
}
