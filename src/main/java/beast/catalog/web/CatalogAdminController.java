package beast.catalog.web;

import beast.catalog.catalog.CatalogService;
import beast.catalog.model.Product;
import beast.auth.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
class CatalogAdminController {

    private final CatalogService catalogService;

    @Autowired
    public CatalogAdminController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping(value = "/api/product", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getVendorProducts(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestParam("vendorId") String vendorId
    ) {
        List<Product> products = catalogService.getVendorProducts(vendorId);
        return Optional.ofNullable(products).orElse(List.of());
    }

    @PostMapping(value = "/api/product", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveProduct(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestBody Product product
    ) {
        catalogService.saveProduct(userDetails.getUsername(), product);
    }

}
