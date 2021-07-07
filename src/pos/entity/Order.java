package pos.entity;

public class Order implements SuperEntity {
    private String id;
    private String date;
    private String customerId;
    private double net_value;

    public Order(String id, String date, String customerId, double net_value) {
        this.setId(id);
        this.setDate(date);
        this.setCustomerId(customerId);
        this.setNet_value(net_value);
    }

    public Order() {
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

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", customerId='" + customerId + '\'' +
                ", net_value=" + net_value +
                '}';
    }
}
