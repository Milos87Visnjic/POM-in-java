//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package pom_classes;

import java.util.List;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver;
    int waitTime = 30;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickElement(WebElement element, String log) {
        Actions actions;
        try {
            WebDriverWait wdWait = new WebDriverWait(this.driver, (long)this.waitTime);
            wdWait.until(ExpectedConditions.visibilityOf(element));
            wdWait.until(ExpectedConditions.elementToBeClickable(element));
            actions = new Actions(this.driver);
            actions.moveToElement(element).click().build().perform();
            System.out.println("Clicked " + log);
        } catch (StaleElementReferenceException var5) {
            actions = new Actions(this.driver);
            actions.moveToElement(element).click().build().perform();
            System.out.println("Clicked " + log);
        }

    }

    public void typeText(WebElement element, String text, String log) {
        try {
            WebDriverWait wdWait = new WebDriverWait(this.driver, (long)this.waitTime);
            wdWait.until(ExpectedConditions.visibilityOf(element));
            element.clear();
            element.sendKeys(new CharSequence[]{text});
            System.out.println("Typed text: " + text + " into " + log);
        } catch (StaleElementReferenceException var5) {
            element.clear();
            element.sendKeys(new CharSequence[]{text});
            System.out.println("Typed text: " + text + " into " + log);
        }

    }

    public String getText(WebElement element, String log) {
        try {
            WebDriverWait wdWait = new WebDriverWait(this.driver, (long)this.waitTime);
            wdWait.until(ExpectedConditions.visibilityOf(element));
            System.out.println("Get text from " + log);
            return element.getText();
        } catch (StaleElementReferenceException var4) {
            System.out.println("Get text from " + log);
            return element.getText();
        }
    }

             public boolean isElementPresent(List<WebElement> elements) {
        return elements.size() > 0;
    }
             public void selectByText(WebElement element, String[] text, String log) {
             Select select;
             try {
                 WebDriverWait wdWait = new WebDriverWait(this.driver, (long)this.waitTime);
                 wdWait.until(ExpectedConditions.visibilityOf(element));
                 wdWait.until(ExpectedConditions.elementToBeClickable(element));
                 select = new Select(element);
                 select.selectByVisibleText(String.valueOf(text));
             }
             catch (StaleElementReferenceException var6) {
                select = new Select(element);
                select.selectByVisibleText(String.valueOf(text));
                 System.out.println("Selected " + text + " " + log);
        }

    }

    public void selectByText(WebElement element, String text, String log) {
        Actions actions;
        try {
            WebDriverWait wdWait = new WebDriverWait(this.driver, (long)this.waitTime);
            wdWait.until(ExpectedConditions.visibilityOf(element));
            wdWait.until(ExpectedConditions.elementToBeClickable(element));
            Select select = new Select(element);
            select.selectByVisibleText(text);
            System.out.println("Selected "+text+ " " +log);
        } catch (StaleElementReferenceException e) {
            Select select = new Select(element);
            select.selectByVisibleText(text);
            System.out.println("Selected "+text+ " " +log);
        }

    }
}