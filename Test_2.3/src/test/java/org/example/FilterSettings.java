package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilterSettings {

    public WebDriver driver;
    public FilterSettings(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    // Выбор региона
    // локатор кнопки "Выбор города"
    @FindBy(xpath = "//a[@href='https://auto.drom.ru/cities/']")
    private static WebElement choosingArea;

    // локатор кнопки выбора региона "Приморский край"
    @FindBy(xpath = "//div[text()='Приморский край']")
    private static WebElement primorye;

    // Локатор кнопки "Все города региона"
    @FindBy(xpath = "//div[text()='Все города региона']")
    private static WebElement allCity;

    // метод нажатия на кнопку "Другой город"
    public static void clickChoosingArea() {
        choosingArea.click();
    }

    // метод нажатия на кнопку "Приморский край"
    public static void clickPrimorye() {
        primorye.click();
    }

    // метод нажатия на кнопку "Все города региона"
    public static void clickAllCity() {
        allCity.click();
    }

}
