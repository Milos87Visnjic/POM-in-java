package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom_classes.BookingHomePage;

public class BookingTests extends BaseTest {

    @BeforeMethod
    public void setup() {
        baseSetup("CHROME", "99", 5);
    }

    @Test
    public void booking() {
        BookingHomePage bookingHomePage = new BookingHomePage(driver);
        String[] ages = {"3 years old","9 years old"};

       bookingHomePage.setWhereAreYouGoing("Kopaonik");
       bookingHomePage.checkInCheckOut("March 2022", "19", "July 2022", "20");
       bookingHomePage.addGuests(3, 2, ages, 2);
       bookingHomePage.search();

    }

    @AfterMethod
    public void tearDown() {
        baseTearDown();
    }

}