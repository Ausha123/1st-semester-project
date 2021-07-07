package pos.view.tm;

import pos.entity.OrderDetail;
import pos.entity.SuperEntity;

import java.util.ArrayList;

public class Orderutil implements SuperEntity {
    private String id;
    private String date;
    private String customerId;
    private double net_value;
    private ArrayList<OrderDetail> orderdetailList = new ArrayList<>();


    public Orderutil() {
    }

    public Orderutil(String id, String date, String customerId, double net_value, ArrayList<OrderDetail> orderdetailList) {
        this.setId(id);
        this.setDate(date);
        this.setCustomerId(customerId);
        this.setNet_value(net_value);
        this.setOrderdetailList(orderdetailList);
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

    public ArrayList<OrderDetail> getOrderdetailList() {
        return orderdetailList;
    }

    public void setOrderdetailList(ArrayList<OrderDetail> orderdetailList) {
        this.orderdetailList = orderdetailList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", customerId='" + customerId + '\'' +
                ", net_value='" + net_value + '\'' +
                ", orderdetailList=" + orderdetailList +
                '}';
    }
}
