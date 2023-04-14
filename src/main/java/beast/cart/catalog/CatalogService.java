package beast.cart.catalog;

import beast.cart.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogService {

    private final CatalogRepository catalogRepository;

    @Autowired
    public CatalogService(
            CatalogRepository catalogRepository
    ) {
        this.catalogRepository = catalogRepository;
    }

    public List<Product> getVendorProducts(String vendorId) {
        return catalogRepository.getProductsByVendor(vendorId);
    }

    public void saveProduct(String username, Product newProduct) {
        catalogRepository.save(newProduct, username);
    }


}
