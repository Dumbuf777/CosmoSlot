package com.Cosmoslots.website;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.net.HttpURLConnection;
import java.net.URL;
import com.Cosmoslots.utilities.ReadConfig;

public class demo2 {
	public static void main(String[] args) throws InterruptedException {
//		
//		System.out.println("Hello World");
//		// Get today's date
//		 // Get today's date
//        LocalDate today = LocalDate.now();
//        System.out.println("Today: " + today);
//
//        // Get yesterday's date
//        LocalDate yesterday = today.minusDays(1);
//        System.out.println("Yesterday: " + yesterday);
//
//        // Get the start and end date of the current week
//        LocalDate startOfWeek = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));
//        LocalDate endOfWeek = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY));
//        System.out.println("This week - Start Date: " + startOfWeek + ", End Date: " + endOfWeek);
//
//        // Get the start and end date of the last week
//        LocalDate startOfLastWeek = startOfWeek.minusDays(7);
//        LocalDate endOfLastWeek = endOfWeek.minusDays(7);
//        System.out.println("Last week - Start Date: " + startOfLastWeek + ", End Date: " + endOfLastWeek);

		ReadConfig readconfig = new ReadConfig();
		System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
		WebDriver driver = new ChromeDriver();

		// Navigate to BStackDemo Website
		driver.get("https://www.amazon.com/");
		

		// Finding all the available links on webpage
		List<WebElement> links = driver.findElements(By.tagName("a"));

		// Iterating each link and checking the response status
		for (WebElement link : links) {
			String url = link.getAttribute("href");
			verifyLink(url);
		}

		driver.quit();
	}

	public static void verifyLink(String url) {
		try {
			URL link = new URL(url);
			HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
			httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
			httpURLConnection.connect();

			if (httpURLConnection.getResponseCode() == 200) {
				System.out.println(url + " - " + httpURLConnection.getResponseMessage());
			} else {
				System.out.println(url + " - " + httpURLConnection.getResponseMessage() + " - " + "is a broken link");
			}
		} catch (Exception e) {
			System.out.println(url + " - " + "is a broken link");
		}
	}

}
