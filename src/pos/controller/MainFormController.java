package pos.controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class MainFormController implements Initializable {
    public AnchorPane root;
    public JFXButton btnBookreturn;
    public Label lbllocaldate;
    public Label lbllocalTime;

    private void setUI(String location) throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/pos/view/" + location))));
    }


    public void bookForm(ActionEvent actionEvent) throws IOException {
        setUI("BookForm.fxml");
    }

    public void customerform(ActionEvent actionEvent) throws IOException {
        setUI("MemberForm.fxml");
    }

    public void Supplierform(ActionEvent actionEvent) throws IOException {
        setUI("SupplierForm.fxml");
    }

    public void openOrderform(ActionEvent actionEvent) throws IOException {
        setUI("PlaceorderForm.fxml");
    }

    public void logout(ActionEvent actionEvent) throws IOException {
        setUI("LoginForm.fxml");
    }

    public void openBookreturnform(ActionEvent actionEvent) throws IOException {
        setUI("BookreturnForm.fxml");
    }

    public void openOrderdetailform(ActionEvent actionEvent) throws IOException {
        setUI("OrderdetailForm.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lbllocaldate.setText(LocalDate.now().toString());
        localdate();


    }
    public void localdate(){
        Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO,e->{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");
            lbllocalTime.setText(LocalDateTime.now().format(formatter));}),
                new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        }
    }


