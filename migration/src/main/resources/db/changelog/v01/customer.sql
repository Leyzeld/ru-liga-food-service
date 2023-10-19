create sequence if not exists customer_seq;

create table if not exists customer
(
    customer_id integer not null default nextval ('customer_seq'),
    phone varchar(11) not null,
    email varchar(320) not null,
    address text not null,
    constraint customer_pk primary key (customer_id)
);

comment on table customer is 'Клиенты';
comment on column customer.customer_id is 'ID клиента';
comment on column customer.phone is 'Номер телефона';
comment on column customer.email is 'Почта';
comment on column customer.address is 'Адрес';