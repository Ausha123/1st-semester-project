package pos.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
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
import javafx.stage.Stage;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import pos.bo.BoFactory;
import pos.bo.custom.SupplierBO;
import pos.db.DBConnection;
import pos.dto.BookDTO;
import pos.dto.SupplierDTO;
import pos.view.tm.SupplierTM;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class SupplierFormController implements Initializable {

    public AnchorPane root;
    public JFXTextField txtsupName;
    public JFXButton btnsupSave;
    public JFXTextField txtSupplierid;
    public JFXTextField txtcomName;
    public JFXTextField txtSupcon;
    public JFXTextField txtsupAdress;
    public JFXTextField txtsupFax;
    public TableView<SupplierTM> tblsupplier;
    public TableColumn colsupId;
    public TableColumn colsupName;
    public TableColumn colComname;
    public TableColumn colContact;
    public TableColumn colAddress;
    public TableColumn colFax;
    public TableColumn colEmail;
    public JFXTextField txtsupEmail;
    SupplierBO supplierBO;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        supplierBO = BoFactory.getInstance().getBO(BoFactory.BOType.SUPPLIER);
        try {
            getsupplierId();
        } catch (Exception e) {
            e.printStackTrace();
        }

        tblsupplier.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblsupplier.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("supplay_name"));
        tblsupplier.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("company_name"));
        tblsupplier.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("contact"));
        tblsupplier.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblsupplier.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("fax"));
        tblsupplier.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("email"));

        loadallSuppliers();
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


    public void supUpdate(ActionEvent actionEvent) {
        try {
            boolean isupdate = supplierBO.updateSupplier(new SupplierDTO(txtSupplierid.getText(),txtsupName.getText(),
                    txtcomName.getText(),Integer.parseInt(txtSupcon.getText()),txtsupAdress.getText(),txtsupFax.getText(),txtsupEmail.getText()));
            if(isupdate){
                Alert alert = new Alert(Alert.AlertType.INFORMATION,"Update Success");
                alert.show();
                loadallSuppliers();
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION,"Update Fail");
                alert.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void supDelete(ActionEvent actionEvent) {
        try {
            boolean isdelete = supplierBO.deleteSupplier(txtSupplierid.getText());
        if(isdelete){
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Delete Success");
            alert.show();
            loadallSuppliers();
        }else {
            Alert alert= new Alert(Alert.AlertType.INFORMATION,"Delete Fail");
            alert.show();
            clearFields();
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void supSave(ActionEvent actionEvent) {
        try {
            boolean issaved = supplierBO.saveSupplier(new SupplierDTO(txtSupplierid.getText(),txtsupName.getText(),
            txtcomName.getText(),Integer.parseInt(txtSupcon.getText()),txtsupAdress.getText(),txtsupFax.getText(),txtsupEmail.getText()));
            if(issaved){
                Alert alert = new Alert(Alert.AlertType.INFORMATION,"Supplier is Saved");
                alert.show();
                clearFields();
                loadallSuppliers();

                try {
                    InputStream is = this.getClass().getResourceAsStream("pos/reports/Supplier.jrxml");
                    JasperReport jr = JasperCompileManager.compileReport(is);


                    HashMap hm = new HashMap();
                    hm.put("supplierid", txtSupplierid.getText());
                    hm.put("suppliername", txtsupName.getText());
                    hm.put("companyname", txtcomName.getText());
                    hm.put("address", txtsupAdress.getText());
                    hm.put("contact", txtSupcon.getText());

                    JasperPrint jp = JasperFillManager.fillReport(jr, hm, DBConnection.getInstance().getConnection());
                    JasperViewer.viewReport(jp, false);
                } catch (JRException e) {
                    e.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }


            }else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION,"Supplier Not Saved");
                alert.show();
                clearFields();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void Searchsupplier(ActionEvent actionEvent) {
        SupplierDTO supplierDTO = null;
        try {
            supplierDTO = supplierBO.getSupplier(txtSupplierid.getText());
            if(supplierDTO!=null) {


                txtsupName.setText(supplierDTO.getSupplay_name());
                txtcomName.setText(supplierDTO.getCompany_name());
                txtSupcon.setText(supplierDTO.getContact() + "");
                txtsupAdress.setText(supplierDTO.getAddress());
                txtsupFax.setText(supplierDTO.getFax());
                txtsupEmail.setText(supplierDTO.getEmail());
            }else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION,"Supplier NOt found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void clearFields(){
        txtSupplierid.clear();
        txtsupName.clear();
        txtcomName.clear();
        txtSupcon.clear();
        txtsupAdress.clear();
        txtsupFax.clear();
        txtsupEmail.clear();
    }

    public void loadallSuppliers(){

        try {
            ObservableList<SupplierTM> suppList = FXCollections.observableArrayList();
            ArrayList<SupplierDTO> allSupp = supplierBO.getAllSuppliers();
          for(SupplierDTO supplierDTO : allSupp){
              suppList.add(new SupplierTM(supplierDTO.getId(),supplierDTO.getSupplay_name(),supplierDTO.getCompany_name(),
                      supplierDTO.getContact(),supplierDTO.getAddress(),supplierDTO.getFax(),supplierDTO.getEmail()));
          }
          tblsupplier.setItems(suppList);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getsupplierId() throws Exception {
        String id=supplierBO.getSupplierId();
        txtSupplierid.setText(id);
    }



}
