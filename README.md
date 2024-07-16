# Выпускной проект Рудько Максима

### При подготовке выпускного проекта для тестирования использовался сайт https://megatop.by/. 
 Мегатоп онлайн-магазин для выбора и заказы обуви для всей семьи.
Для тестирования WEB приложения были разработаны API и UI тесты.
Тестирование проходит при использовании фреймворка Selenium.

Структура проекта: 
1. **listeners**
    - [x] TestListeners - класс для обработки событий, происходящих во время выполнения теста
2.  **pages**
    - [x] CartPage - локаторы и методы для страницы корзины с товаром
    - [x] HomePage - локаторы и методы для главной страницы
    - [x] LoginPage - локаторы и методы для страницы авторизации
    - [x] ProductPage - локаторы и методы для страницы с описанием конкретного товара
    - [x] ProfilePage - локаторы и методы для страницы авторизованного пользователя 
    - [x] SalePage - локаторы и методы для страницы с распродажей товаров
3. **utils**
   - [x] ConfProperties - класс для взаимодействия с файлом config.properties 
   - [x] DriverFactory - класс для добавления драйверов 
   - [x] ScreenShotUtils - утилита для создания скриншотов
   - [x] Waiters - класс для создания вейтеров (ожидания)
4. **resources**
   - [x] config.properties - файл с данными
   - [x] log4j2.properties - конфигурационный файл для логгеров
5. **tests**
   - [x] BaseTest - базовый класс для UI тестов
   - [x] APITests - класс с API тестами
   - [x] UITests - класс с UI тестами
6. **resources**
   - [x] json - файл с данными для API тестов
   - [x] suites - тест-сьюты для запуска тестов
   - [x] allure.properties - конфигурационный файл для создания отчетов