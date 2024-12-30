package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.BaseTest;
import utilities.ScreenshotUtil;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin() {
        driver.get("https://example.com/login"); // Replace with the actual URL

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("validUser");
        loginPage.enterPassword("validPassword");
        loginPage.clickLogin();

        Assert.assertTrue(driver.getTitle().contains("Dashboard"), "Login failed for valid credentials");
    }

    @Test
    public void testInvalidLogin() {
        driver.get("https://example.com/login"); // Replace with the actual URL

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("invalidUser");
        loginPage.enterPassword("invalidPassword");
        loginPage.clickLogin();

        String errorMessage = loginPage.getErrorMessage();
        Assert.assertTrue(errorMessage.contains("Invalid credentials"), "Error message not displayed as expected");

        ScreenshotUtil.captureScreenshot(driver, "testInvalidLogin");
    }
}
