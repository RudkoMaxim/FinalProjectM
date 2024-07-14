package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    private WebDriver driver;
    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    /**
     * определение локатора наименования товара в корзине
     */
    @FindBy(xpath = "//div[@class = 'product__title']")
    private WebElement productTitleOnCart;
    /**
     * определение локатора кнопки закрыть корзину
     */
    @FindBy(xpath = "//div[@class = 'v-responsive__content'][1]")
    private WebElement closeCartBtn;


    /**
     * метод для осуществления поиска наименования товара в корзине
     */
    public String getProductTitleOnCart() {
        return productTitleOnCart.getText();
    }
    /**
     * метод для осуществления нажатия по кнопке "Закрыть корзину"
     */
    public void clickCloseCartBtn(){
        closeCartBtn.click();
    }
}
