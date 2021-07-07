package pos.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import pos.bo.BoFactory;
import pos.bo.custom.BookBO;
import pos.bo.custom.CustomerBO;
import pos.bo.custom.OrderBO;
import pos.dto.BookDTO;
import pos.dto.CustomerDTO;
import pos.dto.OrderDTO;
import pos.dto.OrderDetailDTO;
import pos.entity.OrderDetail;
import pos.view.tm.BookTM;
import pos.view.tm.OrderDetailTM;
import pos.view.tm.OrderTM;
import sun.plugin.javascript.navig.Array;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class PlaceorderFormController implements Initializable {


    public AnchorPane root;
    public JFXTextField txtmemName;
    public JFXTextField txtmemberID;
    public JFXTextField txtmemMobile;
    public JFXTextField txtmemEmail;
    public JFXTextField txtmemAddress;
    public TableView<OrderDetailTM> tblPlaceorder;
    public JFXTextField txtmemCity;
    public JFXTextField txtbookId;
    public JFXTextField txtTitle;
    public JFXTextField txtAuthor;
    public JFXTextField txtIsbn;
    public JFXTextField txtCategory;
    public JFXTextField txtPrice;
    public JFXButton btnAdd;
    public JFXTextField txtorderId;
    public JFXTextField txtSubtotal;
    public JFXButton btnPlaceOrder;
    public JFXTextField txtDate;
    public JFXComboBox comboCustomer;
    public JFXComboBox comboBook;
    public JFXTextField txtunits;
    public TableColumn colBookId;
    public TableColumn colTitle;
    public TableColumn colPrice;
    public TableColumn colTotal;
    ArrayList<OrderDetailDTO> orderDetailDTOS;
    public JFXTextField txtqtyonhand;
    public JFXTextField txtqty;
    public JFXTextField txttotal;
    public TableColumn colqty;
    private OrderBO orderBO;
    private CustomerBO customerBO;
    private BookBO bookBO;
    private BookTM tm;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        customerBO = BoFactory.getInstance().getBO(BoFactory.BOType.CUSTOMER);
        orderBO = BoFactory.getInstance().getBO(BoFactory.BOType.ORDER);
        bookBO = BoFactory.getInstance().getBO(BoFactory.BOType.BOOKS);
        try {
            loadOrderid();
            genarateDate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            ObservableList<String> customer = FXCollections.observableArrayList();
            ArrayList<CustomerDTO> allCustomers = customerBO.getAllCustomers();
            for (CustomerDTO c : allCustomers) {
                customer.add(c.getId());
            }
            comboCustomer.setItems(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            ObservableList<String> books = FXCollections.observableArrayList();
            ArrayList<BookDTO> allBooks = bookBO.getAllBooks();
            for (BookDTO b : allBooks) {
                books.add(b.getId());
            }
            comboBook.setItems(books);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void loadOrderid() throws Exception {
        String id = orderBO.getOrderId();
        txtorderId.setText(id);
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


    public void PlaceOrderOnAction(MouseEvent mouseEvent) {
    }

    public void genarateDate() {
        LocalDate d1 = LocalDate.now();
        txtDate.setText(d1.toString());
    }


    public void Clearfields() {

        txtmemName.clear();
        txtmemMobile.clear();
        txtmemEmail.clear();
        txtmemAddress.clear();
        txtmemCity.clear();
        txtTitle.clear();
        txtAuthor.clear();
        txtunits.clear();
        txtCategory.clear();
        txtPrice.clear();
        txtqtyonhand.clear();
        txtqty.clear();
        txttotal.clear();

    }

    public void DeleteFeilds(ActionEvent actionEvent) {
        Clearfields();
    }





    public void loadCustomersID(ActionEvent actionEvent) {
        try {
            CustomerDTO customerDTO = customerBO.getCustomer(comboCustomer.getValue().toString());
            txtmemName.setText(customerDTO.getName());
            txtmemMobile.setText(customerDTO.getMobile() + "");
            txtmemEmail.setText(customerDTO.getEmail());
            txtmemAddress.setText(customerDTO.getAddress());
            txtmemCity.setText(customerDTO.getCity());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadBooksID(ActionEvent actionEvent) {
        try {
            BookDTO bookDTO = bookBO.getBook(comboBook.getValue().toString());
            txtAuthor.setText(bookDTO.getAuthor());
            txtTitle.setText(bookDTO.getName());
            txtunits.setText(bookDTO.getUnits() + "");
            txtCategory.setText(bookDTO.getCategory());
            txtPrice.setText(bookDTO.getPrice() + "");
            txtqtyonhand.setText(bookDTO.getUnits() + "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private ArrayList<OrderDetailDTO> getAllOrderDetails(){
        orderDetailDTOS=new ArrayList<>() ;
        int dataFilldrowCount = tblPlaceorder.getItems().size();
        String orderID =txtorderId.getText();
        for(int i = 0; i<dataFilldrowCount; i++){

            String bookID = (String) colBookId.getCellData(i);
            int qty = (int) colqty.getCellData(i);
            double Price = (double) colPrice.getCellData(i);

            OrderDetailDTO orderDetailDTO=new OrderDetailDTO(
                    orderID,
                    bookID,
                    qty,
                    Price
            );
            orderDetailDTOS.add(orderDetailDTO);
            //System.out.println("orderDetailDTOS = " + orderDetailDTOS);

        }
        return orderDetailDTOS;
    }

    public void PlaceOrder(ActionEvent actionEvent) throws Exception {
        if (comboCustomer.getSelectionModel().getSelectedIndex() == -1) {
            new Alert(Alert.AlertType.ERROR, "You need to select a customer", ButtonType.OK).show();
            comboCustomer.requestFocus();
            return;
        }

        if (tblPlaceorder.getItems().size() == 0) {
            new Alert(Alert.AlertType.ERROR, "Empty Fields", ButtonType.OK).show();
            comboCustomer.requestFocus();
            return;
        }


        boolean result=orderBO.placeOrder(new OrderDTO(
                txtorderId.getText(),
                txtDate.getText(),
                comboCustomer.getValue().toString(),
                Double.parseDouble(txtSubtotal.getText()),
                comboBook.getValue().toString(),
                txtTitle.getText(),
                Integer.parseInt(txtqty.getText()),
                Double.parseDouble(txtPrice.getText())
        ),getAllOrderDetails());

        if(result){
            new Alert(Alert.AlertType.INFORMATION,"Order Added").show();
        }else{
            new Alert(Alert.AlertType.INFORMATION,"Order Added Fail").show();
        }
    }



    public void calculateTotal() {

        ObservableList<OrderDetailTM> orderDetails = tblPlaceorder.getItems();
        double netTotal = 0;
        for (OrderDetailTM orderDetail : orderDetails) {
            netTotal += orderDetail.getTotal();
        }
        txtSubtotal.setText( netTotal+"");
    }

    ObservableList<OrderDetailTM>observableList=FXCollections.observableArrayList();

    public void AddplaceOrder(ActionEvent actionEvent) {
        if (txtqty.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Qty can't be empty", ButtonType.OK).show();
            return;
        }
        int qty = Integer.parseInt(txtqty.getText());
        if (qty < 1 || qty > Integer.parseInt(txtqtyonhand.getText())) {
            new Alert(Alert.AlertType.ERROR, "Invalid Qty.", ButtonType.OK).show();
            return;
        }

        tblPlaceorder.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("BookID"));
        tblPlaceorder.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Title"));
        tblPlaceorder.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Qty"));
        tblPlaceorder.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("price"));
        tblPlaceorder.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("Total"));
        tblPlaceorder.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("button"));

            String code = String.valueOf(comboBook.getValue());
            String desc = txtTitle.getText();
            int Qty =Integer.parseInt(txtqty.getText());
            double unitPrice = Double.parseDouble(txtPrice.getText());
            Button b1= new Button("Delete");
            try {
                txttotal.setText((Double.parseDouble(txtPrice.getText())* Integer.parseInt(txtqty.getText()))+"");
                if (!observableList.isEmpty()) { // check observableList is empty
                    for (int i = 0; i < tblPlaceorder.getItems().size(); i++) { // check all rows in table
                        if (tblPlaceorder.getColumns().get(0).getCellData(i).equals(code)) { // check  itemcode in table == itemcode we enter
                            double temp = Integer.parseInt((String) colqty.getCellData(i)); // get qty in table for temp
                            temp += Qty; // add new qty to old qty
                            double tot = (temp * unitPrice); // get new total
                            observableList.get(i).setQty((int) temp); // set new qty to observableList
                            observableList.get(i).setTotal(tot); // set new total to observableList
                            calculateTotal();
                            orderDetailDTOS.add(new OrderDetailDTO(
                                    txtorderId.getText(),
                                    txtbookId.getText(),
                                    Integer.parseInt(txtqty.getText()),
                                    Double.parseDouble(txtPrice.getText())
                            ));
                           // System.out.println("orderDetailDTOS = " + orderDetailDTOS);
                            tblPlaceorder.refresh(); // refresh table
                            return;
                        }
                    }
                }
                observableList.add(new OrderDetailTM(code,desc,qty,unitPrice,(unitPrice*qty),b1));
                tblPlaceorder.setItems(observableList); // if their is no list or, no matched itemco
                calculateTotal();



            }catch (ClassCastException classCastException) {

            }

    }

}