package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {
	private WebDriver driver;
	ElementUtil elementUtil;

	private By accPageHeaders = By.cssSelector("div#content h2");
	private By header = By.cssSelector("div#logo a");
	private By logoutLink = By.linkText("Logout");
	private By passwordLink = By.linkText("Password");
	private By wishListLink = By.linkText("Wish List");
	private By myAccSecList = By.cssSelector("div#content ul.list-unstyled:nth-of-type(1) li");
	private By myOrdSecList = By.cssSelector("div#content ul.list-unstyled:nth-of-type(2) li");
	private By myAffAccSecList = By.cssSelector("div#content ul.list-unstyled:nth-of-type(3) li");
	private By newsletSecList = By.cssSelector("div#content ul.list-unstyled:nth-of-type(4) li");

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public String getAccountsPageTitle() {
		return elementUtil.waitForTitle(5, Constants.ACCOUNTS_PAGE_TITLE);
	}

	public String getAccountsPageURL() {
		return elementUtil.getPageUrl();
	}

	public String getAccountsPageHeader() {
		return elementUtil.doGetText(header);
	}

	public List<String> getAccountsSectionsList() {
		List<String> accSecValList = new ArrayList<String>();
		List<WebElement> accSecList = elementUtil.waitForVisibilityOfElements(accPageHeaders, 5);
		for (WebElement e : accSecList) {
			accSecValList.add(e.getText());
		}
		Collections.sort(accSecValList);
		return accSecValList;
	}

	public boolean isLogoutExist() {
		return elementUtil.doIsDisplayed(logoutLink);
	}

	public boolean isPasswordExist() {
		return elementUtil.doIsDisplayed(passwordLink);
	}

	public boolean isWishlistExist() {
		return elementUtil.doIsDisplayed(wishListLink);
	}

	public List<String> getMyAccountSectionList() {
		List<String> myAccSecValList = new ArrayList<String>();
		List<WebElement> myAccList = elementUtil.waitForVisibilityOfElements(myAccSecList, 5);
		for (WebElement e : myAccList) {
			myAccSecValList.add(e.getText());
		}
		Collections.sort(myAccSecValList);
		return myAccSecValList;
	}

	public List<String> getMyOrderSectionList() {
		List<String> myOrdSecValList = new ArrayList<String>();
		List<WebElement> myOrdList = elementUtil.waitForVisibilityOfElements(myOrdSecList, 5);
		for (WebElement e : myOrdList) {
			myOrdSecValList.add(e.getText());
		}
		Collections.sort(myOrdSecValList);
		return myOrdSecValList;
	}

	public String getMyAffAccSection() {
		String myAffAccSecVal = elementUtil.doGetText(myAffAccSecList);
		return myAffAccSecVal;
	}

	public String getNewsletSection() {
		String newsletSecVal = elementUtil.doGetText(newsletSecList);
		return newsletSecVal;
	}

}
