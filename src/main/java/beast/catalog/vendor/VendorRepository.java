package beast.catalog.vendor;

import beast.catalog.model.Vendor;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static generated.Tables.VENDOR;

@Service
class VendorRepository {

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

    public void save(Vendor vendor, String username) {

    }
}
