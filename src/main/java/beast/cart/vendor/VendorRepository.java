package beast.cart.vendor;

import beast.cart.models.Vendor;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static generated.Tables.VENDOR;

@Service
public class VendorRepository {

    private final DSLContext jooq;

    @Autowired
    public VendorRepository(DSLContext jooq) {
        this.jooq = jooq;
    }

    public Vendor getVendor(String vendorId) {
        return jooq
                .selectFrom(VENDOR)
                .where(VENDOR.VENDOR_ID.eq(vendorId))
                .fetchAnyInto(Vendor.class);
    }
}
