create sequence if not exists customer_seq;

create table if not exists customer
(
    customer_id integer not null default nextval ('customer_seq'),
    phone varchar(11) not null,
    email varchar(320),
    address text not null,
    constraint customer_pk primary key (customer_id)
);

comment on table customer is 'Клиенты';
comment on column customer.customer_id is 'Идентификатор клиента';
comment on column customer.phone is 'Телефон';
comment on column customer.email is 'Почта';
comment on column customer.address is 'Адрес';