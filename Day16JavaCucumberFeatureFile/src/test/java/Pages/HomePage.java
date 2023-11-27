package Pages;

import Utilities.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    public void GoToTMPage(WebDriver driver2)
    {
        //Navigate to time and material
        WebElement Administration = driver2.findElement(By.xpath("/html/body/div[3]/div/div/ul/li[5]/a"));
        Administration.click();

        Wait.WaitToBeClickable(driver2, "Xpath", "/html/body/div[3]/div/div/ul/li[5]/ul/li[3]/a", 3);
        WebElement timeAndMaterial = driver2.findElement(By.xpath("/html/body/div[3]/div/div/ul/li[5]/ul/li[3]/a"));
        timeAndMaterial.click();
    }

    public void GoToEmployeePage(WebDriver driver1)
    {
        //Navigate to time and material
        WebElement Administration = driver1.findElement(By.xpath("/html/body/div[3]/div/div/ul/li[5]/a"));
        Administration.click();

        Wait.WaitToBeClickable(driver1, "Xpath", "/html/body/div[3]/div/div/ul/li[5]/ul/li[2]/a", 3);
        WebElement employee = driver1.findElement(By.xpath("/html/body/div[3]/div/div/ul/li[5]/ul/li[2]/a"));
        employee.click();
    }
}
