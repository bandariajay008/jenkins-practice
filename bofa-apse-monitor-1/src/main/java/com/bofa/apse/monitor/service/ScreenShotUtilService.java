package com.bofa.apse.monitor.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.springframework.stereotype.Service;

@Service
public class ScreenShotUtilService {

	public String captureScreenShot() throws Exception {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.speedtest.net/");
		driver.manage().window().maximize();

		try {
			WebElement consent = driver.findElement(By.id("onetrust-accept-btn-handler"));
			consent.click();
		} catch (NoSuchElementException e) {
			System.out.println("No cookie popup found.");
		}
		String s = driver.getTitle();
		String before = extracted(driver);

		Thread.sleep(5000);
		WebElement goButton = driver.findElement(By.cssSelector(".start-text"));
		goButton.click();
		System.out.println("Speed test started...");

		Thread.sleep(5000);

		String after = extracted(driver);

		System.out.println("Screenshot saved at: " + before);
		System.out.println("Screenshot saved at: " + after);

		return "Application Title " + s;

	}

	private String extracted(WebDriver driver) throws IOException {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File fileSource = takesScreenshot.getScreenshotAs(OutputType.FILE);

		Date currentdate = new Date();

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_DD_HH_mm_ss");
		String timeStamp = dateFormat.format(currentdate);

		String fileName = "src/main/resources/screenshot_" + timeStamp + ".png";
		FileHandler.copy(fileSource, new File(fileName));
		return fileName;
	}

}
