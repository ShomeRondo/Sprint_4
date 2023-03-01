import Pages.MainPage;
import Pages.OrderPage;
import extensions.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

@RunWith(Parameterized.class)

public class OrderTests {
    private WebDriver driver;
    private final int btnOrderIndex;
    private final String name;
    private final String surname;
    private final String adress;
    private final int metroStationIndex;
    private final String contactNumber;
    private final String dateForOrder;
    private final int rentalTimePeriodIndex;
    private final int scootersColorIndex;
    private final String comment;

    public OrderTests(int btnOrderIndex,
                      String name,
                      String surname,
                      String adress,
                      int metroStationIndex,
                      String contactNumber,
                      String dateForOrder,
                      int rentalTimePeriodIndex,
                      int scootersColorIndex,
                      String comment){
        this.btnOrderIndex = btnOrderIndex;
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.metroStationIndex = metroStationIndex;
        this.contactNumber = contactNumber;
        this.dateForOrder = dateForOrder;
        this.rentalTimePeriodIndex = rentalTimePeriodIndex;
        this.scootersColorIndex = scootersColorIndex;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] orderTestsData() {
        return new Object[][]{
                {0, "Ян", "Ли", "Питер", 5, "79999999999", "03.03.2023", 3, 0, ""},
                {1, "Марина", "Маринова", "Саранск ул Ленина д 15 кв 47 2 парадная код 45896", 120, "7999758325122","28.02.2023" ,1, 1, "Научите кататься?"},
                {0, "Кадрельмухаммет", "Азаров", "", 204, "89112223344", "20.03.2023",6, 0, "Просьба позвонить перед доставкой, могу быть не дома"}
        };
    }

    @Before
    public void setup() {
        driver = WebDriverFactory.get();
    }

    @Test
    public void checkOrdering(){
        MainPage mainPage = new MainPage(driver);
        mainPage.makeOrder(btnOrderIndex);
        OrderPage orderPage = new OrderPage(driver)
                .fillInputName(name)
                .fillInputSurname(surname)
                .fillInputAdress(adress)
                .fillInputMetroStation(metroStationIndex)
                .fillInputContactNumber(contactNumber)
                .clickBtnNext()
                .fillInputDateForOrder(dateForOrder)
                .fillInputRentalPeriod(rentalTimePeriodIndex)
                .fillInputScooterColor(scootersColorIndex)
                .fillInputComment(comment)
                .clickOrdering()
                .clickConfirmOrder()
                .clickViewOrderStatus();
    }

    @After
    public void teardown() {
        driver.quit();
    }

}
