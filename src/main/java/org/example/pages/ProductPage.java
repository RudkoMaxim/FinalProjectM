package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    private WebDriver driver;
    public ProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    /**
     * определение локатора результата поиска
     */
    @FindBy(xpath = "//h1[@class='catalog__title text-uppercase' and @data-v-8b85e2f2='']")
    private WebElement searchResult;
    /**
     * метод для получения кода товара на странице товара
     */
    public String getSearchResult() {
        return searchResult.getText();
    }
}
