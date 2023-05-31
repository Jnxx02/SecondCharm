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
import secondcharm.Utils.UserConfig;

public class LoginScene extends MyScene{
    public LoginScene(Stage stage) {
        super(stage);
    }

    // Menampilkan scene
    public void show() {
        StackPane spLayout = new StackPane();
        Scene scene = new Scene(spLayout, 600, 480);
        scene.getStylesheets().add(getClass().getResource("/styles/LoginScene-style.css").toExternalForm());

        VBox vLayout = new VBox();
        vLayout.setSpacing(8);
        vLayout.setPadding(new Insets(50));
        vLayout.setAlignment(Pos.CENTER);

        // Setting background
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
            if (UserConfig.validasiLogin(username, password)) {
                // Jika login berhasil, arahkan ke scene selanjutnya
                Scene2 scene2 = new Scene2(stage) ;
                scene2.show();
            } else {
                // Jika login gagal, tampilkan pesan kesalahan
                errorMessage.setText("Invalid username or password. Please try again.");
            }
        });

        // Opsi Sign Up
        Label labelSignUp = new Label("Belum punya akun? Sign Up");
        labelSignUp.setOnMouseClicked(v -> {
            SignUpScene signUpScene = new SignUpScene(stage);
            signUpScene.show();
        });

        vLayout.getChildren().addAll(title, lblUsername, txtUsername, lblPassword, txtPassword, errorMessage, btnLogin, labelSignUp);
        spLayout.getChildren().add(vLayout);

        stage.setScene(scene);
    }
}
