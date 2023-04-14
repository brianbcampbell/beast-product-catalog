package beast.catalog.vendor;

import beast.catalog.model.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendorService {

    private final VendorRepository vendorRepository;

    @Autowired
    public VendorService(
            VendorRepository vendorRepository
    ) {
        this.vendorRepository = vendorRepository;
    }

    public Vendor getVendor(String vendorId) {
        return vendorRepository.getVendor(vendorId);
    }

    public void saveVendor(String username, Vendor vendor) {
        vendorRepository.save(vendor, username);
    }


}
