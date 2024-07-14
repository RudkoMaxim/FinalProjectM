package org.example;

import org.example.listeners.TestListeners;
import org.example.pages.HomePage;
import org.example.utils.ConfProperties;
import org.example.utils.DriverFactory;
import org.example.utils.Waiters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(TestListeners.class)
public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.createDriver("chrome");
        //открываем сайт МЕГАТОП
        driver.get(ConfProperties.getProperty("homepage"));
        driver.manage().window().maximize();
        Waiters.waitForSeconds(2);
        //подтверждаем город, в котором находимся

    }

    @AfterMethod
    public void closeSession() {
        driver.quit();
    }
}
