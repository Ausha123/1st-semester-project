package pos.dao.custom;

import pos.dao.CrudDAO;
import pos.entity.Order;
import pos.entity.OrderDetail;

import java.sql.SQLException;

public interface OrderDAO extends CrudDAO<Order, String> {
   public boolean updateqty(OrderDetail orderDetail) throws SQLException, ClassNotFoundException;
}
