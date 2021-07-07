package pos.dao;

import pos.dao.custom.impl.*;

public class DaoFactory {
    private static DaoFactory daoFactory;
    private  DaoFactory(){
    }

    public static DaoFactory getInstance(){
        return (daoFactory==null)?(daoFactory=new DaoFactory()) : (daoFactory);
    }

    public enum DAOType{
        CUSTOMER,BOOKS,SUPPLIER,ORDER,ORDER_DETAIL,QUERY
    }
    public <T> T getDao(DAOType type){
        switch (type){
            case CUSTOMER:
                return (T) new CustomerDAOImpl();
            case BOOKS:
                return (T) new BookDAOImpl();
            case SUPPLIER:
                return (T) new SupplierDAOImpl();
            case ORDER:
                return (T) new OrderDAOImpl();
            case ORDER_DETAIL:
                return (T) new OrderDetailImpl();
            case QUERY:
                return (T) new QueryDAOImpl();
            default:
                return null;
        }
    }
}
