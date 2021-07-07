package pos.bo.custom.impl;

import pos.bo.custom.CustomerBO;
import pos.dao.DaoFactory;
import pos.dao.QueryDAO;
import pos.dao.custom.CustomerDAO;
import pos.dto.CustomerDTO;
import pos.entity.Customer;

import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {
    private CustomerDAO customerDAO = DaoFactory.getInstance()
            .getDao(DaoFactory.DAOType.CUSTOMER);
    private QueryDAO queryDAO = DaoFactory.getInstance()
            .getDao(DaoFactory.DAOType.QUERY);




    @Override
    public boolean saveCustomer(CustomerDTO dto) throws Exception {
        return customerDAO.save(new Customer(dto.getId(),dto.getName(),dto.getMobile(),
        dto.getEmail(),dto.getAddress(),dto.getCity()));
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) throws Exception {
        return customerDAO.update(new Customer(dto.getId(),dto.getName(),dto.getMobile(),
                dto.getEmail(),dto.getAddress(),dto.getCity()));
    }

    @Override
    public boolean deleteCustomer(String id) throws Exception {
        return customerDAO.delete(id);
    }

    @Override
    public CustomerDTO getCustomer(String id) throws Exception {
       Customer c = customerDAO.get(id);
       return new CustomerDTO(c.getId(),c.getName(),c.getMobile(),c.getEmail(),
       c.getAddress(),c.getCity());
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws Exception {
        ArrayList<Customer> customerArrayList = customerDAO.getAll();
        ArrayList<CustomerDTO> dtoArrayList = new ArrayList();
        for (Customer c : customerArrayList) {
            dtoArrayList.add(new CustomerDTO(c.getId(), c.getName(), c.getMobile(), c.getEmail(),
                    c.getAddress(), c.getCity()));
        }
        return dtoArrayList;
    }

    @Override
    public String getCustomerId() throws Exception {
        return queryDAO.getCustomerId();
    }

}
