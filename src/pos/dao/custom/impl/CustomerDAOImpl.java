package pos.dao.custom.impl;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import pos.dao.CrudUtil;
import pos.dao.custom.CustomerDAO;
import pos.entity.Customer;

import java.sql.ResultSet;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public boolean save(Customer customer) throws Exception {
        return CrudUtil.execute
                ("INSERT INTO Customer VALUES(?,?,?,?,?,?)",
                        customer.getId(),customer.getName(),customer.getMobile(),customer.getEmail(),customer.getAddress(),customer.getCity());

    }

    @Override
    public boolean update(Customer customer) throws Exception {
       return CrudUtil.execute
               ("UPDATE Customer SET Cust_Name=?,Mobile=?,Email=?,Address=?,City=? WHERE CID=? ",
           customer.getName(),customer.getMobile(),customer.getEmail(),customer.getAddress(),customer.getCity(),customer.getId());

    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.execute("DELETE FROM Customer WHERE CID=?",id);
    }

    @Override
    public Customer get(String id) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Customer WHERE CID=?",id);
        if(resultSet.next()) {
            return new Customer(
                  resultSet.getString(1),
                  resultSet.getString(2),
                  resultSet.getInt(3),
                  resultSet.getString(4),
                  resultSet.getString(5),
                  resultSet.getString(6));

        }else{
            return null;

        }
    }

    @Override
    public ArrayList<Customer> getAll() throws Exception {
      ResultSet resultSet = CrudUtil.execute("SELECT * FROM Customer");
      ArrayList<Customer> customerArrayList = new ArrayList<>();
      while (resultSet.next()){
          customerArrayList.add(
                  new Customer(
                          resultSet.getString(1),resultSet.getString(2),resultSet.getInt(3),
                          resultSet.getString(4),resultSet.getString(5),resultSet.getString(6))

          );
      }
      return customerArrayList;
    }
}
