INSERT INTO courier (phone, coordinates, status)
VALUES
    ('+7XXXXXXXXX', 32.0, 'работает'),
    ('+78XXXXXXXX', 3.0, 'завершен'),
    ('+789XXXXXXX', 0.0, 'отклонен');

INSERT INTO customer (phone, email, address)
VALUES
    ('-7XXXXXXXXX', 'test1@test.com', 'Улица Пушкина'),
    ('-78XXXXXXXX', 'test2@test.com', 'Дом Колотушкина'),
    ('-789XXXXXXX', 'test3@test.com', 'Караганда');

INSERT INTO restaurant (address, status)
VALUES
    ('Улица Колотушкина', 'Открыт'),
    ('Дом Пушкина', 'Открыт'),
    ('Где-то', 'Закрыт');

INSERT INTO orders (customer_id, restaurant_id, status, courier_id)
VALUES
    (1, 1, 'Доставляется', 1),
    (2, 2, 'Доставлен', 2),
    (3, 3, 'Отклонен', 3);

INSERT INTO restaurant_menu_item (restaurant_id, name, price, description, image)
VALUES
    (1, 'Пицца', 1488.99, 'Большая царская пицца', 'pic1.png'),
    (2, 'Бургер', 169.99, 'Тройной чизбургер', 'pic2.png'),
    (3, 'Суп', 132.00, 'Вкусный супчик', 'pic3.png');

-- Добавление тестовых данных в таблицу order_item
INSERT INTO order_item (order_id, restaurant_menu_item_id,price, quantity)
VALUES
    (1, 1, 5, 1),
    (2, 2, 5, 2),
    (3, 3, 5, 3);
