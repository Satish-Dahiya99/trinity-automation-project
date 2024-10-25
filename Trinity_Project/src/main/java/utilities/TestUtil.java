package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;


public class TestUtil {

    public static void waitForElementClickable(WebDriver driver, WebElement element, Duration timeOut){
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    public static void waitForElementVisible(WebDriver driver, WebElement element, Duration timeOut){
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public static void waitForElementsVisible(WebDriver driver, List<WebElement> elements, Duration timeOut){
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));

    }

    public static void staticWait(long time ) throws InterruptedException {
        Thread.sleep(time);
    }

    public static void waitForElementToDisappear(WebDriver driver, WebElement element, Duration timeOut){
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.invisibilityOf(element));

    }


}
