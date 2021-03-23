package com.au.conformity.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporting {

    public static ExtentSparkReporter htmlReporter;
    public static ExtentReports extent;

    public static ExtentReports getExtentInstance() {
        if (extent == null) {
            htmlReporter = new ExtentSparkReporter(
                    System.getProperty("user.dir") + "/test-output/screenshots/AutomationReport.html");

            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);

            extent.setSystemInfo("Host Name", "Conformity");
            extent.setSystemInfo("Environment", "PROD");
            extent.setSystemInfo("User Name", "Rao");

            htmlReporter.config().setDocumentTitle("Extent Report Results");
            htmlReporter.config().setReportName("Pet Store - Test Automation results");
            htmlReporter.config().setTheme(Theme.STANDARD);
        }
        return extent;
    }
}
