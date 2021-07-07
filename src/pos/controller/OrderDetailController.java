package pos.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.sun.org.omg.CORBA.Initializer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import pos.bo.BoFactory;
import pos.bo.custom.OrderBO;
import pos.dao.DaoFactory;
import pos.dao.custom.OrderDAO;
import pos.dao.custom.OrderDetailDAO;
import pos.dto.AllOrderDetailDTO;
import pos.entity.AllOrderDetail;
import pos.view.tm.AllOrderDetailTM;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class OrderDetailController implements Initializable {
    public AnchorPane root;
    public TableView<AllOrderDetailTM> tblorderdetail;
    public JFXTextField txtOrderID;
    public JFXButton btngeneratereports;
    private OrderBO orderBO= BoFactory.getInstance().getBO(BoFactory.BOType.ORDER);
    @Override
    public void initialize(URL location, ResourceBundle resources) {



    }

    public void bookform(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/pos/view/BookForm.fxml"))));
    }

    public void customerform(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/pos/view/MemberForm.fxml"))));
    }

    public void supplierform(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/pos/view/SupplierForm.fxml"))));
    }

    public void orderform(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/pos/view/PlaceorderForm.fxml"))));
    }


    public void orderdetailform(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/pos/view/OrderdetailForm.fxml"))));
    }

    public void bookreturnform(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/pos/view/BookreturnForm.fxml"))));
    }

    public void homeform(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/pos/view/MainForm.fxml"))));
    }

    public void BookDelete(ActionEvent actionEvent) {
    }

    public void loadAllReservation(ActionEvent actionEvent) throws Exception {
        tblorderdetail.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("orderId"));
        tblorderdetail.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("orderDate"));
        tblorderdetail.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("customerId"));
        tblorderdetail.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("customerName"));
        tblorderdetail.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("total"));
        tblorderdetail.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("bookId"));


        ArrayList<AllOrderDetailDTO> allOrderDetail = orderBO.getAllOrderDetail(txtOrderID.getText());
        ObservableList<AllOrderDetailTM> list = FXCollections.observableArrayList();
        for (AllOrderDetailDTO a : allOrderDetail){
            list.add(new AllOrderDetailTM(
                    a.getOrderId(),
                    a.getOrderDate(),
                    a.getCustomerId(),
                    a.getCustomerName(),
                    a.getBookId(),
                    a.getTotal()
            ));
        }
        tblorderdetail.setItems(list);
    }

    public void generatereports(ActionEvent actionEvent) {

    }
}
