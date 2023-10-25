create sequence if not exists restaurant_menu_item_seq;

create table if not exists restaurant_menu_item
(
    restaurant_menu_item_id bigint not null default nextval ('restaurant_menu_item_seq'),
    restaurant_id bigint,
    name varchar(255) not null,
    price numeric(10,2) not null,
    description text,
    image text,
    constraint restaurant_menu_item_pk primary key (restaurant_menu_item_id),
    constraint restaurant_menu_item_restaurant_fk foreign key (restaurant_id)
        references restaurant (restaurant_id)
);

comment on table restaurant_menu_item is 'Заказ';
comment on column restaurant_menu_item.restaurant_menu_item_id is 'ID меню';
comment on column restaurant_menu_item.restaurant_id is 'Ресторан';
comment on column restaurant_menu_item.name is 'Название';
comment on column restaurant_menu_item.price is 'Цена';
comment on column restaurant_menu_item.description is 'Описание';
comment on column restaurant_menu_item.image is 'Изображение';