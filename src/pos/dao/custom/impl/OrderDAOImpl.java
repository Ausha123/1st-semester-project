package pos.dao.custom.impl;

import pos.dao.CrudUtil;
import pos.dao.custom.OrderDAO;
import pos.entity.Order;
import pos.entity.OrderDetail;
import pos.view.tm.Orderutil;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public boolean save(Order order) throws Exception {
        return CrudUtil.execute
                ("INSERT INTO Orders VALUES(?,?,?,?)",
                        order.getId(),order.getDate(),order.getCustomerId(),order.getNet_value());
    }

    @Override
    public boolean update(Order order) throws Exception {
        return CrudUtil.execute("UPDATE Orders SET date=?,CID=?,Net_Value=? WHERE OrderID=?",order.getDate(),order.getCustomerId(),
                order.getNet_value(),order.getId());
       // return CrudUtil.execute("UPDATE BOOKS SET Units=Units-? WHERE BID=?")
    }

    @Override
    public boolean delete(String id) throws Exception {
      return  CrudUtil.execute("DELETE FROM Orders WHERE OrderId=?",id);
    }

    @Override
    public Order get(String id) throws Exception {

        return null;
    }

    @Override
    public ArrayList<Order> getAll() throws Exception {
        return null;
    }

    @Override
    public boolean updateqty(OrderDetail orderDetail) throws SQLException, ClassNotFoundException {
        return  CrudUtil.execute("UPDATE Books set Units=Units-? WHERE BID=?",orderDetail.getQty(),orderDetail.getBid());
    }
}
