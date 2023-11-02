create sequence if not exists courier_seq;

create table if not exists courier
(
    courier_id integer not null default nextval ('courier_seq'),
    phone varchar(11) not null,
    coordinates point not null,
    status varchar(255),
    constraint courier_pk primary key (courier_id)
);

comment on table courier is 'Курьеры';
comment on column courier.courier_id is 'ID курьера';
comment on column courier.phone is 'Номер телефон';
comment on column courier.coordinates is 'Координаты';
comment on column courier.status is 'Статус';
