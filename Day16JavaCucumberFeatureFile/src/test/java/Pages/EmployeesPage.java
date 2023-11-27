package Pages;
import org.testng.Assert;
import Utilities.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmployeesPage {
    public void Create_EmployeeRecord(WebDriver driver1) {
        Wait.WaitToBeClickable(driver1, "Xpath", "//*[@id=\"container\"]/p/a", 5);
        WebElement createNewEmployee = driver1.findElement(By.xpath("//*[@id=\"container\"]/p/a"));
        createNewEmployee.click();
        WebElement EmployeeName = driver1.findElement(By.xpath("//*[@id=\"Name\"]"));
        EmployeeName.sendKeys("EmpTanya");
        WebElement EmployeeUserName= driver1.findElement(By.xpath("//*[@id=\"Username\"]"));
        EmployeeUserName.sendKeys("EmpTanyaUser");
        WebElement EmployeeContact = driver1.findElement(By.xpath("//*[@id=\"EditContactButton\"]"));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        EmployeeContact.click();

        driver1.switchTo().frame(0);
        Wait.WaitToBeClickable(driver1, "Xpath", "//*[@id=\"FirstName\"]", 5);
        WebElement EmployeeFirstName = driver1.findElement(By.xpath("//*[@id=\"FirstName\"]"));
        EmployeeFirstName.sendKeys("EmpTanyaFirstUser");
        WebElement EmployeeLastName = driver1.findElement(By.xpath("//*[@id=\"LastName\"]"));
        EmployeeLastName.sendKeys("EmpTanyaLastUser");
        WebElement EmployeePreferedName = driver1.findElement(By.xpath("//*[@id=\"PreferedName\"]"));
        EmployeePreferedName.sendKeys("EmpTanyaPFName");
        WebElement EmployeePhoneName = driver1.findElement(By.xpath("//*[@id=\"Phone\"]"));
        EmployeePhoneName.sendKeys("0000000000");
        WebElement EmployeeEmail = driver1.findElement(By.xpath("//*[@id=\"email\"]"));
        EmployeeEmail.sendKeys("yyy@hotmail.com");
        WebElement EmployeeContactSave = driver1.findElement(By.xpath("//*[@id=\"submitButton\"]"));
        EmployeeContactSave.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver1.switchTo().defaultContent();
        WebElement EmployeePassword = driver1.findElement(By.xpath("//*[@id=\"Password\"]"));
        EmployeePassword.sendKeys("123123");
        WebElement EmployeeRetypePassword = driver1.findElement(By.xpath("//*[@id=\"RetypePassword\"]"));
        EmployeeRetypePassword.sendKeys("123123");

        WebElement EmployeeContactCreateSave = driver1.findElement(By.xpath("//*[@id=\"SaveButton\"]"));
        EmployeeContactCreateSave.click();
        WebElement EmployeeContactBackToList = driver1.findElement(By.xpath("//*[@id=\"container\"]/div/a"));
        EmployeeContactBackToList.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement EmployeeLastPage = driver1.findElement(By.xpath("//*[@id=\"usersGrid\"]/div[4]/a[4]/span"));
        EmployeeLastPage.click();
        WebElement newEmployeeName = driver1.findElement(By.xpath("//*[@id=\"usersGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));
        Assert.assertEquals(newEmployeeName.getText(), "EmpTanya", "Record has not been created.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    public void Edit_EmployeeRecord(WebDriver driver1)
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement EmployeeLastPage = driver1.findElement(By.xpath("//*[@id=\"usersGrid\"]/div[4]/a[4]/span"));
        EmployeeLastPage.click();
        WebElement EmployeeEdit = driver1.findElement(By.xpath("//*[@id=\"usersGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));
        Assert.assertEquals(EmployeeEdit.getText() == "EmpTanya", "New Code is not show and expected code do Not match.");
        WebElement EmployeeEditclick = driver1.findElement(By.xpath("//*[@id=\"usersGrid\"]/div[3]/table/tbody/tr[last()]/td[3]/a[1]"));
        EmployeeEditclick.click();
        Wait.WaitToBeClickable(driver1, "Xpath", "//*[@id=\"Name\"]", 5);
        WebElement EmployeeName = driver1.findElement(By.xpath("//*[@id=\"Name\"]"));
        EmployeeName.clear();
        EmployeeName.sendKeys("EmpTanyaEdit");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement EmployeeContactEditSave = driver1.findElement(By.xpath("//*[@id=\"SaveButton\"]"));
        EmployeeContactEditSave.click();
        EmployeeContactEditSave.click();
        WebElement EmployeeContactBackToList = driver1.findElement(By.xpath("//*[@id=\"container\"]/div/a"));
        EmployeeContactBackToList.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement EmployeeLastPageEdit = driver1.findElement(By.xpath("//*[@id='usersGrid']/div[4]/a[4]/span"));
        EmployeeLastPageEdit.click();
        //IWebElement EmployeeEditName = driver1.FindElement(By.XPath("//*[@id=\"usersGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));
        // Assert.That(EmployeeEditName.Text == "EmpTanyaEdit", "Record has not been Edited.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void Delete_EmployeeRecord(WebDriver driver1)
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement EmployeeLastPage = driver1.findElement(By.xpath("//*[@id=\"usersGrid\"]/div[4]/a[4]/span"));
        EmployeeLastPage.click();
        WebElement EmployeeDeleteCheck = driver1.findElement(By.xpath("//*[@id=\"usersGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));
        Assert.assertEquals(EmployeeDeleteCheck.getText() == "EmpTanyaEdit", "New Code is not show and expected code do Not match.");
        WebElement EmployeeDelete = driver1.findElement(By.xpath("//*[@id=\"usersGrid\"]/div[3]/table/tbody/tr[last()]/td[3]/a[2]"));
        EmployeeDelete.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver1.switchTo().alert().accept();

        //   IWebElement lastRecordElement = driver.FindElement(By.XPath("//*[@id=\"usersGrid\"]/div[3]/table/tbody/tr[last()]/td[3]/a[2]"));

        // Get the text of the last record
        //   string lastRecordText = lastRecordElement.Text;

        // Assert that the last record is not equal to "EmpTanyaEdit"
        //  Assert.AreNotEqual("EmpTanyaEdit", lastRecordText, "Last record is equal to 'EmpTanyaEdit'.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    public String GetnewEmployeeName(WebDriver driver1)
    {
        WebElement newEmployeeName = driver1.findElement(By.xpath("//*[@id=\"usersGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));
        return newEmployeeName.getText();
    }

    public String GetnewEmployeeNameEdit(WebDriver driver1)
    {
        WebElement newEmployeeNameEdit = driver1.findElement(By.xpath("//*[@id=\"usersGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));
        return newEmployeeNameEdit.getText();
    }

    public String GetLastRecordDeleted(WebDriver driver1)
    {
        WebElement lastRecordElement = driver1.findElement(By.xpath("//*[@id=\"usersGrid\"]/div[3]/table/tbody/tr[last()]/td[3]/a[2]"));
        return lastRecordElement.getText();
    }
}
