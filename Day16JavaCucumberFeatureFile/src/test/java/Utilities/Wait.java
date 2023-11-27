package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wait {

    public static void WaitToBeClickable(WebDriver driver, String locatorType, String locatorValue, int seconds)
    {
        var wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        if(locatorType =="Xpath")
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorValue)));
        }
        if (locatorType == "Id")
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.id(locatorValue)));
        }
        if (locatorType == "CssSelector")
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locatorValue)));
        }
        if (locatorType == "ClassName")
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.className(locatorValue)));
        }

    }

    public static void WaitToExist(WebDriver driver, String locatorType, String locatorValue, int seconds)
    {
        var wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        if (locatorType == "Xpath")
        {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorValue)));
        }
        if (locatorType == "Id")
        {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locatorValue)));
        }
        if (locatorType == "CssSelector")
        {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locatorValue)));
        }
        if (locatorType == "ClassName")
        {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.className(locatorValue)));
        }

    }

    public static void ElementIsVisible(WebDriver driver, String locatorType, String locatorValue, int seconds)
    {
        var wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        if (locatorType == "Xpath")
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
        }
        if (locatorType == "Id")
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
        }
        if (locatorType == "CssSelector")
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorValue)));
        }
        if (locatorType == "ClassName")
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locatorValue)));
        }

    }

}
