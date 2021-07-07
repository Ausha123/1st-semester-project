package pos.dao.custom;

import pos.dao.CrudDAO;
import pos.entity.AllOrderDetail;
import pos.entity.OrderDetail;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderDetailDAO extends CrudDAO<OrderDetail,String> {
    public ArrayList<AllOrderDetail> getAllOrderDetail(String id) throws Exception;
}
