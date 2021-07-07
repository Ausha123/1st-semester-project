package pos.dto;

public class OrderDTO{
    private String id;
    private String date;
    private String customerId;
    private double net_value;
    private String BookID;
    private String Title;
    private int Qty;
    private double Price;

    public OrderDTO() {
    }

    public OrderDTO(String id, String date, String customerId, double net_value, String bookID, String title, int qty, double price) {
        this.setId(id);
        this.setDate(date);
        this.setCustomerId(customerId);
        this.setNet_value(net_value);
        setBookID(bookID);
        setTitle(title);
        setQty(qty);
        setPrice(price);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public double getNet_value() {
        return net_value;
    }

    public void setNet_value(double net_value) {
        this.net_value = net_value;
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

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", customerId='" + customerId + '\'' +
                ", net_value=" + net_value +
                ", BookID='" + BookID + '\'' +
                ", Title='" + Title + '\'' +
                ", Qty=" + Qty +
                ", Price=" + Price +
                '}';
    }
}
