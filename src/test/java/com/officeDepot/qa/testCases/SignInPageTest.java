package com.officeDepot.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.officeDepot.qa.base.TestBase;
import com.officeDepot.qa.pages.HomePage;
import com.officeDepot.qa.pages.SignInPage;

public class SignInPageTest extends TestBase {
	
	SignInPage signInPage;
	HomePage homePage;
	
	public SignInPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		signInPage = new SignInPage();
	}
	@Test(priority=1)
	public void signInPageTitleTest() {
		String title = signInPage.validateSignInPageTitle();
	    Assert.assertEquals(title, "Log In to access your account information");
	}
	@Test(priority=2)
	public void officeDepotLogoTest() {
		boolean flag = signInPage.validateOfficeDepotLogo();
        Assert.assertTrue(flag);	
	}
	@Test(priority=3)
	public void signInPage() {
		homePage = signInPage.signIn(prop.getProperty("username"), prop.getProperty("password"));
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
}
