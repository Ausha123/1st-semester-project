package pos.view.tm;

import javafx.scene.control.Button;

public class OrderTM {
    private String BookID;
    private String Title;
    private int Qty;
    private double Price;
    private double Total;
    private Button button;

    public OrderTM(String bookID, String title, int qty, double price, double total, Button button) {
        setBookID(bookID);
        setTitle(title);
        setQty(qty);
        setPrice(price);
        setTotal(total);
        this.setButton(button);
    }

    public OrderTM() {
    }

    public String getBookID() {
        return BookID;
    }

    public void setBookID(String bookID) {
        BookID = bookID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int qty) {
        Qty = qty;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double total) {
        Total = total;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    @Override
    public String toString() {
        return "OrderTM{" +
                "BookID='" + BookID + '\'' +
                ", Title='" + Title + '\'' +
                ", Qty=" + Qty +
                ", Price=" + Price +
                ", Total=" + Total +
                ", button=" + button +
                '}';
    }
}
