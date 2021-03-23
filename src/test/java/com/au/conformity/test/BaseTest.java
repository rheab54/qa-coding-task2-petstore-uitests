package com.au.conformity.test;

import com.au.conformity.util.PropertyUtils;
import com.au.conformity.utils.ExtentReporting;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * The base class covers initialise and teardown for chrome browser
 *
 */

public class BaseTest {

    public WebDriver driver;
    public static ExtentReports report = ExtentReporting.getExtentInstance();
    public static ExtentTest test;

    @BeforeMethod
    public void initiateDriver(ITestContext context) throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get(PropertyUtils.get("BASE_URL"));
        driver.manage().window().maximize();
        context.setAttribute("driver", driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
