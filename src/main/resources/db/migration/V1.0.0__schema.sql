create schema if not exists product_catalog;

use product_catalog;

create user if not exists 'app_user' identified by 'app_user_password';

create table vendor
(
    vendor_id   varchar(255) primary key,
    vendor_name varchar(255),
    admin_user_ids text
);
grant create,delete,select,update on vendor to app_user;

create table product
(
    product_id    varchar(255) primary key,
    product_title varchar(255),
    product_desc  text,
    price_usd     float,
    vendor_id     varchar(255)
);
grant create,delete,select,update on product to app_user;
