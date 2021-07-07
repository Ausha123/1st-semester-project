package pos.dao.custom.impl;

import pos.dao.CrudUtil;
import pos.dao.QueryDAO;

import java.sql.ResultSet;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public String getCustomerId() throws Exception {
        ResultSet set = CrudUtil.
                execute("SELECT CID FROM Customer ORDER BY  CID DESC LIMIT 1");
        String id="C001";
        if (set.next()){
           String[] s = set.getString(1).split("C");
           int newID = Integer.parseInt(s[1])+ 1;
            if (newID<10){
                id="C00"+ newID;
            }else if(newID<100){
                id = "C0" + newID;
            }else {
                id = "C" + newID;
            }
        }
        return id;
    }


    @Override
    public String getBookId() throws Exception {
        ResultSet set = CrudUtil.
                execute("SELECT BID FROM Books ORDER BY  BID DESC LIMIT 1");
        String id = "B001";
        if (set.next()) {
            String[] s = set.getString(1).split("B");
            int newID = Integer.parseInt(s[1]) + 1;
            if (newID < 10) {
                id = "B00" + newID;
            } else if (newID < 100) {
                id = "B0" + newID;
            } else {
                id = "B" + newID;
            }
        }
        return id;
    }


    @Override
    public String getSupplierId() throws Exception {
        ResultSet set = CrudUtil.
                execute("SELECT SID FROM Supplier ORDER BY  SID DESC LIMIT 1");
        String id = "S001";
        if (set.next()) {
            String[] s = set.getString(1).split("S");
            int newID = Integer.parseInt(s[1]) + 1;
            if (newID < 10) {
                id = "S00" + newID;
            } else if (newID < 100) {
                id = "S0" + newID;
            } else {
                id = "S" + newID;
            }
        }
        return id;
    }


    @Override
    public String getReturnId() throws Exception {
        return null;
    }

    @Override
    public String getOrderId() throws Exception {
        ResultSet set = CrudUtil.execute("SELECT OrderID FROM Orders ORDER BY OrderID DESC LIMIT 1");
      String id = "OD001";
      if(set.next()){
          String [] s = set.getString(1).split("OD");
          int newID = Integer.parseInt(s[1])+1;
          if(newID < 10){
              id = "OD00"+newID;
          }else if (newID<100){
              id = "OD0"+newID ;
          }else {
              id = "OD" + newID;
          }

      }
        return id;
    }
}
