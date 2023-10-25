create sequence if not exists restaurant_seq;

create table if not exists restaurantDto
(
    restaurant_id bigint not null default nextval ('restaurant_seq'),
    address varchar(256) not null,
    status varchar(128),
    constraint restaurant_pk primary key (restaurant_id)
);

comment on table customer is 'Клиенты';
comment on column restaurantDto.restaurant_id is 'ID ресторана';
comment on column restaurantDto.status is 'Статус';
comment on column restaurantDto.address is 'Адрес';