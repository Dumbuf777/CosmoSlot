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
import org.openqa.selenium.Platform;


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

	//Last three method global variables
	private static Platform platform;
	private static String reportFileName = "ExtentReports-Version3-Test-Automaton-Report.html";
	private static String macPath = System.getProperty("user.dir") + "/TestReport";
	private static String windowsPath = System.getProperty("user.dir") + "\\TestReport";
	private static String macReportFileLoc = macPath + "/" + reportFileName;
	private static String winReportFileLoc = windowsPath + "\\" + reportFileName;

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
	
	 //Select the extent report file location based on platform
	  private static String getReportFileLocation (Platform platform) {
	        String reportFileLocation = null;
	        switch (platform) {
	            case MAC:
	                reportFileLocation = macReportFileLoc;
	                createReportPath(macPath);
	                System.out.println("ExtentReport Path for MAC: " + macPath + "\n");
	                break;
	            case WINDOWS:
	                reportFileLocation = winReportFileLoc;
	                createReportPath(windowsPath);
	                System.out.println("ExtentReport Path for WINDOWS: " + windowsPath + "\n");
	                break;
	            default:
	                System.out.println("ExtentReport path has not been set! There is a problem!\n");
	                break;
	        }
	        return reportFileLocation;
	    }
	  
	  //Create the report path if it does not exist
	    private static void createReportPath (String path) {
	        File testDirectory = new File(path);
	        if (!testDirectory.exists()) {
	            if (testDirectory.mkdir()) {
	                System.out.println("Directory: " + path + " is created!" );
	            } else {
	                System.out.println("Failed to create directory: " + path);
	            }
	        } else {
	            System.out.println("Directory already exists: " + path);
	        }
	    }
	    
	  //Get current platform
	    private static Platform getCurrentPlatform () {
	        if (platform == null) {
	            String operSys = System.getProperty("os.name").toLowerCase();
	            if (operSys.contains("win")) {
	                platform = Platform.WINDOWS;
	            } else if (operSys.contains("nix") || operSys.contains("nux")
	                    || operSys.contains("aix")) {
	                platform = Platform.LINUX;
	            } else if (operSys.contains("mac")) {
	                platform = Platform.MAC;
	            }
	        }
	        return platform;
	    }

}
