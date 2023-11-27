package Pages;

import Utilities.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public void LoginAction(WebDriver driver1)
    {
        //driver.Manage().Timeouts().ImplicitWait = TimeSpan.FromSeconds(5);
        driver1.manage().window().maximize();

        //Lunch TurnUp Portal and navigate to the website login page
        driver1.navigate().to("http://horse.industryconnect.io/Account/Login?ReturnUrl=%2f");
        //wait.WaitToExist(driver1, "Xpath", "//*[@id='UserName']", 8);

        //user login
        WebElement usernameTextbox = driver1.findElement(By.xpath("//*[@id='UserName']"));
        usernameTextbox.sendKeys("hari");

        WebElement passwordTextbox = driver1.findElement(By.xpath("//*[@id=\"Password\"]"));
        passwordTextbox.sendKeys("123123");

        WebElement loginButton = driver1.findElement(By.xpath("//*[@id='loginForm']/form/div[3]/input[1]"));
        loginButton.click();

    }

    public void LoginActionTM(WebDriver driver2)
    {
        //driver.Manage().Timeouts().ImplicitWait = TimeSpan.FromSeconds(5);
        driver2.manage().window().maximize();

        //Lunch TurnUp Portal and navigate to the website login page
        driver2.navigate().to("http://horse.industryconnect.io/Account/Login?ReturnUrl=%2f");
        Wait.WaitToExist(driver2, "Xpath", "//*[@id='UserName']", 8);
        //user login
        WebElement usernameTextbox = driver2.findElement(By.xpath("//*[@id='UserName']"));
        usernameTextbox.sendKeys("TanyaN");

        WebElement passwordTextbox = driver2.findElement(By.xpath("//*[@id=\"Password\"]"));
        passwordTextbox.sendKeys("123123");

        WebElement loginButton = driver2.findElement(By.xpath("//*[@id='loginForm']/form/div[3]/input[1]"));
        loginButton.click();

    }
}
