create schema if not exists product_catalog;

use product_catalog;

create user if not exists 'app_user' identified by 'app_user_password';

create table vendor
(
    vendor_id   varchar(255) primary key,
    vendor_name varchar(255),
    admin_user_ids text
);
grant insert,delete,select,update on vendor to app_user;

create table product
(
    product_id    varchar(255) primary key,
    product_title varchar(255) not null,
    product_desc  text not null,
    price_usd     float not null,
    vendor_id     varchar(255) not null
);
grant insert,delete,select,update on product to app_user;
