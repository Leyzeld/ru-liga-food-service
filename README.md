<h1>Проект по доставке еды для Лиги Цифровой Экономики</h1>
<br>
<b>Сервис состоит из 7 модулей:</b>
<br>

- dependencies-bom - содержит в себе все зависимости и их версии
- common - общие модули и dto
- migration - миграция БД
- order-service - работа с заказами от клиентов
- kitchen-service - обработка заказов на кухне
- delivery-service - обработка заказов для доставки
- notification-service - передача информации между сервисами через RabbitMQ

<h3>Пользовательский тестовй сценарий запуска</h3>
-Клонировать проект<br>
-Открыть терминал в IntelliJ IDEA и прописать `cd migration`, далее `mvn -Plocal liquibase:update` таким образом все необходимые таблицы для работы будут созданы и заполнены автоматически<br>
-Запустить Rabbit в Docker <b>docker run -lt --rm --name rabbitmq -p 5672:5672
  -p 15672:15672 rabbitmq:3-management</b><br>
-Запустить в такой последовательности <b>order-service</b>, <b>delivery-service</b>, <b>kitchen-service</b>, <b>notification-service</b><br>. Таким образом при запуске автоматически будут созданы требуемые очереди
<br>
<b>После выполнения данных действий можно начинать использовать проект</b>

Методы REST контроллеров, описаны с помощь Swagger, unit-тестами покрыта основная функциональность.
<h4>Ошибки с которыми столкнулся в ходе выполнения работы</h4>
- Oauth2Security в ходе выполнения поставленной задачи перестал работать, из-за ограниченности времени не успел его починить, так же по этой причине не успел сделать Docker Compose (а очень хотел)<br>
- так же не успел перенести часть модулей и сущностей из common, по этому большинство сейчас хранится там<br>

