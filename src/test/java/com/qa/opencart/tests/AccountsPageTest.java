package com.qa.opencart.tests;

import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.Error;

public class AccountsPageTest extends BaseTest {

	@BeforeClass
	public void accPageSetup() {
		ap = lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test
	public void accPageTitleTest() {
		String title = ap.getAccountsPageTitle();
		System.out.println("Accounts Page Title : " + title);
		Assert.assertEquals(title, Constants.ACCOUNTS_PAGE_TITLE, Error.ACC_PAGE_TITLE_ERROR);
	}

	@Test
	public void accPageURLTest() {
		String URL = ap.getAccountsPageURL();
		System.out.println("Accounts Page URL : " + URL);
		Assert.assertTrue(URL.contains(Constants.ACCOUNTS_PAGE_URL));
	}

	@Test
	public void accPageHeaderTest() {
		Assert.assertEquals(ap.getAccountsPageHeader(), Constants.ACCOUNTS_PAGE_HEADER, Error.ACC_PAGE_HEADER_ERROR);
	}

	@Test
	public void accSectionListTest() {
		List<String> secList = ap.getAccountsSectionsList();
		secList.stream().forEach(e -> System.out.println(e));
		Collections.sort(Constants.EXP_ACC_SEC_LIST);
		Assert.assertEquals(secList, Constants.EXP_ACC_SEC_LIST);
	}

	@Test
	public void logoutLinkTest() {
		Assert.assertTrue(ap.isLogoutExist(), Error.LOGOUT_LINK_NOT_PRESENT);
	}

	@Test
	public void passwordLinkTest() {
		Assert.assertTrue(ap.isPasswordExist(), Error.PASSWORD_LINK_NOT_PRESENT);
	}

	@Test
	public void wishListLinkTest() {
		Assert.assertTrue(ap.isWishlistExist(), Error.WISHLIST_LINK_NOT_PRESENT);
	}

	@Test
	public void myAccSecListTest() {
		List<String> myAccSecList = ap.getMyAccountSectionList();
		myAccSecList.stream().forEach(e -> System.out.println(e));
		Collections.sort(Constants.ACCOUNTS_PAGE_MYACCOUNT);
		Assert.assertEquals(myAccSecList, Constants.ACCOUNTS_PAGE_MYACCOUNT);
	}

	@Test
	public void myOrdSecListTest() {
		List<String> myOrdSecList = ap.getMyOrderSectionList();
		myOrdSecList.stream().forEach(e -> System.out.println(e));
		Collections.sort(Constants.ACCOUNTS_PAGE_MYORDERS);
		Assert.assertEquals(myOrdSecList, Constants.ACCOUNTS_PAGE_MYORDERS);
	}

	@Test
	public void myAffAccSecTest() {
		String myAffAccSecVal = ap.getMyAffAccSection();
		System.out.println(myAffAccSecVal);
		Assert.assertEquals(myAffAccSecVal, Constants.ACCOUNTS_PAGE_MYAFFACC);
	}

	@Test
	public void newsletSecListTest() {
		String newsletSecVal = ap.getNewsletSection();
		System.out.println(newsletSecVal);
		Assert.assertEquals(newsletSecVal, Constants.ACCOUNTS_PAGE_NEWSLETTER);
	}

}
