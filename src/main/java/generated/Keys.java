/*
 * This file is generated by jOOQ.
 */
package generated;


import generated.tables.Product;
import generated.tables.Users;
import generated.tables.Vendor;
import generated.tables.records.ProductRecord;
import generated.tables.records.UsersRecord;
import generated.tables.records.VendorRecord;

import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * product_catalog.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<ProductRecord> KEY_PRODUCT_PRIMARY = Internal.createUniqueKey(Product.PRODUCT, DSL.name("KEY_product_PRIMARY"), new TableField[] { Product.PRODUCT.PRODUCT_ID }, true);
    public static final UniqueKey<UsersRecord> KEY_USERS_PRIMARY = Internal.createUniqueKey(Users.USERS, DSL.name("KEY_users_PRIMARY"), new TableField[] { Users.USERS.USERNAME }, true);
    public static final UniqueKey<VendorRecord> KEY_VENDOR_PRIMARY = Internal.createUniqueKey(Vendor.VENDOR, DSL.name("KEY_vendor_PRIMARY"), new TableField[] { Vendor.VENDOR.VENDOR_ID }, true);
}
