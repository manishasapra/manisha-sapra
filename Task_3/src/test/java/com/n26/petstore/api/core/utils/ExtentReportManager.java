package com.n26.petstore.api.core.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.util.Date;

/**
 * This class is responsible for managing extent reports
 * - Initialization of reports
 * - Path
 * - Config
 * - Info
 */
public class ExtentReportManager {

    private static ExtentReports extent;

    /**
     * This method is responsible to get the instance of Extent Report.
     *
     * @return Instance
     */
    public static ExtentReports getInstance() {
        if(extent == null) {
            ExtentSparkReporter reporter = new ExtentSparkReporter(getReportDirectory());
            reporter.config().setDocumentTitle("Automation Setup");
            reporter.config().setReportName("Regression");
            extent = new ExtentReports();
            extent.attachReporter(reporter);
            extent.setSystemInfo("Company", "N26");
            extent.setSystemInfo("Brand", "Pet Shop");
            extent.setSystemInfo("OS", System.getProperty("os.name"));
        }
        return extent;
    }

    /**
     * This method is responsible to get the path where extent reports will be saved.
     *
     * @return Path of extent report
     */
    public static String getReportDirectory() {
        Date timeStamp = new Date();
        String fileName = timeStamp.toString().replace(":", "_").replace(" ", "_") + ".html";
        return System.getProperty("user.dir") + "/target/Reports/" + fileName;
    }
}
