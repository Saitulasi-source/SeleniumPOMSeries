package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	WebDriver driver;
	Properties prop;
	private OptionsManager optionsManager;

	public static String highlight = null;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public WebDriver init_driver(Properties prop) {
		highlight = prop.getProperty("highlight");
		optionsManager = new OptionsManager(prop);

		String browserName = prop.getProperty("browser").trim();
		System.out.println("browser name is : " + browserName);

		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
			// driver = new ChromeDriver(optionsManager.getChromeOptions());
		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
			// driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
		} else if (browserName.equals("safari")) {
			tlDriver.set(new SafariDriver());
			// driver = new SafariDriver();
		} else {
			System.out.println("Please pass the correct browser : " + browserName);
		}

		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().get(prop.getProperty("url"));

		return getDriver();
	}

	public static WebDriver getDriver() {
		return tlDriver.get();
	}

	public Properties init_prop() {
		prop = new Properties();
		FileInputStream ip = null;
		String env = System.getProperty("env");
		if (env == null) {
			try {
				System.out.println("Running on environment: --> On Prod");
				ip = new FileInputStream("./src/test/resources/config/config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				System.out.println("Running on environment: -->" + env);
				switch (env) {
				case "dev":
					ip = new FileInputStream("./src/test/resources/config/dev.config.properties");
					break;
				case "qa":
					ip = new FileInputStream("./src/test/resources/config/qa.config.properties");
					break;
				case "stage":
					ip = new FileInputStream("./src/test/resources/config/stage.config.properties");
					break;
				default:
					break;
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			prop.load(ip);
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOException");
			e.printStackTrace();
		}
		return prop;

	}

	public String getScreenshot() {
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}

}
