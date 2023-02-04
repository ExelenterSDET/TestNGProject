package test;

import pages.LoginPage;
import utils.BaseClass;
import utils.ConfigsReader;

public class _01_LoginTest extends BaseClass {
    public static void main(String[] args) {
        setUp();
// Note: Make sure you comment out one before using the other.
        // Without PageFactory
//        var loginPage = new _01_LoginPageWithoutPageFactory();
//        sendText(loginPage.username, ConfigsReader.getProperties("username"));
//        sendText(loginPage.password, ConfigsReader.getProperties("password"));
//        click(loginPage.loginBtn);

        // With PageFactory
        var login = new LoginPage();
        sendText(login.username, ConfigsReader.getProperties("username"));
        sendText(login.password, ConfigsReader.getProperties("password"));
        click(login.loginBtn);

        tearDown();
    }
}
