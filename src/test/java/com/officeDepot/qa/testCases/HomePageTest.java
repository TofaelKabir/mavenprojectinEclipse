package com.officeDepot.qa.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import com.officeDepot.qa.base.TestBase;
import com.officeDepot.qa.pages.DealsPage;
import com.officeDepot.qa.pages.HomePage;
import com.officeDepot.qa.pages.IdeasPage;

public class HomePageTest extends TestBase {
	HomePage homePage;
	DealsPage dealsPage;
	IdeasPage ideasPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	
	public void setUp() {
		initialization();
		homePage = new HomePage();
	}
	
	@Test()
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.validateHomePageTitle();
		Assert.assertEquals(homePageTitle, "Office Depot & OfficeMax", "Home Page Title doesn't match");
	}
	@Test()
	public void officeDepotLogoTest() {
		boolean flag = homePage.validateOfficeDepotLogo();
		Assert.assertTrue(flag);	
	}
	@Test
	public void verifyDealsLinkTest() {
		homePage.clickOnDealsLink();
	}
	@Test
	public void verifyIdeasLinkTest() {
		homePage.clickOnIdeasLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
