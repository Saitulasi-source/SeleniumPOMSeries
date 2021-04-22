package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage {
	private WebDriver driver;
	private ElementUtil elementUtil;
	private By username = By.id("input-email");
	private By password = By.id("input-password");
	private By loginButton = By.xpath("//input[@type='submit']");
	private By forgotPwdLink = By.xpath("//div[@class = 'form-group']//a[text()='Forgotten Password']");
	private By loginPageHeaders = By.cssSelector("div.well h2");
	private By regAcc = By.xpath("(//div[@class='well']/p)[1]");
	private By continueButton = By.linkText("Continue");
	private By returnCust = By.xpath("(//div[@class='well']/p)[3]");
	private By registerLink = By.linkText("Register");
	private By loginErrorMsg = By.cssSelector("div.alert.alert-danger.alert-dismissible");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	@Step("getting Login Page Title")
	public String getLoginPageTitle() {
		return elementUtil.waitForTitle(5, Constants.LOGIN_PAGE_TITLE);
	}

	@Step("getting Login Page URL")
	public String getLoginPageURL() {
		return elementUtil.getPageUrl();
	}

	@Step("Getting ForgotPwd Link exist")
	public boolean isForgotPwdLinkExist() {
		return elementUtil.doIsDisplayed(forgotPwdLink);
	}

	@Step("getting Register Account Text")
	public String getRegAccText() {
		return elementUtil.doGetText(regAcc);
	}

	@Step("getting Return Customer Text")
	public String getReturnCustText() {
		return elementUtil.doGetText(returnCust);
	}

	@Step("getting isContinue Button exist")
	public boolean isContinueButExist() {
		return elementUtil.doIsDisplayed(continueButton);
	}

	@Step("Navigating to Registration Page")
	public RegistrationPage doRegister() {
		elementUtil.doClick(registerLink);
		return new RegistrationPage(driver);
	}

	@Step("getting Login Page Headers")
	public List<String> getLoginPageHeaders() {
		List<String> headersValList = new ArrayList<String>();
		List<WebElement> headersList = elementUtil.getElements(loginPageHeaders);
		for (WebElement e : headersList) {
			headersValList.add(e.getText());
		}
		Collections.sort(headersValList);
		return headersValList;
	}

	@Step("Login with Username : {0} and Password : {1}")
	public AccountsPage doLogin(String un, String pwd) {
		elementUtil.doSendKeys(username, un);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginButton);
		return new AccountsPage(driver);
	}

	@Step("Login with Username : {0} and Password : {1}")
	public boolean doLoginWrongData(String un, String pwd) {
		elementUtil.doSendKeys(username, un);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginButton);
		return elementUtil.doIsDisplayed(loginErrorMsg);
	}

}
