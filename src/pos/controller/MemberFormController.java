package pos.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import org.w3c.dom.ls.LSOutput;
import pos.bo.BoFactory;
import pos.bo.custom.CustomerBO;
import pos.dto.CustomerDTO;
import pos.view.tm.CustomerTM;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class MemberFormController implements Initializable {

    public AnchorPane root;
    public JFXTextField txtCustname;
    public JFXTextField txtCustid;
    public JFXTextField txtCustmobile;
    public JFXTextField txtCustemail;
    public JFXTextField txtCustcity;
    public JFXTextField txtCustaddress;
    public TableView <CustomerTM>tblCust;
    public TableColumn collCustid;
    public TableColumn colCustname;
    public TableColumn colCustmobile;
    public TableColumn colCustemail;
    public TableColumn colCustaddress;
    public TableColumn colCustcity;
    public JFXButton btnCustsave;
    public JFXButton btnCustupdate;
    public JFXButton btnCustdelete;
    CustomerBO customerBO;




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        customerBO=BoFactory.getInstance().getBO(BoFactory.BOType.CUSTOMER);
        try {
            loadcustomerId();
        } catch (Exception e) {
            e.printStackTrace();
        }

        tblCust.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblCust.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblCust.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("mobile"));
        tblCust.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("email"));
        tblCust.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblCust.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("city"));

        Allcustomers();
    }



   public void loadcustomerId() throws Exception {
        String id=customerBO.getCustomerId();
        txtCustid.setText(id);
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


    public void custSave(MouseEvent mouseEvent) {
        if(Pattern.compile("^(C00)[1-9]{1}$").matcher(txtCustid.getText()).matches()){
            if(Pattern.compile("^[A-z]{1,}\\s|[A-z]{1,}$").matcher(txtCustname.getText()).matches()) {
                if(Pattern.compile("^[0-9]{9,10}$").matcher(txtCustmobile.getText()).matches()) {
                    if(Pattern.compile("^(.+)@(.+)$").matcher(txtCustemail.getText()).matches()){

                            if(Pattern.compile("^[A-z]{1,}$").matcher(txtCustcity.getText()).matches()){
                                try {
                                    boolean issaved = customerBO.saveCustomer(new CustomerDTO(txtCustid.getText(), txtCustname.getText(), Integer.parseInt(txtCustmobile.getText()),
                                            txtCustemail.getText(), txtCustaddress.getText(), txtCustcity.getText()));
                                    if(issaved){
                                        Alert alert = new Alert(Alert.AlertType.INFORMATION,"Customer is Saved");
                                        alert.show();
                                        clearFields();
                                        Allcustomers();
                                    }else{
                                        Alert alert = new Alert(Alert.AlertType.INFORMATION,"Customer Not Saved");
                                        alert.show();
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }else{
                                txtCustcity.setFocusColor(Paint.valueOf("red"));
                                txtCustcity.requestFocus();
                            }



                    }else{
                        txtCustemail.setFocusColor(Paint.valueOf("red"));
                        txtCustmobile.requestFocus();
                    }
                }else{
                    txtCustmobile.setFocusColor(Paint.valueOf("red"));
                    txtCustmobile.requestFocus();

                }
            }else{
                txtCustname.setFocusColor(Paint.valueOf("red"));
                txtCustname.requestFocus();
            }

        }else{
            txtCustid.setFocusColor(Paint.valueOf("red"));
            txtCustid.requestFocus();
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Pattern Not Matched");
            alert.show();
        }

    }

    public void Customerupdate(ActionEvent actionEvent) {
        try {
            boolean isupdate = customerBO.updateCustomer(new CustomerDTO(txtCustid.getText(),txtCustname.getText(),
                    Integer.parseInt(txtCustmobile.getText()),txtCustemail.getText(),txtCustaddress.getText(),txtCustcity.getText()));
          if (isupdate){
              Alert alert = new Alert(Alert.AlertType.INFORMATION,"Update Success");
              alert.show();
              Allcustomers();
              clearFields();
          }else{
              Alert alert = new Alert(Alert.AlertType.INFORMATION,"Update Fail");
              alert.show();
          }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void CustomerDelete(ActionEvent actionEvent) {
        try {
            boolean isdelete = customerBO.deleteCustomer(txtCustid.getText());
        if(isdelete){
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Delete Success");
            alert.show();
            clearFields();
            Allcustomers();
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Delete Fail");
            alert.show();
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Customersearch(ActionEvent actionEvent) {
        CustomerDTO customerDTO = null;
        try {
            customerDTO = customerBO.getCustomer(txtCustid.getText());
            txtCustname.setText(customerDTO.getName());
            txtCustmobile.setText(customerDTO.getMobile() + "");
            txtCustemail.setText(customerDTO.getEmail());
            txtCustaddress.setText(customerDTO.getAddress());
            txtCustcity.setText(customerDTO.getCity());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void clearFields(){
        txtCustid.clear();
        txtCustname.clear();
        txtCustmobile.clear();
        txtCustemail.clear();
        txtCustaddress.clear();
        txtCustemail.clear();

    }
    public void Allcustomers(){
        try {
            ObservableList<CustomerTM> customerList = FXCollections.observableArrayList();
            ArrayList<CustomerDTO> allCustomers = customerBO.getAllCustomers();
         for(CustomerDTO customerDTO : allCustomers){
             customerList.add(new CustomerTM(
                     customerDTO.getId(),customerDTO.getName(),customerDTO.getMobile(),customerDTO.getEmail(),
                     customerDTO.getAddress(),customerDTO.getCity()
             ));
         }
         tblCust.setItems(customerList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  void validation() {

    }

}
