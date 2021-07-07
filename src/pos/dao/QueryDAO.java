package pos.dao;

public interface QueryDAO extends SuperDAO {
    public String getCustomerId()throws Exception;
    public String getBookId()throws Exception;
    public String getSupplierId()throws Exception;
    public String getReturnId()throws Exception;
    public String getOrderId() throws Exception;
    }
