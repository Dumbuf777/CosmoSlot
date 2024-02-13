package com.Cosmoslots.utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	public static WebDriver driver;
	public ExtentReports extent;
	public static ExtentTest test;
	public static Logger logger;

	public ExtentReports extentSetup() {

		String repName = getClass().getSimpleName() + ".html";

		extent = new ExtentReports();
		String reportPath = ".//reports//" + repName;
		ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
		reporter.config().setReportName("Cosmoslots");
		reporter.config().setDocumentTitle("Cosmoslots Automation");
		reporter.config().setTheme(Theme.DARK);

		Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();

		extent.attachReporter(reporter);
		extent.setSystemInfo("Automation Engineer", "Shrikrsuhna Sonkar");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("Operating System Version", System.getProperty("os.version"));
		extent.setSystemInfo("Java Version", System.getProperty("java.version"));
		extent.setSystemInfo("Browser", capabilities.getBrowserName());
		extent.setSystemInfo("Browser Version", capabilities.getVersion());

		return extent;
	}

	public ExtentTest extentCreateTest(String testName) {
		test = extent.createTest(testName);
		return test;
	}

	public String takeScreenshot() {
		String source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		return source;
	}

	public Media extentScreenshot() {
		Media media = MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshot()).build();
		return media;
	}

	public void extentReportOpen() throws IOException {
		Desktop.getDesktop().browse(new File(System.getProperty("user.dir") + "//reports//report.html").toURI());
	}
}
