package com.qa.opencart.utils;

import java.util.Arrays;
import java.util.List;

public class Constants {
	public static final String LOGIN_PAGE_TITLE = "Account Login";
	public static final String LOGIN_PAGE_URL = "account/login";
	public static final String ACCOUNTS_PAGE_TITLE = "My Account";
	public static final String ACCOUNTS_PAGE_URL = "account/account";
	public static final String ACCOUNTS_PAGE_HEADER = "Your Store";
	public static final List<String> EXP_ACC_SEC_LIST = Arrays.asList("My Account",
																		"My Orders",
																		"My Affiliate Account",
																		"Newsletter");
	public static final List<String> ACCOUNTS_PAGE_MYACCOUNT = Arrays.asList("Edit your account information",
																				"Change your password",
																				"Modify your address book entries",
																				"Modify your wish list");
	public static final List<String> ACCOUNTS_PAGE_MYORDERS = Arrays.asList("View your order history",
			 																	"Downloads",
			 																	"Your Reward Points",
			 																	"View your return requests",
			 																	"Your Transactions",
																				"Recurring payments");
	public static final String ACCOUNTS_PAGE_MYAFFACC = "Register for an affiliate account";
	public static final String ACCOUNTS_PAGE_NEWSLETTER = "Subscribe / unsubscribe to newsletter";
	public static final String LOGIN_PAGE_REGACC = "Register Account";
	public static final String LOGIN_PAGE_RETCUST = "I am a returning customer";
	public static final List<String> LOGIN_PAGE_HEADERS = Arrays.asList("New Customer",
			 																"Returning Customer");
	public static final String REGISTER_SUCCESS_MESSAGE = "Your Account Has Been Created!";
			
	public static final String REGISTER_SHEET_NAME = "register";
	

}
