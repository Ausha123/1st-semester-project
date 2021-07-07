package pos.bo.custom;

import pos.dto.CustomerDTO;
import pos.dto.SupplierDTO;

import java.util.ArrayList;

public interface SupplierBO {
    public boolean saveSupplier(SupplierDTO dto)throws Exception;
    public boolean updateSupplier(SupplierDTO dto)throws Exception;
    public boolean deleteSupplier(String id)throws Exception;
    public SupplierDTO getSupplier(String id)throws Exception;
    public ArrayList<SupplierDTO> getAllSuppliers() throws Exception;
    public String getSupplierId() throws Exception;
}
