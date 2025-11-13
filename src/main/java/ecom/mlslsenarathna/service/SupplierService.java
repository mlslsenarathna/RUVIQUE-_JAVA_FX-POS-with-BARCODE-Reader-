package ecom.mlslsenarathna.service;

public class SupplierService {
    public boolean isSupplierId(String input) {
        return input != null && input.matches("^S\\d{4}$");
    }

}
