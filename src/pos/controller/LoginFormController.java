package pos.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {
    public AnchorPane log;
    public JFXTextField txtUsername;
    public JFXTextField txtPasword;

    public void login(ActionEvent actionEvent) throws IOException {
        if(txtUsername.getText().contains("Ausha")&& txtPasword.getText().contains("1234")){
            Stage stage = (Stage) log.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/pos/view/MainForm.fxml"))));
        }else {
            if((txtUsername.getText().isEmpty())&&(txtPasword.getText().isEmpty())){
                Alert alert = new Alert(Alert.AlertType.INFORMATION,"Empty Fields");
                alert.show();
            }else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION,"Wrong Input Try Again");
                alert.show();
            }
        }

    }
}
