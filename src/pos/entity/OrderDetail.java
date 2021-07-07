package pos.entity;

public class OrderDetail implements SuperEntity {
    private String orderid;
    private String Bid;
    private int qty;
    private double unitprice;

    public OrderDetail(String orderid, String bid, int qty, double unitprice) {
        this.setOrderid(orderid);
        setBid(bid);
        this.setQty(qty);
        this.setUnitprice(unitprice);
    }

    public OrderDetail() {
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getBid() {
        return Bid;
    }

    public void setBid(String bid) {
        Bid = bid;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(double unitprice) {
        this.unitprice = unitprice;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderid='" + orderid + '\'' +
                ", Bid='" + Bid + '\'' +
                ", qty=" + qty +
                ", unitprice=" + unitprice +
                '}';
    }
}
