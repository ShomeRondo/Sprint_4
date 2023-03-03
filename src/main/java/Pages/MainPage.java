package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private final WebDriver driver;

    //кнопки для перехода к заказу

    private final By btnOrder = By.xpath(".//button[text()='Заказать']");

    //список вопросов
    private final By listOfQuestions = By.xpath(".//div[@class='accordion__item']");
    private final By answer =  By.xpath(".//div[@class='accordion__item']//p");


    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    //переход к заказу
    public OrderPage makeOrder(int index) {
        WebElement element = driver.findElements(btnOrder).get(index);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElements(btnOrder).get(index).click();
        return new OrderPage(driver);
    }

    //клик по вопросу
    public MainPage clickQuestion(int index) {
        WebElement element = driver.findElements(listOfQuestions).get(index);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElements(listOfQuestions).get(index).click();
        return this;
    }
    //получение текста ответа
    public String getAnswerTexts(int index){
        return driver.findElements(answer).get(index).getText();
    }

}
