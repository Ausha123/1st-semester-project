package pos.bo.custom.impl;

import pos.bo.custom.OrderBO;
import pos.dao.DaoFactory;
import pos.dao.QueryDAO;
import pos.dao.custom.BookDAO;
import pos.dao.custom.OrderDAO;
import pos.dao.custom.OrderDetailDAO;
import pos.db.DBConnection;
import pos.dto.AllOrderDetailDTO;
import pos.dto.CustomerDTO;
import pos.dto.OrderDTO;
import pos.dto.OrderDetailDTO;
import pos.entity.AllOrderDetail;
import pos.entity.Order;
import pos.entity.OrderDetail;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderBOImpl implements OrderBO {
    private OrderDAO orderDAO = DaoFactory.getInstance().getDao(DaoFactory.DAOType.ORDER);
    private QueryDAO queryDAO = DaoFactory.getInstance().getDao(DaoFactory.DAOType.QUERY);
    private OrderDetailDAO orderDetailDAO = DaoFactory.getInstance().getDao(DaoFactory.DAOType.ORDER_DETAIL);
    private BookDAO bookDAO = DaoFactory.getInstance().getDao(DaoFactory.DAOType.BOOKS);

    @Override
    public boolean saveOrder(OrderDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean updateOrdere(OrderDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean deleteOrder(String id) throws Exception {
        return false;
    }

    @Override
    public CustomerDTO getOrder(String id) throws Exception {
        return null;
    }

    @Override
    public ArrayList<OrderDTO> getllOrders() throws Exception {
        return null;
    }

    @Override
    public String getOrderId() throws Exception {
        return queryDAO.getOrderId();
    }


    @Override
    public boolean placeOrder(OrderDTO order, ArrayList<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException {
        try {
            DBConnection.getInstance().getConnection().setAutoCommit(false);
            boolean isSaved = orderDAO.save(new Order(order.getId(), order.getDate(), order.getCustomerId(), order.getNet_value()));

            boolean isDetailSaved = false;
            for (OrderDetailDTO d : orderDetails) {
                isDetailSaved = orderDetailDAO.save(new OrderDetail(
                        d.getOrderId(),
                        d.getBookId(),
                        d.getQty(),
                        d.getUnitprice()
                ));


            }

            if (isSaved && isDetailSaved) {
                DBConnection.getInstance().getConnection().commit();
                return true;
            } else {
                DBConnection.getInstance().getConnection().rollback();
                return false;
            }

        } catch (Exception e) {
            DBConnection.getInstance().getConnection().rollback();
            return false;
        } finally {
            DBConnection.getInstance().getConnection().setAutoCommit(true);
        }
    }

    @Override
    public ArrayList<AllOrderDetailDTO> getAllOrderDetail(String id) throws Exception {
        ArrayList<AllOrderDetail> allOrderDetail = orderDetailDAO.getAllOrderDetail(id);
        ArrayList<AllOrderDetailDTO> allOrderDetailDTOS = new ArrayList<>();
        for (AllOrderDetail a : allOrderDetail) {
            allOrderDetailDTOS.add(new AllOrderDetailDTO(
                    a.getOrderId(),
                    a.getOrderDate(),
                    a.getCustomerId(),
                    a.getCustomerName(),
                    a.getBookId(),
                    a.getTotal()
            ));
        }
        return allOrderDetailDTOS;
    }

    @Override
    public boolean updateqty(OrderDetail orderDetail) throws SQLException, ClassNotFoundException {
       return orderDAO.updateqty(orderDetail);

    }

}
