package org.example;

import org.example.pages.*;
import org.example.utils.ConfProperties;
import org.example.utils.ScreenShotUtils;
import org.example.utils.Waiters;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UITests extends BaseTest{

    // Тест 1
    // Описание:
    //1. Пользователь открывает главную страницу;
    //2. Пользователь открывает страницу аутентификации;
    //3. Пользователь производит ввод валидных номера телефона и пароля;
    //4. Пользователь удостоверяется в успешной аутентификации — об этом свидетельствует приветствие по имени пользователя;
    //5. Пользователь осуществляет выход из аккаунта путем нажатия на "Выйти".
    @Test
    public void validPhoneAndPasswordTest() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        //подтверждаем наш населенный пункт
        homePage.clickDaBtn();
        //соглашаемся с принятием файлов cookie
        homePage.clickCookieBtn();
        //нажимаем кнопку входа в аккаунт
        homePage.clickProfileBtn();
        //вводим номер телефона
        loginPage.inputPhoneNumber(ConfProperties.getProperty("phone"));
        //вводим пароль
        loginPage.inputPassword(ConfProperties.getProperty("password"));
        //нажимаем кнопку входа
        loginPage.clickLoginBtn();
        //получаем отображаемое приветствие
        String user = profilePage.getUserName();
        //сравниваем ожидаемый и фактический результат
        Assert.assertEquals("ПРИВЕТ, МАКСИМ", user);
        ScreenShotUtils.takeScreenshot(driver);
        //делаем screenshot
        profilePage.clickLogoutBtn();
    }
    // Тест 2
    // Описание:
    //1. Пользователь открывает главную страницу;
    //2. Пользователь нажимает на кнопку "Поиск";
    //3. Пользователь вводит код товара и нажимает Enter;
    @Test
    public void searchProductTest() {
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        //подтверждаем наш населенный пункт
        homePage.clickDaBtn();
        //соглашаемся с принятием файлов cookie
        homePage.clickCookieBtn();
        //нажимаем на кнопку поиска
        homePage.clickSearchBtn();
        //ввод значения для поиска товара
        homePage.putValue(ConfProperties.getProperty("value"));
        //получаем title результата поиска
        String result = productPage.getSearchResult();
        //делаем screenshot
        ScreenShotUtils.takeScreenshot(driver);
        //сравниваем ожидаемый и фактический результат
        Assert.assertEquals("ПОИСК ПО ЗАПРОСУ '108329606'", result);
    }
    // Тест 3
    // Описание:
    //1. Пользователь открывает главную страницу;
    //2. Пользователь переходит на страницу "Распродажа";
    //3. Пользователь добавляет товар в корзину;

    @Test
    public void addToCartTest(){
        HomePage homePage = new HomePage(driver);
        SalePage salePage = new SalePage(driver);
        CartPage cartPage = new CartPage(driver);
        //подтверждаем наш населенный пункт
        homePage.clickDaBtn();
        //соглашаемся с принятием файлов cookie
        homePage.clickCookieBtn();
        //нажимаем на кнопку "Распродажа"
        homePage.clickSaleBtn();
        //нажимаем на кнопку добавления товара к корзину
        salePage.clickAddBtn();
        //нажимаем на кнопку выбора размера
        salePage.clickSizeSelectionBtn();
        //нажимаем на кнопку "Добавить в корзину"
        salePage.clickAddToCartBtn();
        //поиск наименования товара, добавленного в корзину
        String cart = cartPage.getProductTitleOnCart();
        //нажатие на кнопку закрытия корзины
        cartPage.clickCloseCartBtn();
        //поиск наименования товара на странице, который ранее был добавлен в корзину
        String main = salePage.getProductTitleOnPage();
        ScreenShotUtils.takeScreenshot(driver);
        //сравниваем наименвоание товара в корзине и на странице
        Assert.assertEquals(cart, main.replaceAll("\n"," "));
    }
    // Тест 4
    // Описание:
    //1. Пользователь открывает главную страницу;
    //2. Пользователь открывает страницу аутентификации;
    //3. Пользователь производит ввод валидного номера телефона и невалидного пароля;
    //4. Пользователь получает ошибку;
    @Test
    public void validPhoneAndInValidPasswordTest() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        ProductPage productPage = new ProductPage(driver);
        SalePage salePage = new SalePage(driver);
        //подтверждаем наш населенный пункт
        homePage.clickDaBtn();
        //соглашаемся с принятием файлов cookie
        homePage.clickCookieBtn();
        //нажимаем кнопку входа в аккаунт
        homePage.clickProfileBtn();
        //вводим номер телефона
        loginPage.inputPhoneNumber(ConfProperties.getProperty("phone"));
        //вводим пароль
        loginPage.inputPassword(ConfProperties.getProperty("invalidPassword"));
        //нажимаем кнопку входа
        loginPage.clickLoginBtn();
        //получаем ошибку
        String error = profilePage.getErrorText();
        //делаем screenshot
        ScreenShotUtils.takeScreenshot(driver);
        //сравниваем текст ошибки на экране и ожидаемый
        Assert.assertEquals("Вы ввели неверный номер телефона и/или пароль", error);
    }
}
