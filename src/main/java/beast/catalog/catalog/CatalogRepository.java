package beast.catalog.catalog;

import beast.catalog.model.Product;
import generated.tables.records.ProductRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.List;

import static generated.Tables.PRODUCT;

@Service
class CatalogRepository {

    private final DSLContext jooq;

    @Autowired
    CatalogRepository(DSLContext jooq) {
        this.jooq = jooq;
    }


    public List<Product> getProductsByVendor(String vendorId) {
        return jooq
                .select()
                .from(PRODUCT)
                .where(PRODUCT.VENDOR_ID.eq(vendorId))
                .fetchInto(Product.class);
    }

    public Product getProduct(String productId) {
        return jooq
                .selectFrom(PRODUCT)
                .where(PRODUCT.PRODUCT_ID.eq(productId))
                .fetchAnyInto(Product.class);
    }

    public void save(Product newProduct, String username) {

        ProductRecord productRecord = jooq.newRecord(PRODUCT);
        productRecord.setProductId(newProduct.getProductId());
        productRecord.setProductTitle(newProduct.getProductTitle());
        productRecord.setProductDesc(newProduct.getProductDesc());
        productRecord.setPriceUsd((double) newProduct.getPriceUSD());
        productRecord.setVendorId(newProduct.getVendorId());

        Product currentProduct = getProduct(newProduct.getProductId());
        if (currentProduct != null) {
            //if product does exist, make sure vendor is correct
            if (!currentProduct.getProductId().equals(newProduct.getProductId()))
                throw new AccessDeniedException("not authorized for this product");
            productRecord.update();
            return;
        }
        productRecord.insert();
    }

}
