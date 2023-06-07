package com.leadconsult.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class CustomWebDriverManager {
	public enum CustomWebDriverManagerEnum {
		INSTANCE;
		private WebDriver driver = setupBrowser();


		private WebDriver setupBrowser(){
			WebDriverManager.chromedriver().setup();


			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--window-size=1280,800");
			chromeOptions.addArguments("--headless");

			WebDriver chromeDriver = new ChromeDriver(chromeOptions);
			chromeDriver.manage().window().maximize();
			driver = chromeDriver;
			return chromeDriver;
		}


		public void quitDriver() {
			if (driver != null) {
				driver.quit();
				driver = null;
			}
		}

		public WebDriver getDriver() {
			if (driver == null){
				setupBrowser();
			}
			return driver;
		}
	}
}
