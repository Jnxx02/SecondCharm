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

public class SignUpScene extends MyScene{
    public SignUpScene(Stage stage) {
        super(stage);
    }

    // Menampilkan scene
    public void show() {
        StackPane spLayout = new StackPane();
        Scene scene = new Scene(spLayout, 450, 600);
        scene.getStylesheets().add(getClass().getResource("/styles/LoginScene-style.css").toExternalForm());

        VBox vLayout = new VBox();
        vLayout.setSpacing(8);
        vLayout.setPadding(new Insets(50));
        vLayout.setAlignment(Pos.CENTER);

        // Setting background
        ImageView ivBackground = new ImageView("/images/10.png");
        ivBackground.setFitWidth(scene.getWidth());
        ivBackground.setFitHeight(scene.getHeight());
        spLayout.getChildren().add(ivBackground);

        // Title
        Text title = new Text("Sign Up");
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

        // Sign Up
        Button btnSignUp = new Button("Sign Up");
        btnSignUp.getStyleClass().add("btn-login");
        btnSignUp.setOnAction(event -> {
            String username = txtUsername.getText();
            String password = txtPassword.getText();
        
            // Periksa kecocokan username dan password dari database apakah ada username yang duplikat atau tidak
            if (UserConfig.isUsernameAvailable(username)) {
                // Username tersedia, lanjutkan proses pendaftaran
                UserConfig.registerUser(username, password);
                Scene2 scene2 = new Scene2(stage);
                scene2.show();
            } else {
                // Username sudah digunakan, tampilkan pesan kesalahan
                errorMessage.setText("Username is already exists");
            }
        });
        

        // Opsi Login
        Label labelLogin = new Label("Sudah punya akun? Login");
        labelLogin.setOnMouseClicked(v -> {
            LoginScene loginScene = new LoginScene(stage);
            loginScene.show();
        });


        vLayout.getChildren().addAll(title, lblUsername, txtUsername, lblPassword, txtPassword, errorMessage, btnSignUp, labelLogin);
        spLayout.getChildren().add(vLayout);

        stage.setScene(scene);
    }
}
