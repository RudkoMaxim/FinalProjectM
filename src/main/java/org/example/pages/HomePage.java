package org.example.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    /**
     * определение локатора кнопки подтверждения населенного пункта
     */
    @FindBy(xpath = "//*[@class = 'btn-gray v-btn v-btn--is-elevated v-btn--has-bg theme--light v-size--default'][1]")
    private WebElement daBtn;
    /**
     * определение локатора кнопки согласия с cookie
     */
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[7]/div[3]/button[2]/span")
    private WebElement cookieBtn;
    /**
     * определение локатора кнопки перехода на страницу логина
     */
    @FindBy(xpath = "//*[contains(text(), 'Профиль')] [1]")
    private WebElement profileBtn;
    /**
     * определение локатора кнопки перехода к поиску товара
     */
    @FindBy(xpath = "//*[@class='btn-text'][1]")
    private WebElement searchBtn;
    /**
     * определение локатора поля ввода для поиска товара
     */
    @FindBy(xpath = "//div[@class='v-text-field__slot']/input [1]")
    private WebElement searchInput;
    /**
     * определение локатора найденого товара по значению
     */
    @FindBy(xpath = "//*[@src='https://static.megatop.by/public/photo/0111311/320/0111311.jpg']")
    private WebElement searchResult;
    /**
     * определение локатора кнопки "Распродажа"
     */
    @FindBy(xpath = "//div[@class = 'static-link static-link__red']")
    private WebElement saleBtn;



    /**
     * метод для осуществления нажатия кнопки "ДА", подтверждения верно определенного населенного пункта
     */
    public void clickDaBtn() {
        daBtn.click();
    }
    /**
     * метод для осуществления нажатия кнопки согласия с cookie
     */
    public void clickCookieBtn() {cookieBtn.click();}
    /**
     * метод для осуществления нажатия кнопки перехода к странице авторизации
     */
    public void clickProfileBtn() {
        profileBtn.click();
    }
    /**
     * метод для осуществления нажатия кнопки поиска товара
     */
    public void clickSearchBtn(){
        searchBtn.click();
    }
    /**
     * метод для осуществления ввода значения для поиска
     */
    public void putValue(String value) {
        searchInput.sendKeys(value + Keys.ENTER);
    }
    /**
     * метод для осуществления нажатия по иконке найденного товара
     */
    public void clickSearchResultIcon(){
        searchResult.click();
    }
    /**
     * метод для осуществления нажатия по кнопке "Распродажа"
     */
    public void clickSaleBtn(){
        saleBtn.click();
    }
}
