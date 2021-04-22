package com.qa.opencart.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class LoginPageNegativeTest extends BaseTest {

	@DataProvider
	public Object[][] loginNegativeData() {
		return new Object[][] {{"test@gmail.com", "test123"},
								{" ","test@123"},
								{"test11@gmail.com"," "},
								{" "," "}
								};
		}
	@Test(dataProvider = "loginNegativeData")
	public void loginNegativeTest(String un, String pwd) {
		lp.doLoginWrongData(un, pwd);
	}
	}

