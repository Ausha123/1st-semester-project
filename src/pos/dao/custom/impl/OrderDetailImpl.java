package pos.dao.custom.impl;

import pos.dao.CrudUtil;
import pos.dao.custom.OrderDetailDAO;
import pos.entity.AllOrderDetail;
import pos.entity.OrderDetail;

import java.sql.ResultSet;
import java.util.ArrayList;

public class OrderDetailImpl implements OrderDetailDAO {
    @Override
    public boolean save(OrderDetail orderDetail) throws Exception {
        return CrudUtil.execute("INSERT INTO OrderDetail VALUES (?,?,?,?) ",orderDetail.getOrderid(),orderDetail.getBid(),
                orderDetail.getQty(),orderDetail.getUnitprice());
    }

    @Override
    public boolean update(OrderDetail orderDetail) throws Exception {
        return CrudUtil.execute("UPDATE OrderDetail SET BID=?,qty=?,unitPrice=?,WHERE OrderID=?",orderDetail.getBid(),
                orderDetail.getQty(),orderDetail.getUnitprice(),orderDetail.getOrderid());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.execute("DELETE FROM OrderDetail WHERE OrderID=? ",id);
    }

    @Override
    public OrderDetail get(String id) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM OrderDetail WHERE OrderID=?",id);
        if(rst.next()){
            return new OrderDetail(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getInt(3),
                    rst.getDouble(4));

        }else{
            return null;
        }

    }

    @Override
    public ArrayList<OrderDetail> getAll() throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM OrderDetail");
        ArrayList<OrderDetail> OrderDetailArrayList = new ArrayList<>();
        while (resultSet.next()){
            OrderDetailArrayList.add(
                    new OrderDetail(
                            resultSet.getString(1),resultSet.getString(2),
                            resultSet.getInt(3),resultSet.getDouble(4))

            );
        }
        return OrderDetailArrayList;
    }

    @Override
    public ArrayList<AllOrderDetail> getAllOrderDetail(String id) throws Exception {
        ResultSet res = CrudUtil.execute("SELECT * from (( Orders inner join Customer  on  Customer.CID=Orders.CID) inner join OrderDetail on Orders.OrderID=OrderDetail.OrderID) where Orders.OrderID=?", id);
        ArrayList<AllOrderDetail> allOrderDetails=new ArrayList<>();
        while(res.next()){
            allOrderDetails.add(new AllOrderDetail(
            res.getString(1),
            res.getString(2),
            res.getString(3),
            res.getString(6),
            res.getString(12),
            res.getDouble(14)
            ));
        }
        return allOrderDetails;
    }
}

