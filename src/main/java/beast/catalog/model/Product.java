package beast.catalog.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("productId")
    private String productId;

    @Column(name = "product_title")
    @JsonProperty("productTitle")
    private String productTitle;

    @Column(name = "product_desc")
    @JsonProperty("productDesc")
    private String productDesc;

    @Column(name = "price_usd")
    @JsonProperty("priceUSD")
    private float priceUSD;

    @Column(name = "vendor_id")
    @JsonProperty("vendorId")
    private String vendorId;
}
