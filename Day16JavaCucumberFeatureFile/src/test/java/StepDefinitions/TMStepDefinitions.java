package StepDefinitions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.TMPage;
import Utilities.CommonDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class TMStepDefinitions extends CommonDriver {
    TMPage tmPageObject = new TMPage();
    LoginPage loginPageObj = new LoginPage();
    HomePage homePageObj = new HomePage();

    @Before
    public void LoginActions() {

        // Launch Chrome browser
        driver2 = new ChromeDriver();
    }


    @Given("I logged into turnup portal successfully")
    public void i_logged_into_turnup_portal_successfully() {
        // Write code here that turns the phrase above into concrete actions
        driver2 = new ChromeDriver();
        loginPageObj.LoginAction(driver2);
        loginPageObj.LoginActionTM(driver2);
    }
    @When("I navigate to time and material page")
    public void iNavigateToTimeAndMaterialPage() {
        homePageObj.GoToTMPage(driver2);
    }

    @Then("I create a new {string}, {string}, {string} in time record")
    public void iCreateANewCodeDescriptionPriceInTimeRecord(String code, String description, String price) {
        tmPageObject.Create_TimeRecord(driver2, code, description,price);
    }

    @Then("the time record should be created {string}, {string}, {string} successfully")
    public void theTimeRecordShouldBeCreatedCodeDescriptionPriceSuccessfully(String code, String description, String price) {
        String newCode = tmPageObject.GetCode(driver2);
        String newDescription = tmPageObject.GetDescription(driver2);
        String newPrice =tmPageObject.GetPrice(driver2);
        Assert.assertEquals(newCode, code, "New Code and expected code do Not match.");
        Assert.assertEquals(newDescription, description, "New Description and expected code do Not match.");
        Assert.assertEquals(newPrice, price, "New Price and expected code do Not match.");


    }

    @When("I update the {string}, {string} of an existing time record")
    public void iUpdateTheCodeDescriptionOfAnExistingTimeRecord(String code, String description) {
        tmPageObject.Update_TimeRecord(driver2, code, description);
    }

    @Then("the time record should be updated {string}, {string} successfully")
    public void theTimeRecordShouldBeUpdatedCodeDescriptionSuccessfully(String code, String description) {
        String editedCode = tmPageObject.GetCode(driver2);
        String editedDescription = tmPageObject.GetDescription(driver2);
        Assert.assertEquals(editedCode, code, "New Code and expected code do Not match.");
        Assert.assertEquals(editedDescription, description, "New Description and expected code do Not match.");
    }

    @Then("I delete a time record {string}, {string}, {string}")
    public void iDeleteATimeRecordCodeDescriptionPrice(String code, String description, String price) {
        tmPageObject.Delete_TimeRecord(driver2, code, description, price);
    }

    @Then("the time record should be deleted {string}, {string}, {string} successfully")
    public void theTimeRecordShouldBeDeletedCodeDescriptionPriceSuccessfully(String code, String description, String price) {
        String DeletedRecord = tmPageObject.GetLastRecordDeleted(driver2);
        Assert.assertNotEquals(DeletedRecord, code, "Last record is equal to 'TanEdit3'.");

        String DeletedRecordcode = tmPageObject.GetLastRecordDeleted(driver2);
        String DeletedRecordDescription = tmPageObject.GetLastRecordDeletedDescription(driver2);
        String DeletedRecordprice = tmPageObject.GetLastRecordDeletedprice(driver2);
        Assert.assertNotEquals(DeletedRecordcode, code, "Last record is equal to 'TanEdit3'.");
        Assert.assertNotEquals(DeletedRecordDescription, description, "Last record is equal to 'TanEdit3Des'.");
        Assert.assertNotEquals(DeletedRecordprice, price, "Last record is equal to '$113.00' .");

    }

    @After
    public void CloseTestRun() {
        driver2.quit();

    }
}
