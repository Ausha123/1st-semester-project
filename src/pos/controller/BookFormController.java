package pos.controller;

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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import pos.bo.BoFactory;
import pos.bo.custom.BookBO;
import pos.dto.BookDTO;
import pos.dto.CustomerDTO;
import pos.view.tm.BookTM;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class BookFormController implements Initializable {


    public AnchorPane root;
    public ImageView txtPublisher;
    public JFXTextField txtBooktitle;
    public JFXTextField txtBookID;
    public JFXTextField txtAuthor;
    public JFXTextField txtPublisherDate;
    public JFXTextField txtIsbn;
    public JFXTextField txtCategory;
    public JFXTextField txtPrice;
    public TableView <BookTM>tblbook;
    public TableColumn colID;
    public TableColumn colTitle;
    public TableColumn colAuthor;
    public TableColumn colPUblisher;
    public TableColumn colPubdate;
    public TableColumn colUnits;
    public TableColumn colIsbn;
    public TableColumn colCategory;
    public TableColumn colPrice;
    public JFXTextField txtUnits;
    BookBO bookBO;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bookBO= BoFactory.getInstance().getBO(BoFactory.BOType.BOOKS);
        try {
            getbookId();
        } catch (Exception e) {
            e.printStackTrace();
        }

        tblbook.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblbook.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblbook.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("author"));
        tblbook.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("pubDate"));
        tblbook.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("units"));
        tblbook.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("isbn"));
        tblbook.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("category"));
        tblbook.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("price"));

        loadallBooks();
    }


    public void BookDelete(ActionEvent actionEvent) throws IOException {

    }

    public void btnBookcancle(ActionEvent actionEvent) {
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

    public void Booksave(ActionEvent actionEvent) {

        if(Pattern.compile("^(B00)[1-9]{1}$").matcher(txtBookID.getText()).matches()){
            if(Pattern.compile("^[A-z]{1,}$").matcher(txtBooktitle.getText()).matches()){
                if(Pattern.compile("^[A-z]{1,}$").matcher(txtAuthor.getText()).matches()){
                    if(Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$").matcher(txtPublisherDate.getText()).matches()){
                        if(Pattern.compile("^[0-9]{1,}(0)$").matcher(txtPrice.getText()).matches()){
                            if(Pattern.compile("^[0-9]{1,}$").matcher(txtUnits.getText()).matches()){
                                if(Pattern.compile("^[0-9]{1,}$").matcher(txtIsbn.getText()).matches()){
                                    if(Pattern.compile("^[A-z]{1,}$").matcher(txtCategory.getText()).matches()){
                                        try {
                                            boolean issaved = bookBO.saveBook(new BookDTO(txtBookID.getText(),txtBooktitle.getText(),
                                                    txtAuthor.getText(),txtPublisherDate.getText(),Integer.parseInt(txtUnits.getText()),txtIsbn.getText(),txtCategory.getText(),Double.parseDouble(txtPrice.getText())));
                                            if(issaved){
                                                Alert alert = new Alert(Alert.AlertType.INFORMATION,"Book is Saved");
                                                alert.show();
                                                loadallBooks();
                                                clearFields();
                                            }else {
                                                Alert alert = new Alert(Alert.AlertType.INFORMATION,"Book is Not Saved");
                                                alert.show();
                                                loadallBooks();
                                            }
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }else {
                                        txtCategory.setFocusColor((Paint.valueOf("red")));
                                        txtCategory.requestFocus();
                                    }


                                }else{
                                    txtIsbn.setFocusColor(Paint.valueOf("red"));
                                    txtIsbn.requestFocus();
                                }


                            }else{
                                txtUnits.setFocusColor((Paint.valueOf("red")));
                                txtUnits.requestFocus();
                            }

                        }else{
                            txtPrice.setFocusColor(Paint.valueOf("red"));
                            txtPrice.requestFocus();
                        }

                    }else{
                        txtPublisherDate.setFocusColor((Paint.valueOf("red")));
                        txtPublisherDate.requestFocus();
                    }


                }else{
                    txtAuthor.setFocusColor((Paint.valueOf("red")));
                    txtAuthor.requestFocus();

                }

            }else{
                txtBooktitle.setFocusColor((Paint.valueOf("red")));
                txtBooktitle.requestFocus();

            }



        }else {
            txtBookID.setFocusColor(Paint.valueOf("red"));
            txtBookID.requestFocus();
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Pattern Not Matched");
            alert.show();
        }



    }

    public void Bookupdate(ActionEvent actionEvent) {
        try {
            boolean isupdate = bookBO.updateBook(new BookDTO(txtBookID.getText(),txtBooktitle.getText(),txtAuthor.getText(),
            txtPublisherDate.getText(),Integer.parseInt(txtUnits.getText()),txtIsbn.getText(),txtCategory.getText(),Double.parseDouble(txtPrice.getText())));
         if(isupdate){
             Alert alert = new Alert(Alert.AlertType.INFORMATION,"Updated");
             alert.show();;
             loadallBooks();
         }else{
             Alert alert = new Alert(Alert.AlertType.INFORMATION,"NOt Updated");
             alert.show();

         }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Bookdelete(ActionEvent actionEvent) {
        try {
            boolean isdelete = bookBO.deleteBook(txtBookID.getText());
            if(isdelete){
                Alert alert = new Alert(Alert.AlertType.INFORMATION,"Delete Success");
                alert.show();
                clearFields();
                loadallBooks();
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION,"Delete Fail");
                alert.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Searchbooks(ActionEvent actionEvent) {
        BookDTO bookDTO = null;
        try {
            bookDTO = bookBO.getBook(txtBookID.getText());
            if(bookDTO !=null) {
                txtBooktitle.setText(bookDTO.getName());
                txtAuthor.setText(bookDTO.getAuthor());
                txtPublisherDate.setText(bookDTO.getPubDate());
                txtUnits.setText(bookDTO.getUnits()+"");
                txtIsbn.setText(bookDTO.getUnits()+"");
                txtCategory.setText(bookDTO.getCategory());
                txtPrice.setText(bookDTO.getPrice() + "");
            }else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION,"Book not found");
                alert.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void clearFields(){
        txtBookID.clear();
        txtBooktitle.clear();
        txtAuthor.clear();;
        txtPublisherDate.clear();
        txtPrice.clear();
        txtUnits.clear();
        txtIsbn.clear();
        txtCategory.clear();
    }
 public void loadallBooks(){
        try {
         ObservableList<BookTM> bookList = FXCollections.observableArrayList();
         ArrayList<BookDTO> allbooks = bookBO.getAllBooks();
        for(BookDTO bookDTO : allbooks){
            bookList.add(new BookTM(bookDTO.getId(),bookDTO.getName(),bookDTO.getAuthor(),bookDTO.getPubDate(),bookDTO.getUnits(),
                    bookDTO.getIsbn(),bookDTO.getCategory(),bookDTO.getPrice()));
        }
        tblbook.setItems(bookList);
     } catch (Exception e) {
         e.printStackTrace();
     }
 }

 public void getbookId() throws Exception {
     String id=bookBO.getBookId();
     txtBookID.setText(id);
 }
 public void validation(){

 }

}
