/*
 * This file is generated by jOOQ.
 */
package generated.tables.records;


import generated.tables.Vendor;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class VendorRecord extends UpdatableRecordImpl<VendorRecord> implements Record3<String, String, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>product_catalog.vendor.vendor_id</code>.
     */
    public void setVendorId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>product_catalog.vendor.vendor_id</code>.
     */
    public String getVendorId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>product_catalog.vendor.vendor_name</code>.
     */
    public void setVendorName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>product_catalog.vendor.vendor_name</code>.
     */
    public String getVendorName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>product_catalog.vendor.admin_user_ids</code>.
     */
    public void setAdminUserIds(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>product_catalog.vendor.admin_user_ids</code>.
     */
    public String getAdminUserIds() {
        return (String) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<String, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<String, String, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return Vendor.VENDOR.VENDOR_ID;
    }

    @Override
    public Field<String> field2() {
        return Vendor.VENDOR.VENDOR_NAME;
    }

    @Override
    public Field<String> field3() {
        return Vendor.VENDOR.ADMIN_USER_IDS;
    }

    @Override
    public String component1() {
        return getVendorId();
    }

    @Override
    public String component2() {
        return getVendorName();
    }

    @Override
    public String component3() {
        return getAdminUserIds();
    }

    @Override
    public String value1() {
        return getVendorId();
    }

    @Override
    public String value2() {
        return getVendorName();
    }

    @Override
    public String value3() {
        return getAdminUserIds();
    }

    @Override
    public VendorRecord value1(String value) {
        setVendorId(value);
        return this;
    }

    @Override
    public VendorRecord value2(String value) {
        setVendorName(value);
        return this;
    }

    @Override
    public VendorRecord value3(String value) {
        setAdminUserIds(value);
        return this;
    }

    @Override
    public VendorRecord values(String value1, String value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached VendorRecord
     */
    public VendorRecord() {
        super(Vendor.VENDOR);
    }

    /**
     * Create a detached, initialised VendorRecord
     */
    public VendorRecord(String vendorId, String vendorName, String adminUserIds) {
        super(Vendor.VENDOR);

        setVendorId(vendorId);
        setVendorName(vendorName);
        setAdminUserIds(adminUserIds);
    }
}
