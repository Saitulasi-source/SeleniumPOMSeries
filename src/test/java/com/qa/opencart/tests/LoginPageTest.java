package com.qa.opencart.tests;

import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Epic 500 : Design Login Page for Demo Cart application")
@Story("US 100 : Develop a feature with all Login Page scenarios")
public class LoginPageTest extends BaseTest {
	@Description("Login Page Title Test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = lp.getLoginPageTitle();
		System.out.println("Login page title is : " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}

	@Description("Login Page URL Test")
	@Severity(SeverityLevel.MINOR)
	@Test(priority = 2)
	public void loginPageURLTest() {
		String url = lp.getLoginPageURL();
		Assert.assertTrue(url.contains(Constants.LOGIN_PAGE_URL));
	}

	@Description("Login Page Forget Password Link Test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 3)
	public void forgotPwdLinkTest() {
		Assert.assertTrue(lp.isForgotPwdLinkExist());
	}

	@Description("Login Page Register Account Test")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void regAccountTest() {
		Assert.assertEquals(lp.getRegAccText(), Constants.LOGIN_PAGE_REGACC);
	}

	@Description("Login Page Return Customer Test")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void returnCustTest() {
		Assert.assertEquals(lp.getReturnCustText(), Constants.LOGIN_PAGE_RETCUST);
	}

	@Description("Login Page Continue Button Exist Test")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void continueButExistTest() {
		Assert.assertTrue(lp.isContinueButExist());
	}

	@Description("Login Page Headers Test")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void loginPageHeadersTest() {
		List<String> headersList = lp.getLoginPageHeaders();
		headersList.stream().forEach(e -> System.out.println(e));
		Collections.sort(Constants.LOGIN_PAGE_HEADERS);
		Assert.assertEquals(headersList, Constants.LOGIN_PAGE_HEADERS);
	}

	@Description("Login Test")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority = 4)
	public void loginTest() {
		lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));

	}

}
