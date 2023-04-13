package beast.cart.models;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Column(name = "product_id")
    private String productId;
    @Column(name = "product_title")
    private String productTitle;
    @Column(name = "product_desc")
    private String productDesc;
    @Column(name = "price_usd")
    private float priceUSD;
    @Column(name = "vendor_id")
    private String vendorId;
}
