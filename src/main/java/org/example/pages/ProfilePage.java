package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
    private WebDriver driver;
    public ProfilePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * определение локатора приветствия в профиле пользователя
     */
    @FindBy(xpath = "//*[@class = 'text-uppercase profile__title col col-12']")
    private WebElement profileTitle;
    /**
     * определение локатора кнопки выхода из профиля пользователя
     */
    @FindBy(xpath = "//*[contains(text(), 'Выйти')]")
    private WebElement logoutBtn;
    /**
     * определение локатора ошибки при неверно введенном пароле
     */
    @FindBy(xpath = "//div[@class='v-messages__message']")
    private WebElement errorTitle;


    /**
     * метод для получения имени пользователя из меню пользователя
     */
    public String getUserName() {
            return profileTitle.getText();
    }
    /**
     * * метод для осуществления нажатия кнопки выхода из профиля пользователя
     */
    public void clickLogoutBtn(){
        logoutBtn.click();
        }
    /**
     * метод для получения ошибки при неверно введенном пароле
     */
    public String getErrorText() {
        return errorTitle.getText();
    }
}