package pos.dao.custom.impl;

import pos.dao.CrudUtil;
import pos.dao.custom.SupplierDAO;
import pos.entity.Book;
import pos.entity.Customer;
import pos.entity.Supplier;

import java.sql.ResultSet;
import java.util.ArrayList;

public class SupplierDAOImpl implements SupplierDAO {
    @Override
    public boolean save(Supplier supplier) throws Exception {

            return CrudUtil.execute
                    ("INSERT INTO Supplier VALUES(?,?,?,?,?,?,?)",
                        supplier.getId(),supplier.getSupplay_name(),supplier.getCompany_name(),supplier.getContact(),supplier.getAddress(),supplier.getFax(),supplier.getEmail());
        }

    @Override
    public boolean update(Supplier supplier) throws Exception {
        return CrudUtil.execute
                ("UPDATE Supplier SET Supplier_Name=?,CompanyName=?,Contact=?,Address=?,Fax=?,Email=? WHERE SID=? ",
                        supplier.getSupplay_name(),supplier.getCompany_name(),supplier.getContact(),supplier.getAddress(),supplier.getFax(),supplier.getEmail(),supplier.getId());

    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtil.execute("DELETE FROM Supplier WHERE SID=?",s);
    }

    @Override
    public Supplier get(String s) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Supplier WHERE SID=?",s);
        if(resultSet.next()) {
            return new Supplier(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7));

        }else{
            return null;

        }
    }

    @Override
    public ArrayList<Supplier> getAll() throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Supplier");
        ArrayList<Supplier> supplierArrayList = new ArrayList<>();
        while (resultSet.next()){
            supplierArrayList.add(
                    new Supplier(
                            resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),
                            resultSet.getInt(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7))

            );
        }
        return supplierArrayList;
    }

}
