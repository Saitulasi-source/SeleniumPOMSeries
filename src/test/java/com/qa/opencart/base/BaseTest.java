package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.listeners.TestAllureListener;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.RegistrationPage;

@Listeners(TestAllureListener.class)
public class BaseTest {
	DriverFactory df;
	private WebDriver driver;
	public Properties prop;

	public LoginPage lp;
	public AccountsPage ap;
	public RegistrationPage rp;

	@Parameters({ "browser" })
	@BeforeTest
	public void setUp(String browserName) {
		df = new DriverFactory();
		prop = df.init_prop();
		prop.setProperty("browser", browserName);
		driver = df.init_driver(prop);
		lp = new LoginPage(driver);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
