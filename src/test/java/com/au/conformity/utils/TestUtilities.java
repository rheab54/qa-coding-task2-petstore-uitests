package com.au.conformity.utils;

import com.au.conformity.test.BaseTest;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestUtilities extends BaseTest {

    public static String takeScreenShot(String screenShotName, WebDriver driver) throws IOException {

        String df = new SimpleDateFormat("yyyyMMddhhss").format(new Date());

        TakesScreenshot ts = (TakesScreenshot)driver;

        File source = ts.getScreenshotAs(OutputType.FILE);

        String path = System.getProperty("user.dir") + "/test-output/screenshots/" + screenShotName + df + ".png";

        File destination = new File(path);

        FileUtils.copyFile(source, destination);

        return path;


    }




}
