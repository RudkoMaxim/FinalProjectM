package org.example.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SalePage {
    private WebDriver driver;
    public SalePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    JavascriptExecutor js = (JavascriptExecutor) driver;
    /**
     * определение локатора наименования товара на странице
     */
    @FindBy(xpath = "//a[@href='/products/1185000012-slancy-enjoin_' and @class='']")
    private WebElement productTitleOnPage;
    /**
     * определение локатора кнопки добавдения товара
     */
    @FindBy(xpath = "//*[@src= 'https://static.megatop.by/public/site_static/icons/mobile/busket2.svg'][1]")
    private WebElement addBtn;
    /**
     * определение локатора кнопки выбора размера
     */
    @FindBy(xpath = "//td[@class= 'text'][1]")
    private WebElement sizeSelectionBtn;
    /**
     * определение локатора кнопки "Добавить в корзину"
     */
    @FindBy(xpath = "//*[contains(text(), 'Добавить в корзину')]")
    private WebElement addToCartBtn;



    /**
     * метод для осуществления поиска наименования товара на странице
     */
    public String getProductTitleOnPage() {
        js.executeScript("window.scrollBy(0,500)");
        return productTitleOnPage.getText();
    }
    /**
     * метод для осуществления нажатия по кнопке добавления товара в корзину
     */
    public void clickAddBtn(){
        addBtn.click();
    }
    /**
     * метод для осуществления нажатия по кнопке выбора размера
     */
    public void clickSizeSelectionBtn(){
        sizeSelectionBtn.click();
    }
    /**
     * метод для осуществления нажатия по кнопке "Добавить в корзину"
     */
    public void clickAddToCartBtn(){
        addToCartBtn.click();
    }
}
