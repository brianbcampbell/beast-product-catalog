insert into `vendor` (vendor_id, vendor_name, admin_user_ids)
values ('v1', 'vendor one', 'bcadmin'),
       ('v2', 'vendor two', 'bcadmin'),
       ('v3', 'vendor three', 'bcadmin');

insert into `product` (product_id, product_title, product_desc, price_usd, vendor_id)
values ('p1','product one','product is really great', 44.99, 'v1'),
       ('p2','product two','product 222 is really great', 39.99, 'v1'),
       ('p3','product three','product free is really great', 1.99, 'v2');
