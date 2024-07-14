Выпускной проект Рудько Максима

Для подготовки выпускного проекта для тестирования используется сайт https://megatop.by/. 
Мегатоп онлайн-магазин для выбора и заказы обуви для всей семьи.
Для тестирования WEB приложения были разработаны API и UI тесты.
Тестирование проходит при использовании фреймворка Selenium.

Структура проекта: 
1. listeners
   *TestListeners 
3. Pages
   *CartPage
   *HomePage
   *LoginPage
   *ProductPage
   *ProfilePage
   *SalePage
4. utils
   *ConfProperties
   *DriverFactory
   *ScreenShotUtils
   *Waiters
5. resources
   *config.properties
   *log4j2.properties
6. tests
   *BaseTest
   *APITests
   *UITests
7. resources
   *json
   *suites
   *allure.properties