package Pages;
import org.testng.Assert;
import Utilities.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TMPage {
    public void Create_TimeRecord(WebDriver driver2, String code, String description, String price)
    {
        Wait.WaitToBeClickable(driver2, "Xpath","//*[@id=\"container\"]/p/a", 5);
        //Add
        WebElement createNew = driver2.findElement(By.xpath("//*[@id=\"container\"]/p/a"));
        createNew.click();
        WebElement typeCode = driver2.findElement(By.xpath("//*[@id=\"TimeMaterialEditForm\"]/div/div[1]/div/span[1]/span/span[1]"));
        typeCode.click();
        WebElement typeCodeTime = driver2.findElement(By.xpath("//*[@id='TypeCode_listbox']/li[2]"));
        typeCodeTime.click();
        WebElement createCode = driver2.findElement(By.xpath("//*[@id=\"Code\"]"));
        createCode.sendKeys(code);
        WebElement createDescription = driver2.findElement(By.xpath("//*[@id=\"Description\"]"));
        createDescription.sendKeys(description);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement pricePerUnit = driver2.findElement(By.xpath("//*[@id=\"TimeMaterialEditForm\"]/div/div[4]/div/span[1]/span/input[1]"));
        pricePerUnit.sendKeys(price);
        WebElement createSave = driver2.findElement(By.xpath("//*[@id=\"SaveButton\"]"));
        createSave.click();
        Wait.WaitToBeClickable(driver2, "Xpath", "//*[@id=\"tmsGrid\"]/div[4]/a[4]/span", 3);
        ////Go to last page
        //IWebElement lastPage = driver2.FindElement(By.XPath("//*[@id=\"tmsGrid\"]/div[4]/a[4]/span"));
        //lastPage.Click();
        //IWebElement newCode = driver2.FindElement(By.XPath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));
        //Assert.That(newCode.Text == "HelloTan", "Record has not been created.");
        //Thread.Sleep(1000);

        // Check if new record has been created successfully
        try
        {
            WebElement goToLastPageButton = driver2.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[4]/a[4]/span"));
            goToLastPageButton.click();
        }
        catch (Exception ex)
        {
            Assert.fail("Go to last page button hasn't been found.");
        }

    }

    public void Update_TimeRecord(WebDriver driver2, String code, String description)
    {
        Wait.WaitToBeClickable(driver2, "Xpath", "//*[@id=\"tmsGrid\"]/div[4]/a[4]/span", 5);
        WebElement lastPage = driver2.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[4]/a[4]/span"));
        lastPage.click();
        //Edit
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement editLastRecord = driver2.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[5]/a[1]"));
        editLastRecord.click();
        Wait.WaitToBeClickable(driver2, "Xpath", "//*[@id=\"Code\"]", 3);

        WebElement editCode = driver2.findElement(By.xpath("//*[@id=\"Code\"]"));
        editCode.clear();
        editCode.sendKeys(code);
        WebElement editDescription = driver2.findElement(By.xpath("//*[@id=\"Description\"]"));
        editDescription.clear();
        editDescription.sendKeys(description);
        WebElement EditSave = driver2.findElement(By.xpath("//*[@id=\"SaveButton\"]"));
        EditSave.click();
        Wait.WaitToBeClickable(driver2, "Xpath", "/html/body/div[4]/div/div/div[4]/a[4]/span", 3);

        //Go to last page
        WebElement lastPageEdit = driver2.findElement(By.xpath("/html/body/div[4]/div/div/div[4]/a[4]/span"));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        lastPageEdit.click();
        WebElement newCodeEdit = driver2.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));
        Assert.assertEquals(newCodeEdit.getText(), code, "Record has not been created.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    public void Delete_TimeRecord(WebDriver driver2, String code, String description,String price)
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement lastPage = driver2.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[4]/a[4]/span"));
        lastPage.click();
        WebElement newCodeDelete = driver2.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));
        Assert.assertEquals(newCodeDelete.getText(), code, "Record has not been deleted.");
        WebElement newDescriptionDelete = driver2.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[3]"));
        Assert.assertEquals(newDescriptionDelete.getText(), description, "Record has not been deleted.");
        WebElement newpriceDelete = driver2.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[4]"));
        Assert.assertEquals(newpriceDelete.getText(),price, "Record has not been deleted.");
        WebElement lastPageRecordDelete = driver2.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[5]/a[2]"));
        lastPageRecordDelete.click();
        driver2.switchTo().alert().accept();
        // IWebElement lastRecordElement = driver2.FindElement(By.XPath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[3]/a[2]"));

        // // Get the text of the last record
        //string lastRecordText = lastRecordElement.Text;

        // // Assert that the last record is not equal to "HelloTan1"
        // Assert.AreNotEqual("HelloTan1", lastRecordText, "Last record is equal to 'HelloTan1'.");
        // Thread.Sleep(4000);
    }
    //

    public String GetCode(WebDriver driver2)
    {
        WebElement newCode = driver2.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));
        return newCode.getText();
    }

    public String GetDescription(WebDriver driver2)
    {
        WebElement newDescription = driver2.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[3]"));
        return newDescription.getText();
    }

    public String GetPrice(WebDriver driver2)
    {
        WebElement newPrice = driver2.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[4]"));
        return newPrice.getText();
    }

    public String GetLastRecordDeleted(WebDriver driver2)
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement lastRecordElement = driver2.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));
        return lastRecordElement.getText();
    }

    public String GetLastRecordDeletedDescription(WebDriver driver2)
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement lastRecordElementDescription = driver2.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[3]"));
        return lastRecordElementDescription.getText();
    }

    public String GetLastRecordDeletedprice(WebDriver driver2)
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement lastRecordElementprice = driver2.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[4]"));
        return lastRecordElementprice.getText();
    }
}
