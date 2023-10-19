create sequence if not exists restaurant_seq;

create table if not exists restaurant
(
    restaurant_id integer not null default nextval ('restaurant_seq'),
    address varchar(256) not null,
    status varchar(128),
    constraint restaurant_pk primary key (restaurant_id)
);

comment on table customer is 'Клиенты';
comment on column restaurant.restaurant_id is 'ID ресторана';
comment on column restaurant.status is 'Статус';
comment on column restaurant.address is 'Адрес';