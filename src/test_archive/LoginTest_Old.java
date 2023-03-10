package test_archive;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.BaseClass;
import utils.ConfigsReader;
/**
 *  US 16457: As an Admin User, I should not be able to login to the application using invalid credentials.    <== High Level explanation of the feature.
 */
public class LoginTest_Old extends BaseClass {
    @BeforeMethod
    void startBrowser() {
        setUp();
    }
    @AfterMethod
    void quitBrowser() {
        tearDown();
    }
    @Test
    public void validAdminLogin() {
        LoginPage loginPage = new LoginPage();                                                    // Happy Path Testing
        sendText(loginPage.username, ConfigsReader.getProperties("username"));       // Valid Username
        sendText(loginPage.password, ConfigsReader.getProperties("password"));       // Valid Password
        click(loginPage.loginBtn);
        var dashboardPage = new DashboardPage();
        String expectedText = "Welcome Admin";
        String actualText = dashboardPage.welcome.getText();
        Assert.assertEquals(actualText, expectedText, "'Welcome Admin' text is incorrect");
    }

    @Test
    public void validUserInvalidPassword() {
        String invalidPassword = "Pass1234";
        String expectedErrorMessage = "Invalid credentials";
        LoginPage loginPage = new LoginPage();                                                     // Negative Testing
        sendText(loginPage.username, ConfigsReader.getProperties("username"));    // Valid Username
        sendText(loginPage.password, invalidPassword);                                // Invalid Password
        click(loginPage.loginBtn);
        Assert.assertEquals(loginPage.loginErrorMessage.getText(),expectedErrorMessage, "Error message is incorrect");
    }

    @Test
    public void validUserEmptyPassword() {
        String expectedErrorMessage = "Password cannot be empty";
        LoginPage loginPage = new LoginPage();                                                    // Negative Testing
        sendText(loginPage.username, ConfigsReader.getProperties("username"));   // Valid Username, Password empty (skipped).
        click(loginPage.loginBtn);
        Assert.assertEquals(loginPage.loginErrorMessage.getText(),expectedErrorMessage, "Error message is incorrect");
    }


}
