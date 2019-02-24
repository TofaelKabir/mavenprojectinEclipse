package com.officeDepot.qa.testCases;



import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.officeDepot.qa.base.TestBase;
import com.officeDepot.qa.pages.HomePage;
import com.officeDepot.qa.pages.SignInPage;
import com.officeDepot.qa.util.TestUtil;

public class SignInPageTest extends TestBase {
	
	SignInPage signInPage;
	HomePage homePage;
	TestUtil testUtil;
	
	public SignInPageTest() {
		super();
	}
	@BeforeMethod
	
	public void setUp() throws InterruptedException{
		initialization();
		String ParentWindowHandler = driver.getWindowHandle();
		driver.switchTo().window(ParentWindowHandler);
		testUtil = new TestUtil();
		homePage = new HomePage();
		homePage = signInPage.signIn(prop.getProperty("emailAddress"), prop.getProperty("password"));
		
	}
	@Test(priority=1)
	public void verifySignInPageTitleTest() {
		String signInPageTitle = signInPage.validateSignInPageTitle();
	    AssertJUnit.assertEquals(signInPageTitle, "Office Depot & OfficeMax", "SignIn Page Title doesn't match");
	}
	@Test(priority=2)
	public void verifyUserNameTest(){
		testUtil.switchToFrame();
		AssertJUnit.assertTrue(signInPage.verifyCorrectUserName());
	}
	@AfterMethod
	
	public void tearDown() {
		driver.close();
	}
	
	

	

	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser
	//@test -- execute test case
	//after each test case -- close the browser
	
	
	
	
	
	
	
	

	
}
