create sequence if not exists order_seq;

create table if not exists orders
(
    order_id integer not null default nextval ('order_seq'),
    customer_id integer,
    restaurant_id integer,
    status varchar(128),
    courier_id bigint,
    timestamp timestamptz not null default now(),
    constraint order_pk primary key (order_id),
    constraint order_customer_fk foreign key (customer_id)
        references customer (customer_id),
    constraint order_restaurant_fk foreign key (restaurant_id)
        references restaurant (restaurant_id),
    constraint order_courier_fk foreign key (courier_id)
        references courier (courier_id)
);

comment on table orders is 'Заказ';
comment on column orders.order_id is 'Идентификатор клиента';
comment on column orders.customer_id is 'Клиент';
comment on column orders.restaurant_id is 'Ресторан';
comment on column orders.status is 'Статус';
comment on column orders.courier_id is 'Курьер';
comment on column orders.timestamp is 'Время заказа';