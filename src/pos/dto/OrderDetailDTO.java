package pos.dto;

public class OrderDetailDTO {
    private String OrderId;
    private String BookId;
    private int Qty;
    private double unitprice;

    public OrderDetailDTO(String orderId, String bookId, int qty, double unitprice) {
        setOrderId(orderId);
        setBookId(bookId);
        setQty(qty);
        this.setUnitprice(unitprice);
    }

    public OrderDetailDTO() {
    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }

    public String getBookId() {
        return BookId;
    }

    public void setBookId(String bookId) {
        BookId = bookId;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int qty) {
        Qty = qty;
    }

    public double getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(double unitprice) {
        this.unitprice = unitprice;
    }
}
