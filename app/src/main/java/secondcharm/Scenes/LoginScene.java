package secondcharm.Scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class LoginScene {
    private Stage stage;

    public LoginScene(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        StackPane spLayout = new StackPane();
        Scene scene = new Scene(spLayout, 640, 480);
        scene.getStylesheets().add(getClass().getResource("/styles/LoginScene-style.css").toExternalForm());

        VBox vLayout = new VBox();
        vLayout.setSpacing(8);
        vLayout.setPadding(new Insets(50));
        vLayout.setAlignment(Pos.CENTER);

        //Setting background
        ImageView ivBackground = new ImageView("/images/login-bg-2.png");
        ivBackground.setFitWidth(scene.getWidth());
        ivBackground.setFitHeight(scene.getHeight());
        spLayout.getChildren().add(ivBackground);

        // Title
        Text title = new Text("Login");
        title.getStyleClass().add("title-text");

        // Username Field
        Label lblUsername = new Label("Username");
        TextField txtUsername = new TextField();
        txtUsername.setPromptText("Enter your username");

        // Password Field
        Label lblPassword = new Label("Password");
        PasswordField txtPassword = new PasswordField();
        txtPassword.setPromptText("Enter your password");

        // Error Message
        Text errorMessage = new Text();
        errorMessage.getStyleClass().add("error-text");
        errorMessage.setTextAlignment(TextAlignment.CENTER);

        // Login Button
        Button btnLogin = new Button("Login");
        btnLogin.getStyleClass().add("btn-login");
        btnLogin.setOnAction(event -> {
            String username = txtUsername.getText();
            String password = txtPassword.getText();
            
            // Periksa kecocokan username dan password dari database
            if (checkCredentials(username, password)) {
                // Jika login berhasil, arahkan ke scene selanjutnya
                Scene2 scene2 = new Scene2(stage);
                scene2.show();
            } else {
                // Jika login gagal, tampilkan pesan kesalahan
                errorMessage.setText("Invalid username or password. Please try again.");
            }
        });

        vLayout.getChildren().addAll(title, lblUsername, txtUsername, lblPassword, txtPassword, errorMessage, btnLogin);
        spLayout.getChildren().add(vLayout);

        stage.setScene(scene);
    }

    private boolean checkCredentials(String username, String password) {
        // TODO: Periksa kecocokan username dan password dengan data di database
        // Misalnya, menggunakan kueri ke database atau membandingkan dengan data yang telah disimpan
        // Return true jika cocok, false jika tidak cocok
        // Berikut adalah contoh sederhana untuk keperluan demonstrasi:
        return username.equals("admin") && password.equals("admin123");
    }
}
