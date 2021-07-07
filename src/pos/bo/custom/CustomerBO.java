package pos.bo.custom;

import pos.dto.CustomerDTO;

import java.util.ArrayList;

public interface CustomerBO {
    public boolean saveCustomer(CustomerDTO dto)throws Exception;
    public boolean updateCustomer(CustomerDTO dto)throws Exception;
    public boolean deleteCustomer(String id)throws Exception;
    public CustomerDTO getCustomer(String id)throws Exception;
    public ArrayList<CustomerDTO>getAllCustomers() throws Exception;
    public String getCustomerId() throws Exception;
}
