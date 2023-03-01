package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {

    private final WebDriver driver;

    //заголовок
    private final By orderTitle = By.className("Order_Header__BZXOb");
    //поля для заказа первая часть
    private final By inputName = By.xpath(".//input[@placeholder = '* Имя']");
    private final By inputSurname = By.xpath(".//input[@placeholder = '* Фамилия']");
    private final By inputAdress = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    private final By inputMetroStation = By.className("select-search__input");
    private final By listOfMetroStations = By.xpath(".//div[@class = 'select-search__select']");
    private final By metroStation = By.xpath(".//div[@class = 'select-search__select']//li");
    private final By inputContactNumber = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");

    //кнопка "Далее"
    private final By btnNext = By.xpath(".//button[text() = 'Далее']");

    //поля для заказа вторая часть
    private final By inputDateForOrder =By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    private final By inputRentalTime = By.xpath(".//div[@class ='Dropdown-control']");
    private final By listOfRentalPeriods = By.xpath(".//div[@class = 'Dropdown-menu']//div");
    private final By scooterColors = By.xpath(".//div[@class = 'Order_Checkboxes__3lWSI']//input");
    private final By inputComment = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");

    //кнопка "Заказать"
    private final By btnSendOrder = By.xpath(".//div[@class='Order_Content__bmtHS']//button[text() = 'Заказать']");
    //кнопка подтверждения заказа
    private final By btnConfirmOrder = By.xpath(".//div[@class = 'Order_Buttons__1xGrp']//button[text() = 'Да']");

    //кнопка просмотра статуса заказа
    private final By btnViewOrderStatus = By.xpath(".//button[text(] = 'Посмотреть статус'");
    public OrderPage(WebDriver driver){
        this.driver = driver;
    }

    //заполнение полей
    public OrderPage fillInputName(String name){
        driver.findElement(inputName).sendKeys(name);
        return this;
    }
    public OrderPage fillInputSurname(String surname){
        driver.findElement(inputSurname).sendKeys(surname);
        return this;
    }
    public OrderPage fillInputAdress(String adress){
        driver.findElement(inputAdress).sendKeys(adress);
        return this;
    }
    public OrderPage fillInputMetroStation(int index){
        driver.findElement(inputMetroStation).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(listOfMetroStations));
        driver.findElements(metroStation).get(index).click();
        return this;
    }
    public OrderPage fillInputContactNumber(String phoneNumber){
        driver.findElement(inputContactNumber).sendKeys(phoneNumber);
        return this;

    }
    public OrderPage clickBtnNext(){
        driver.findElement(btnNext).click();
        return this;
    }
    public OrderPage fillInputDateForOrder(String dateForOrder){
        driver.findElement(inputDateForOrder).sendKeys(dateForOrder);
        driver.findElement(orderTitle).click();
        return this;
    }
    public OrderPage fillInputRentalPeriod(int index){
        driver.findElement(inputRentalTime).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(listOfRentalPeriods));
        driver.findElements(listOfRentalPeriods).get(index).click();
        return this;
    }

    public OrderPage fillInputScooterColor(int index){
        driver.findElements(scooterColors).get(index).click();
        return this;
    }

    public OrderPage fillInputComment(String comment){
        driver.findElement(inputComment).sendKeys(comment);
        return this;
    }

    public OrderPage clickOrdering(){
        driver.findElement(btnSendOrder).click();
        return this;
    }

    public OrderPage clickConfirmOrder(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(btnConfirmOrder));
        driver.findElement(btnConfirmOrder).click();
        return this;
    }

    public OrderPage clickViewOrderStatus(){
        driver.findElement(btnViewOrderStatus).click();
        return this;
    }



}
