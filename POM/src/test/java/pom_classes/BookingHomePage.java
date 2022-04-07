package pom_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class BookingHomePage extends BasePage {

    WebDriver driver;

    public BookingHomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='ss']")
    WebElement whereAreYouGoing;

    @FindBy(xpath = "//div[@class='xp__dates xp__group']")
    WebElement checkInCheckOut;

    @FindBy(css = ".bui-calendar__month")
    List<WebElement> months;

    @FindBy(css = "[data-bui-ref='calendar-next']")
    WebElement nextMonth;  //arrow for calendar

    public void Clickdate(String monthYear, String day) {
        while (true) {
            if (driver.findElements(By.xpath("//div[text()='" + monthYear + "']")).size() == 0) {
                clickElement(nextMonth, "Clicked: next month");
            } else {
                clickElement(driver.findElement(By.xpath("//div[text()='" + monthYear + "']/..//span[text()='" + day + "']")), "Clicked:" + monthYear + " " + day);
                break;
            }
        }

    }

    @FindBy(css = "button[data-sb-id='main']")
    WebElement search;

    @FindBy(css = ".xp__guests")
    WebElement guests;

    @FindBy(xpath = "//label[text()='Adults']/../..//button[contains(@class,'add')]")
    WebElement adultsAdd;

    @FindBy(xpath = "//label[text()='Adults']/../..//button[contains(@class,'sub')]")
    WebElement adultsSub;

    @FindBy(xpath = "//label[text()='Children']/../..//button[contains(@class,'add')]")
    WebElement childrenAdd;

    @FindBy(xpath = "//label[text()='Children']/../..//button[contains(@class,'sub')]")
    WebElement ChildrenSub;

    @FindBy(xpath = "//label[text()='Rooms']/../..//button[contains(@class,'add')]")
    WebElement roomsAdd;

    @FindBy(xpath = "//label[text()='Rooms']/../..//button[contains(@class,'sub')]")
    WebElement roomsSub;

    @FindBy(css = "[name='age']")
    List<WebElement> childrenAge;

    public void setWhereAreYouGoing(String location) {
        typeText(whereAreYouGoing, location, "Typed:" + location);
        clickElement(driver.findElement(By.xpath("//li//span[text()='" + location + "' and @class='search_hl_name']")), "Clicked: " + location);
    }

    public void checkInCheckOut(String checkInMonthYear, String checkInDate, String checkOutMonthYear, String checkOutDate) {
     //   clickElement(checkInCheckOut, "Clicked: check In / Check Out");
        Clickdate(checkInMonthYear, checkInDate);
        Clickdate(checkOutMonthYear, checkOutDate);

    }

    /**
     *
     * @param adultNum  Add additional adults (1 set already)
     * @param childrenNum  Add children
     * @param childrenAge  Add children age
     * @param roomsNum  Add additional rooms (1 set already)
     */

    public void addGuests(int adultNum, int childrenNum, String[] childrenAge, int roomsNum) {
        clickElement(guests, "Clicked: Guests");

                addAdultsNum(adultNum);
        addChildrenNum(childrenNum, childrenAge);
        addRoomsNum(roomsNum);

    }

    public void addAdultsNum(int num) {
        for (int i = 1; i < num; i++) {
            clickElement(adultsAdd, "Clicked: Add Adults");
        }
    }

    public void addRoomsNum(int num) {
        for (int i = 1; i < num; i++) {
            clickElement(roomsAdd, "Clicked: Add Rooms");
        }

    }

    public void addChildrenNum(int num, String[] year) {
        for (int i = 1; i<=num;i++) {
            clickElement(childrenAdd, "Clicked: Add Children");
            selectByText(childrenAge.get(i-1),year[i-1], "from child age select");
        }

    }

    public void search(){

        clickElement(search, "Clicked: Search");
    }
}