package pos.bo.custom;

import pos.dto.AllOrderDetailDTO;
import pos.dto.CustomerDTO;
import pos.dto.OrderDTO;
import pos.dto.OrderDetailDTO;
import pos.entity.AllOrderDetail;
import pos.entity.OrderDetail;
import pos.view.tm.OrderDetailTM;
import pos.view.tm.OrderTM;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface OrderBO {
    public boolean saveOrder(OrderDTO dto)throws Exception;
    public boolean updateOrdere(OrderDTO dto)throws Exception;
    public boolean deleteOrder(String id)throws Exception;
    public CustomerDTO getOrder(String id)throws Exception;
    public ArrayList<OrderDTO> getllOrders() throws Exception;
    public String getOrderId() throws Exception;
    public boolean placeOrder(OrderDTO order, ArrayList<OrderDetailDTO> orderDetails) throws Exception;
    public ArrayList<AllOrderDetailDTO> getAllOrderDetail(String id) throws Exception;
    public boolean updateqty(OrderDetail orderDetail) throws SQLException, ClassNotFoundException;
}
