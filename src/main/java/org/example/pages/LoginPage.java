package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    /**
     * определение локатора поля ввода номера телефона
     */
    @FindBy(xpath = "//form[@class='v-form']//input[contains(@id, 'input-29') and @type='text']")
    private WebElement phoneNumberField;
    /**
     * определение локатора поля ввода пароля
     */
    @FindBy(xpath = "//form//input[contains(@id, 'input-') and @type='password']")
    private WebElement passwordField;
    /**
     * определение локатора кнопки "Войти"
     */
    @FindBy(xpath = "//*[contains(text(), 'Войти')] [1]")
    private WebElement loginBtn;
    /**
     * метод для ввода логина
     */
    public void inputPhoneNumber(String phone) {
        phoneNumberField.sendKeys(phone);
    }
    /**
     * метод для ввода пароля
     */
    public void inputPassword(String password) {
        passwordField.sendKeys(password);
    }
    /**
     * метод для осуществления нажатия кнопки входа в аккаунт
     */
    public void clickLoginBtn() {
        loginBtn.click();
    }
}

