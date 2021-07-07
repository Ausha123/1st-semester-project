package pos.entity;

public class Supplier implements SuperEntity {
    private String id;
    private String supplay_name;
    private String company_name;
    private int contact;
    private String address;
    private String fax;
    private String email;

    public Supplier(String id, String supplay_name, String company_name, int contact, String address, String fax, String email) {
        this.setId(id);
        this.setSupplay_name(supplay_name);
        this.setCompany_name(company_name);
        this.setContact(contact);
        this.setAddress(address);
        this.setFax(fax);
        this.setEmail(email);
    }

    public Supplier() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSupplay_name() {
        return supplay_name;
    }

    public void setSupplay_name(String supplay_name) {
        this.supplay_name = supplay_name;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id='" + id + '\'' +
                ", supplay_name='" + supplay_name + '\'' +
                ", company_name='" + company_name + '\'' +
                ", contact=" + contact +
                ", address='" + address + '\'' +
                ", fax='" + fax + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}