create sequence if not exists order_item_seq;

create table if not exists order_item
(
    order_item_id bigint not null default nextval ('order_item_seq'),
    order_id uuid,
    restaurant_menu_item_id bigint,
    price numeric(10,2),
    quantity bigint not null,
    constraint order_item_pk primary key (order_item_id),
    constraint order_item_orders_fk foreign key (order_id)
        references orders (order_id),
    constraint restaurant_menu_item_order_item_fk foreign key (restaurant_menu_item_id)
        references restaurant_menu_item (restaurant_menu_item_id)
);

comment on table order_item is 'Продукт';
comment on column order_item.order_item_id is 'ID продукта заказа';
comment on column order_item.order_id is 'Заказ';
comment on column order_item.restaurant_menu_item_id is 'Пункт меню';
comment on column order_item.price is 'цена';
comment on column order_item.quantity is 'количество';