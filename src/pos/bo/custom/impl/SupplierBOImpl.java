package pos.bo.custom.impl;

import pos.bo.custom.SupplierBO;
import pos.dao.DaoFactory;
import pos.dao.QueryDAO;
import pos.dao.custom.BookDAO;
import pos.dao.custom.SupplierDAO;
import pos.dto.CustomerDTO;
import pos.dto.SupplierDTO;
import pos.entity.Customer;
import pos.entity.Supplier;

import java.util.ArrayList;

public class SupplierBOImpl implements SupplierBO {
    private SupplierDAO supplierDAO = DaoFactory.getInstance()
            .getDao(DaoFactory.DAOType.SUPPLIER);
    private QueryDAO queryDAO = DaoFactory.getInstance()
            .getDao(DaoFactory.DAOType.QUERY);
    @Override
    public boolean saveSupplier(SupplierDTO dto) throws Exception {
        return supplierDAO.save(new Supplier(dto.getId(),dto.getSupplay_name(),dto.getCompany_name(),
                dto.getContact(),dto.getAddress(),dto.getFax(),dto.getEmail()));
    }

    @Override
    public boolean updateSupplier(SupplierDTO dto) throws Exception {
        return supplierDAO.update(new Supplier(dto.getId(),dto.getSupplay_name(),dto.getCompany_name(),
                dto.getContact(),dto.getAddress(),dto.getFax(),dto.getEmail()));
    }

    @Override
    public boolean deleteSupplier(String id) throws Exception {
        return supplierDAO.delete(id);
    }

    @Override
    public SupplierDTO getSupplier(String id) throws Exception {
        Supplier supplier = supplierDAO.get(id);
        return new SupplierDTO(supplier.getId(),supplier.getSupplay_name(),supplier.getCompany_name(),
        supplier.getContact(),supplier.getAddress(),supplier.getFax(),supplier.getEmail());
    }

    @Override
    public ArrayList<SupplierDTO> getAllSuppliers() throws Exception {
        ArrayList<Supplier> supplierArrayList = supplierDAO.getAll();
        ArrayList<SupplierDTO> dtoArrayList = new ArrayList();
        for (Supplier supplier : supplierArrayList) {
            dtoArrayList.add(new SupplierDTO(supplier.getId(), supplier.getSupplay_name(),supplier.getCompany_name(),
            supplier.getContact(),supplier.getAddress(),supplier.getFax(),supplier.getEmail()));
        }
        return dtoArrayList;
    }

    @Override
    public String getSupplierId() throws Exception {
        return queryDAO.getSupplierId();
    }
}
