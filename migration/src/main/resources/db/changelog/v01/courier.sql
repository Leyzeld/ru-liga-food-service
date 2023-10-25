create sequence if not exists courier_seq;

create table if not exists courierDto
(
    courier_id bigint not null default nextval ('courier_seq'),
    phone varchar(11) not null,
    coordinates float not null,
    status varchar(255) not null,
    constraint courier_pk primary key (courier_id)
);

comment on table courierDto is 'Курьеры';
comment on column courierDto.courier_id is 'ID курьера';
comment on column courierDto.phone is 'Номер телефона';
comment on column courierDto.coordinates is 'Координаты';
comment on column courierDto.status is 'Статус';
