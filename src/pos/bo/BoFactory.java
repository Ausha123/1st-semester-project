package pos.bo;

import com.sun.org.apache.bcel.internal.generic.SWITCH;
import pos.bo.custom.impl.BookBOImpl;
import pos.bo.custom.impl.CustomerBOImpl;
import pos.bo.custom.impl.OrderBOImpl;
import pos.bo.custom.impl.SupplierBOImpl;
import pos.dao.custom.impl.BookDAOImpl;
import pos.dao.custom.impl.CustomerDAOImpl;

public class BoFactory {
    private static BoFactory boFactory;

    private BoFactory() {
    }

    public static BoFactory getInstance() {
        return (boFactory == null) ?
                (boFactory = new BoFactory()) : (boFactory);
    }

    public enum BOType {
        CUSTOMER, BOOKS,SUPPLIER, ORDER, ORDER_DETAIL
    }

    public <T> T getBO(BOType type) {
        switch (type) {
            case CUSTOMER:
                return (T) new CustomerBOImpl();
            case BOOKS:
                return (T) new BookBOImpl();
            case SUPPLIER:
                return (T) new SupplierBOImpl();
            case ORDER:
                return (T) new OrderBOImpl();
            default:
                return null;
        }
    }
}
